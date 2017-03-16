package cn.flyexp.douban_movie.presenter;

import android.util.Log;

import cn.flyexp.douban_movie.base.BasePresenter;
import cn.flyexp.douban_movie.model.MovieDetailModel;
import cn.flyexp.douban_movie.net.NetWork;
import cn.flyexp.douban_movie.presenter.ipresenter.IMovieDetailPresenter;
import cn.flyexp.douban_movie.view.iview.IMovieDetailView;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
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
            mView.showError();
        }

        @Override
        public void onNext(MovieDetailModel movieDetailModel) {
            mView.showComplete(movieDetailModel);
        }
    };


    @Override
    public void loadingData(String id) {
        mView.showLoading();
        subscription = NetWork.getDouBanApi()
                .getMovieDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    protected void onDestroy() {
        unsubscribe();
    }
}
