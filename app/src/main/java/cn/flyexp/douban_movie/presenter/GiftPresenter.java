package cn.flyexp.douban_movie.presenter;

import android.util.Log;

import java.util.ArrayList;

import cn.flyexp.douban_movie.base.BasePresenter;
import cn.flyexp.douban_movie.model.GiftModel;
import cn.flyexp.douban_movie.net.NetWork;
import cn.flyexp.douban_movie.presenter.ipresenter.IGiftPresenter;
import cn.flyexp.douban_movie.view.iview.IGiftView;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Won on 2017/3/12.
 */

public class GiftPresenter extends BasePresenter<IGiftView> implements IGiftPresenter {

    private static final String TAG = "GiftPresenter";

    private int page = 1;

    private Observer<GiftModel> observer = new Observer<GiftModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "onError: ", e);
            mView.showError();
        }

        @Override
        public void onNext(GiftModel giftModel) {
            if (giftModel.getResults().size() > 0) {
                mView.showComplete((ArrayList<?>) giftModel.getResults());
                page++;
            } else {
                mView.showEmpty();
            }

        }
    };

    @Override
    public void loadingData(boolean isRefresh) {
        mView.showLoading();
        if (isRefresh) {
            page = 1;
        }
        subscription = NetWork.getGankApi()
                .getGifts(20, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    protected void onDestroy() {
        unsubscribe();
    }
}
