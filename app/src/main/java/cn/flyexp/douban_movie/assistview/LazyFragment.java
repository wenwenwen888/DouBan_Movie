package cn.flyexp.douban_movie.assistview;

import android.support.v4.app.Fragment;

/**
 * Created by Won on 2016/8/19.
 */
public abstract class LazyFragment extends Fragment {

    protected boolean isVisible;

    /**
     * 在这里实现Fragment数据的缓加载.
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
        lazyLoad();
    }

    protected abstract void lazyLoad();

    protected void onInvisible() {
    }
}
