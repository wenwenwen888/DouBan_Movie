package cn.flyexp.douban_movie.base;

import android.content.Context;

import rx.Subscription;

/**
 * Created by Won on 2017/3/12.
 */

public abstract class BasePresenter<V> {

    protected V mView;
    protected Context context;
    protected Subscription subscription;

    /**
     * BaseActivity调用这个方法
     */
    protected void attach(V mView) {
        this.context = (Context) mView;
        this.mView = mView;
    }

    /**
     * BaseFragment调用这个方法
     */
    protected void attach(Context context , V mView) {
        this.context = context;
        this.mView = mView;
    }

    protected void dettach() {
        mView = null;
    }

    /**
     * Presenter销毁时调用
     */
    abstract protected void onDestroy();

    /**
     * 取消订阅 , 释放内存
     */
    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
