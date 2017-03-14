package cn.flyexp.douban_movie.view.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;
import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.adapter.MovieAdapter;
import cn.flyexp.douban_movie.base.BaseActivity;
import cn.flyexp.douban_movie.model.MovieModel;
import cn.flyexp.douban_movie.presenter.SearchDetailPresenter;
import cn.flyexp.douban_movie.view.iview.ISearchDetailView;

public class SearchDetailActivity extends BaseActivity<ISearchDetailView, SearchDetailPresenter> implements ISearchDetailView, IOnSearchClickListener, Toolbar.OnMenuItemClickListener, View.OnClickListener {

    private static final String TAG = "SearchDetailActivity";

    @BindView(R.id.tb_search_detail)
    Toolbar tbSearchDetail;
    @BindView(R.id.rv_search_detail)
    RecyclerView rv;
    @BindView(R.id.srl_search_detail)
    SwipeRefreshLayout srl;
    @BindView(R.id.tv_tip_search_detail)
    TextView tvTip;

    //判断是否标签
    private boolean isTag = false;
    //关键字
    String keyword = "";
    //电影条目列表
    private ArrayList<MovieModel.SubjectsBean> movieModelBeans = new ArrayList<>();
    //添加FooterView的适配器
    private HeaderAndFooterWrapper searchWrapperAdapter;
    //适配器
    private MovieAdapter searchAdapter;
    //footerView文字显示
    private TextView searchFooterViewInfo;

    private SearchFragment searchFragment;  //搜索框

    @Override
    protected SearchDetailPresenter initPresenter() {
        return new SearchDetailPresenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_searchdetail;
    }

    @Override
    protected void initView() {
        keyword = getIntent().getStringExtra("keyword");
        if (TextUtils.isEmpty(keyword)) {
            keyword = getIntent().getStringExtra("tag");
            isTag = true;
        }
        //toolbar设置初始标题
        tbSearchDetail.setTitle(keyword);
        //以上属性必须在setSupportActionBar(toolbar)之前调用
        setSupportActionBar(tbSearchDetail);
        tbSearchDetail.setBackgroundColor(getIntent().getIntExtra("color", getResources().getColor(R.color.colorMovie)));
        tbSearchDetail.setNavigationIcon(R.drawable.ic_back_white_24dp);

        //配置SwipeRefreshLayout
        srl.setEnabled(false);
        srl.setColorSchemeColors(getIntent().getIntExtra("color", getResources().getColor(R.color.colorMovie)));
        //适配器
        searchAdapter = new MovieAdapter(movieModelBeans);
        searchWrapperAdapter = new HeaderAndFooterWrapper(searchAdapter);
        //添加footerView
        View footerView = LayoutInflater.from(this).inflate(R.layout.footerview, null);
        searchFooterViewInfo = (TextView) footerView.findViewById(R.id.footerview_info);
        searchWrapperAdapter.addFootView(footerView);
        //配置RecyclerView
        rv.setLayoutManager(new LinearLayoutManager(this));//设置list列风格
        rv.setAdapter(searchWrapperAdapter);
        //监听列表上拉
        rv.addOnScrollListener(mOnScrollListener);
        //监听点击提示文本
        tvTip.setOnClickListener(this);

        //实例化搜索框
        searchFragment = SearchFragment.newInstance();
        searchFragment.setOnSearchClickListener(this);//搜索监听事件
        tbSearchDetail.setOnMenuItemClickListener(this);//添加子菜单点击事件
        tbSearchDetail.setNavigationOnClickListener(this);
        //加载数据
        presenter.search(keyword, isTag, true);
    }

    /**
     * 该方法是用来加载toolbar菜单布局的
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载菜单文件
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * 上拉加载更多
     */
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if (!recyclerView.canScrollVertically(1) && dy != 0 && !srl.isRefreshing()) {// 手指不能向上滑动了并且不在加载状态
                searchFooterViewInfo.setText(getText(R.string.loading_tips));
                srl.setRefreshing(true);
                presenter.search(keyword, isTag, false);//刷新
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
            if (searchFooterViewInfo.getVisibility() == View.GONE)
                searchFooterViewInfo.setVisibility(View.VISIBLE);
            searchFooterViewInfo.setText(getText(R.string.no_data_tips));
        } else {
            if (tvTip.getVisibility() == View.GONE)
                tvTip.setVisibility(View.VISIBLE);
            tvTip.setText(getText(R.string.empty_tips));
        }
    }

    @Override
    public void showError() {
        srl.setRefreshing(false);
        if (movieModelBeans.size() > 0) {
            Toast.makeText(this, getText(R.string.error_tips), Toast.LENGTH_SHORT).show();
        } else {
            if (tvTip.getVisibility() == View.GONE)
                tvTip.setVisibility(View.VISIBLE);
            tvTip.setText(getText(R.string.error_tips2));
        }
    }

    @Override
    public void showComplete(ArrayList<?> modelBeans) {
        tvTip.setVisibility(View.GONE);
        srl.setRefreshing(false);
        movieModelBeans.addAll((Collection<? extends MovieModel.SubjectsBean>) modelBeans);
        searchWrapperAdapter.notifyDataSetChanged();
        if (searchFooterViewInfo.getVisibility() == View.GONE)
            searchFooterViewInfo.setVisibility(View.VISIBLE);
        searchFooterViewInfo.setText(getText(R.string.no_data_tips));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_tip_search_detail:
                presenter.search(keyword, isTag, false);//重新加载
                break;
            default:
                finish();
                break;
        }
    }

    /**
     * 搜索框回调
     */
    @Override
    public void OnSearchClick(String keyword) {
        movieModelBeans.clear();
        searchWrapperAdapter.notifyDataSetChanged();
        searchFooterViewInfo.setVisibility(View.GONE);
        tbSearchDetail.setTitle(keyword);
        isTag = false;
        this.keyword = keyword;
        presenter.search(keyword, false, true);
    }

    /**
     * toolbar 菜单点击事件
     */
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        searchFragment.show(getSupportFragmentManager(), SearchFragment.TAG);
        return true;
    }
}
