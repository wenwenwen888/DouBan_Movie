package cn.flyexp.douban_movie.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import cn.flyexp.douban_movie.base.BasePresenter;
import cn.flyexp.douban_movie.model.MovieModel;
import cn.flyexp.douban_movie.model.TagData;
import cn.flyexp.douban_movie.net.NetWork;
import cn.flyexp.douban_movie.presenter.ipresenter.IMoviePresenter;
import cn.flyexp.douban_movie.view.iview.IMovieView;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Won on 2017/3/12.
 */

public class MoviePresenter extends BasePresenter<IMovieView> implements IMoviePresenter {

    private static final String TAG = "MoviePresenter";

    private int start = 0;
    //关键字
    private String artist;

    private Observer<MovieModel> observer = new Observer<MovieModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "onError: ", e);
            mView.showError();
        }

        @Override
        public void onNext(MovieModel movieModel) {
            if (movieModel.getSubjects().size() > 0) {
                mView.showComplete((ArrayList<?>) movieModel.getSubjects());
                start = start + movieModel.getSubjects().size();
            } else {
                mView.showEmpty();
            }

        }
    };

    @Override
    public void loadingData(boolean isRefresh) {
        mView.showLoading();
        if (isRefresh) {
            artist = TagData.artists[new Random().nextInt(37)];
            start = 0;
        }
        subscription = NetWork.getDouBanApi()
                .searchTag(artist, start, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    protected void onDestroy() {
        unsubscribe();
    }
}
