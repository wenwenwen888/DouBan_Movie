package cn.flyexp.douban_movie.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Won on 2016/8/19.
 */
public abstract class BaseLazyFragment<V, T extends BasePresenter<V>> extends Fragment implements IBaseView {

    private static final String TAG = "BaseLazyFragment";

    protected T presenter;
    protected boolean isVisible;
    protected View view;
    // 标志位，标志已经初始化完成。
    protected boolean isPrepared;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(setLayoutId(), container, false);
        ButterKnife.bind(this, view);

        presenter = initPresenter();
        presenter.attach(getContext(), (V) this);

        initView();
        isPrepared = true;
        lazyLoad();//加载数据

        return view;
    }

    abstract protected T initPresenter();

    abstract protected int setLayoutId();

    abstract protected void initView();

    abstract protected void lazyLoad();

    /**
     * 在这里实现Fragment数据的缓加载.
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            lazyLoad();
        } else {
            isVisible = false;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.dettach();
        presenter.onDestroy();
    }

}
