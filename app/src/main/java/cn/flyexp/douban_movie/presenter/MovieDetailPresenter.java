package cn.flyexp.douban_movie.presenter;

import android.util.Log;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import cn.flyexp.douban_movie.base.BasePresenter;
import cn.flyexp.douban_movie.model.MovieDetailModel;
import cn.flyexp.douban_movie.model.MovieSubjectsModel;
import cn.flyexp.douban_movie.net.NetWork;
import cn.flyexp.douban_movie.presenter.ipresenter.IMovieDetailPresenter;
import cn.flyexp.douban_movie.view.iview.IMovieDetailView;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Won on 2017/3/15.
 */

public class MovieDetailPresenter extends BasePresenter<IMovieDetailView> implements IMovieDetailPresenter {

    private static final String TAG = "MovieDetailPresenter";

    private Observer<MovieDetailModel> observer = new Observer<MovieDetailModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "onError: ", e);
            if (e.getMessage().contains("HTTP 404 Not Found")) {
                mView.showError(true);
            } else {
                mView.showError(false);
            }
        }

        @Override
        public void onNext(MovieDetailModel movieDetailModel) {
            mView.showComplete(movieDetailModel);
            //数据库不存在此数据就插入
            if (DataSupport.where("movie_id = ?", movieDetailModel.getMovie_id()).find(MovieDetailModel.class).size() < 1) {
                for (MovieDetailModel.CastsBean castsBean : movieDetailModel.getCasts()) {
                    if (castsBean.getAvatars() != null) {
                        castsBean.getAvatars().save();
                        castsBean.save();
                    }
                }
                for (MovieDetailModel.DirectorsBean directorsBean : movieDetailModel.getDirectors()) {
                    if (directorsBean.getAvatars() != null) {
                        directorsBean.getAvatars().save();
                        directorsBean.save();
                    }
                }
                movieDetailModel.getImages().save();
                movieDetailModel.getRating().save();
                movieDetailModel.save();
            }
        }
    };


    @Override
    public void loadingData(String id) {
        mView.showLoading();
        //先检测数据库数据库是否存在数据
        final MovieDetailModel movieDetailModel = DataSupport.where("movie_id = ?", id).findFirst(MovieDetailModel.class, true);
        if (movieDetailModel == null) {
            //无则网络请求
            subscription = NetWork.getDouBanApi()
                    .getMovieDetail(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        } else {
            //有则直接显示数据
            Observable.create(new Observable.OnSubscribe<MovieDetailModel>() {
                @Override
                public void call(Subscriber<? super MovieDetailModel> subscriber) {
                    //先相继取出内部类中相关联表的数据
                    //取出演员信息
                    List<MovieDetailModel.CastsBean> castsBeans = new ArrayList<>();
                    for (MovieDetailModel.CastsBean castsBean : movieDetailModel.getCasts()) {
                        castsBeans.add(DataSupport.where("cast_id = ?", castsBean.getId()).findFirst(MovieDetailModel.CastsBean.class, true));
                    }
                    movieDetailModel.setCasts(castsBeans);
                    //取出导演信息
                    List<MovieDetailModel.DirectorsBean> directorsBeans = new ArrayList<>();
                    for (MovieDetailModel.DirectorsBean directorsBean : movieDetailModel.getDirectors()) {
                        directorsBeans.add(DataSupport.where("director_id = ?", directorsBean.getId()).findFirst(MovieDetailModel.DirectorsBean.class, true));
                    }
                    movieDetailModel.setDirectors(directorsBeans);
                    //显示数据
                    subscriber.onNext(movieDetailModel);
                }
            })
                    .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                    .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                    .subscribe(new Action1<MovieDetailModel>() {
                        @Override
                        public void call(MovieDetailModel movieDetailModel) {
                            //显示数据
                            mView.showComplete(movieDetailModel);
                        }
                    });
        }

    }

    @Override
    public boolean isFavorite(String id) {
        return DataSupport.where("movie_id = ?", id).find(MovieSubjectsModel.class).size() > 0;
    }

    @Override
    public boolean saveFavorite(MovieSubjectsModel movieSubjectsModel) {
        try {
            for (MovieSubjectsModel.CastsBean castsBean : movieSubjectsModel.getCasts()) {
                if (castsBean.getAvatars() != null) {
                    castsBean.getAvatars().saveThrows();
                    castsBean.saveThrows();
                }
            }
            for (MovieSubjectsModel.DirectorsBean directorsBean : movieSubjectsModel.getDirectors()) {
                if (directorsBean.getAvatars() != null) {
                    directorsBean.getAvatars().saveThrows();
                    directorsBean.saveThrows();
                }
            }
            movieSubjectsModel.getImages().saveThrows();
            movieSubjectsModel.getRating().saveThrows();
            movieSubjectsModel.saveThrows();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteFavorite(String id) {
        return DataSupport.deleteAll(MovieSubjectsModel.class, "movie_id = ?", id) > 0;
    }

    @Override
    protected void onDestroy() {
        unsubscribe();
    }
}
