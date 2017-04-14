package cn.flyexp.douban_movie.presenter;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import cn.flyexp.douban_movie.base.BasePresenter;
import cn.flyexp.douban_movie.model.MovieSubjectsModel;
import cn.flyexp.douban_movie.presenter.ipresenter.IFavoritePresenter;
import cn.flyexp.douban_movie.view.iview.IFavoriteView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Won on 2017/3/12.
 */

public class FavoritePresenter extends BasePresenter<IFavoriteView> implements IFavoritePresenter {

    private static final String TAG = "FavoritePresenter";

    @Override
    public void loadData() {
        mView.showLoading();

        Observable.create(new Observable.OnSubscribe<List<MovieSubjectsModel>>() {
            @Override
            public void call(Subscriber<? super List<MovieSubjectsModel>> subscriber) {
                //数据库取出数据
                subscriber.onNext(DataSupport.order("id desc").find(MovieSubjectsModel.class, true));
            }
        })
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Action1<List<MovieSubjectsModel>>() {
                    @Override
                    public void call(List<MovieSubjectsModel> movieSubjectsModels) {
                        //判断有无数据
                        if (movieSubjectsModels.size() > 0) {
                            mView.showComplete(movieSubjectsModels);
                        } else {
                            mView.showEmpty();
                        }
                    }
                });
    }

    @Override
    public boolean deleteData(ArrayList<String> selectIds) {
        for (String id : selectIds) {
            DataSupport.deleteAll(MovieSubjectsModel.class, "movie_id = ?", id);
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        unsubscribe();
    }

}
