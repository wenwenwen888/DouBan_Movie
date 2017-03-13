package cn.flyexp.douban_movie.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import butterknife.BindView;
import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.adapter.MovieAdapter;
import cn.flyexp.douban_movie.assistview.GridDividerItemDecoration;
import cn.flyexp.douban_movie.base.BaseLazyFragment;
import cn.flyexp.douban_movie.presenter.MoviePresenter;
import cn.flyexp.douban_movie.view.iview.IMovieView;


/**
 * Created by Won on 2016/5/4.
 */
public class MovieFragment extends BaseLazyFragment<IMovieView , MoviePresenter> implements IMovieView{

    private static final String TAG = "MovieFragment";

    @BindView(R.id.rv)
    RecyclerView rv;


    @Override
    protected MoviePresenter initPresenter() {
        return new MoviePresenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.main_movie;
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.addItemDecoration(new GridDividerItemDecoration(getContext()));
        presenter.setData();
    }

    /**
     * 实现懒加载,当屏幕显示这个界面的时候才会触发次方法
     */
    @Override
    protected void lazyLoad() {
        //显示数据
        if (isPrepared && isVisible) {
            Log.e(TAG, "lazyLoad: " + TAG);
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

    @Override
    public void showData() {
        rv.setAdapter(new MovieAdapter());
    }
}
