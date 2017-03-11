package cn.flyexp.douban_movie.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.adapter.MovieAdapter;
import cn.flyexp.douban_movie.assistview.GridDividerItemDecoration;
import cn.flyexp.douban_movie.assistview.LazyFragment;


/**
 * Created by Won on 2016/5/4.
 */
public class MovieFragment extends LazyFragment {

    private static final String TAG = "MovieFragment";

    @BindView(R.id.rv)
    RecyclerView rv;

    private View view;
    // 标志位，标志已经初始化完成。
    private boolean isPrepared;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_movie, container, false);
        ButterKnife.bind(this, view);

        initUI();//实例化控件
        isPrepared = true;
        lazyLoad();//加载数据

        return view;
    }

    /**
     * 实例化组件
     */
    private void initUI() {
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.addItemDecoration(new GridDividerItemDecoration(getContext()));
        rv.setAdapter(new MovieAdapter());
    }


    @Override
    public void onDestroy() {
        //销毁时释放资源
        super.onDestroy();
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

}
