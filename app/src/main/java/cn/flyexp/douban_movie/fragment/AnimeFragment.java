package cn.flyexp.douban_movie.fragment;

import android.util.Log;

import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.base.BaseLazyFragment;
import cn.flyexp.douban_movie.presenter.AnimePresenter;
import cn.flyexp.douban_movie.view.iview.IAnimeView;


/**
 * Created by Won on 2016/5/4.
 */
public class AnimeFragment extends BaseLazyFragment <IAnimeView, AnimePresenter> implements IAnimeView{

    private static final String TAG = "AnimeFragment";

    @Override
    protected AnimePresenter initPresenter() {
        return new AnimePresenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.main_anime;
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
