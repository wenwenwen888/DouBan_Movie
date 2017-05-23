package cn.flyexp.douban_movie.view.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;
import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.adapter.MovieAdapter;
import cn.flyexp.douban_movie.base.BaseLazyFragment;
import cn.flyexp.douban_movie.model.MessageEvent;
import cn.flyexp.douban_movie.model.MovieSubjectsModel;
import cn.flyexp.douban_movie.presenter.TVPresenter;
import cn.flyexp.douban_movie.view.activity.MovieDetailActivity;
import cn.flyexp.douban_movie.view.iview.ITVView;


/**
 * Created by Won on 2016/5/4.
 */
public class TVFragment extends BaseLazyFragment<ITVView, TVPresenter> implements ITVView, View.OnClickListener, MovieAdapter.IOnItemClickListener {

    private static final String TAG = "TVFragment";

    @BindView(R.id.rv_tv)
    RecyclerView rv;
    @BindView(R.id.srl_tv)
    SwipeRefreshLayout srl;
    @BindView(R.id.tv_tip_tv)
    TextView tvTip;

    //判断是否第一次显示
    private boolean isFirst = true;
    //电影条目列表
    private ArrayList<MovieSubjectsModel> movieModelBeans = new ArrayList<>();
    //添加FooterView的适配器
    private HeaderAndFooterWrapper tvWrapperAdapter;
    //适配器
    private MovieAdapter tvAdapter;
    //footerView文字显示
    private TextView tvFooterViewInfo;

    @Override
    protected TVPresenter initPresenter() {
        return new TVPresenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.main_tv;
    }

    @Override
    protected void initView() {
        //配置SwipeRefreshLayout
        srl.setEnabled(false);
        srl.setColorSchemeResources(R.color.colorTV);
        //适配器
        tvAdapter = new MovieAdapter(movieModelBeans);
        tvAdapter.setOnItemClickListener(this);
        tvWrapperAdapter = new HeaderAndFooterWrapper(tvAdapter);
        //添加footerView
        View footerView = LayoutInflater.from(getContext()).inflate(R.layout.footerview, null);
        tvFooterViewInfo = (TextView) footerView.findViewById(R.id.footerview_info);
        tvWrapperAdapter.addFootView(footerView);
        //配置RecyclerView
        rv.setLayoutManager(new LinearLayoutManager(getContext()));//设置list列风格
        rv.setAdapter(tvWrapperAdapter);
        //监听列表上拉
        rv.addOnScrollListener(mOnScrollListener);
        //监听点击提示文本
        tvTip.setOnClickListener(this);
    }

    /**
     * 实现懒加载,当屏幕显示这个界面的时候才会触发次方法
     */
    @Override
    protected void lazyLoad() {
        //显示数据
        if (isFirst & isPrepared && isVisible) {
            isFirst = false;
            //加载数据
            presenter.loadingData();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        if (event.isNight) {
            srl.setColorSchemeResources(R.color.colorNight);
        } else {
            srl.setColorSchemeResources(R.color.colorTV);
        }
        tvWrapperAdapter.notifyDataSetChanged();
    }

    /**
     * 上拉加载更多
     */
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if (!recyclerView.canScrollVertically(1) && dy != 0 && !srl.isRefreshing()) {// 手指不能向上滑动了并且不在加载状态
                tvFooterViewInfo.setText(getText(R.string.loading_tips));
                srl.setRefreshing(true);
                presenter.loadingData();//刷新
            }
        }
    };

    @Override
    public void showLoading() {
        srl.setRefreshing(true);
    }

    @Override
    public void showEmpty() {
        srl.setRefreshing(false);
        if (movieModelBeans.size() > 0) {
            tvFooterViewInfo.setText(getText(R.string.no_data_tips));
        } else {
            tvTip.setText(getText(R.string.empty_tips));
        }
    }

    @Override
    public void showError() {
        srl.setRefreshing(false);
        if (movieModelBeans.size() > 0) {
            Toast.makeText(getContext(), getText(R.string.error_tips), Toast.LENGTH_SHORT).show();
        } else {
            tvTip.setText(getText(R.string.error_tips2));
        }
    }

    @Override
    public void showComplete(ArrayList<?> modelBeans) {
        tvTip.setVisibility(View.GONE);
        srl.setRefreshing(false);
        movieModelBeans.addAll((Collection<? extends MovieSubjectsModel>) modelBeans);
        tvWrapperAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_tip_tv:
                presenter.loadingData();//重新加载
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(int position, String id, String img_url, String title) {
        Intent intent = new Intent(getContext(), MovieDetailActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("theme", R.style.TVThemeTransNav);
        intent.putExtra("img_url", img_url);
        intent.putExtra("title", title);
        intent.putExtra("movieSubject", movieModelBeans.get(position));
        intent.putExtra("color", getResources().getColor(R.color.colorTV));
        startActivity(intent);
    }
}
