package cn.flyexp.douban_movie.fragment;

import android.util.Log;

import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.base.BaseLazyFragment;
import cn.flyexp.douban_movie.presenter.TagPresenter;
import cn.flyexp.douban_movie.view.iview.ITagView;

/**
 * Created by Won on 2016/5/4.
 */
public class TagFragment extends BaseLazyFragment <ITagView, TagPresenter> implements ITagView{

    private static final String TAG = "TagFragment";

    @Override
    protected TagPresenter initPresenter() {
        return new TagPresenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.main_tag;
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
