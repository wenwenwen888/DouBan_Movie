package cn.flyexp.douban_movie.view.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.adapter.GiftAdapter;
import cn.flyexp.douban_movie.base.BaseActivity;
import cn.flyexp.douban_movie.model.GiftModel;
import cn.flyexp.douban_movie.presenter.GiftPresenter;
import cn.flyexp.douban_movie.view.iview.IGiftView;

public class GiftActivity extends BaseActivity<IGiftView, GiftPresenter> implements IGiftView, SwipeRefreshLayout.OnRefreshListener, View.OnClickListener, GiftAdapter.IOnItemClickListener {

    @BindView(R.id.tb_gift)
    Toolbar tbGift;
    @BindView(R.id.tv_tip_gift)
    TextView tvTipGift;
    @BindView(R.id.rv_gift)
    RecyclerView rvGift;
    @BindView(R.id.srl_gift)
    SwipeRefreshLayout srlGift;

    private List<GiftModel.ResultsBean> giftModels = new ArrayList<>();
    private GiftAdapter giftAdapter;
    //是否刷新
    private boolean isRefresh = true;

    @Override
    protected GiftPresenter initPresenter() {
        return new GiftPresenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_gift;
    }

    @Override
    protected void initView() {
        //toolbar设置初始标题
        tbGift.setTitle(getResources().getString(R.string.gift));
        //以上属性必须在setSupportActionBar(toolbar)之前调用
        setSupportActionBar(tbGift);
        tbGift.setBackgroundColor(getIntent().getIntExtra("color", getResources().getColor(R.color.colorMovie)));
        tbGift.setNavigationIcon(R.drawable.ic_back_white_24dp);

        //配置SwipeRefreshLayout
        srlGift.setColorSchemeColors(getIntent().getIntExtra("color", getResources().getColor(R.color.colorMovie)));

        //适配器
        giftAdapter = new GiftAdapter(giftModels);
        //配置RecyclerView
        rvGift.setLayoutManager(new GridLayoutManager(this, 3));//设置瀑布流风格
        rvGift.setAdapter(giftAdapter);
        //监听上拉
        rvGift.addOnScrollListener(mOnScrollListener);

        //加载数据
        presenter.loadingData(isRefresh);

        srlGift.setOnRefreshListener(this);//监听下拉刷新
        tbGift.setNavigationOnClickListener(this);//监听返回键
        giftAdapter.setOnItemClickListener(this);//列表监听
    }

    @Override
    public void onRefresh() {
        isRefresh = true;
        presenter.loadingData(isRefresh);
    }

    /**
     * 上拉加载更多
     */
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if (!recyclerView.canScrollVertically(1) && dy != 0 && !srlGift.isRefreshing()) {// 手指不能向上滑动了并且不在加载状态
                presenter.loadingData(false);//加载下一页
            }
        }
    };

    /**
     * showLoading 方法主要用于页面请求数据时显示加载状态
     */
    @Override
    public void showLoading() {
        srlGift.setRefreshing(true);
    }

    /**
     * showEmpty 方法用于请求的数据为空的状态
     */
    @Override
    public void showEmpty() {
        srlGift.setRefreshing(false);
        if (giftModels.size() > 0) {
            Toast.makeText(this, "已经没有数据了", Toast.LENGTH_SHORT).show();
        } else {
            tvTipGift.setText(getText(R.string.error_tips2));
        }
    }

    /**
     * showError 方法用于请求数据出错
     */
    @Override
    public void showError() {
        srlGift.setRefreshing(false);
        if (giftModels.size() > 0) {
            Toast.makeText(this, getText(R.string.error_tips), Toast.LENGTH_SHORT).show();
        } else {
            tvTipGift.setText(getText(R.string.error_tips2));
        }
    }

    /**
     * loadingComplete 方法用于请求数据完成
     *
     * @param models
     */
    @Override
    public void showComplete(ArrayList<?> models) {
        if (isRefresh) {
            giftModels.clear();
        }
        isRefresh = false;
        tvTipGift.setVisibility(View.GONE);
        srlGift.setRefreshing(false);
        giftModels.addAll((Collection<? extends GiftModel.ResultsBean>) models);
        giftAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        finish();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, PhotoActivity.class);
        intent.putExtra("img_url", giftModels.get(position).getUrl());
        startActivity(intent);
    }
}
