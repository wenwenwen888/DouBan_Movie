package cn.flyexp.douban_movie.fragment;

import android.util.Log;

import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.base.BaseLazyFragment;
import cn.flyexp.douban_movie.presenter.Top250Presenter;
import cn.flyexp.douban_movie.view.iview.ITop250View;


/**
 * Created by Won on 2016/5/4.
 */
public class Top250Fragment extends BaseLazyFragment<ITop250View , Top250Presenter> implements ITop250View{

    private static final String TAG = "Top250Fragment";

    @Override
    protected Top250Presenter initPresenter() {
        return new Top250Presenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.main_top250;
    }

    @Override
    protected void initView() {
    }

    /**
     * 实现懒加载,当屏幕显示这个界面的时候才会触发次方法
     */
    @Override
    protected void lazyLoad() {
        //显示数据
        if (isPrepared && isVisible) {
            Log.e(TAG, "lazyLoad: " + TAG );
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showComplete() {

    }
}
