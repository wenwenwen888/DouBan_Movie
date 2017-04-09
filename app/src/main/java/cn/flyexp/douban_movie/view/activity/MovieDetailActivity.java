package cn.flyexp.douban_movie.view.activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.adapter.MovieDetailAdapter;
import cn.flyexp.douban_movie.base.BaseActivity;
import cn.flyexp.douban_movie.model.MovieDetailModel;
import cn.flyexp.douban_movie.presenter.MovieDetailPresenter;
import cn.flyexp.douban_movie.view.iview.IMovieDetailView;

public class MovieDetailActivity extends BaseActivity<IMovieDetailView, MovieDetailPresenter> implements IMovieDetailView, Toolbar.OnMenuItemClickListener, View.OnClickListener, MovieDetailAdapter.IOnItemClickListener {

    @BindView(R.id.iv_movie_detail)
    ImageView ivMovieDetail;
    @BindView(R.id.toolbar_movie_detail)
    Toolbar toolbarMovieDetail;
    @BindView(R.id.collapsing_movie_detail)
    CollapsingToolbarLayout collapsingMovieDetail;
    @BindView(R.id.rv_movie_detail_director)
    RecyclerView rvMovieDetailDirector;
    @BindView(R.id.rv_movie_detail_cast)
    RecyclerView rvMovieDetailCast;
    @BindView(R.id.tv_movie_detail_year)
    TextView tvMovieDetailYear;
    @BindView(R.id.tv_movie_detail_country)
    TextView tvMovieDetailCountry;
    @BindView(R.id.tv_movie_detail_type)
    TextView tvMovieDetailType;
    @BindView(R.id.tv_movie_detail_average)
    TextView tvMovieDetailAverage;
    @BindView(R.id.rv_movie_detail_summary)
    TextView tvMovieDetailSummary;
    @BindView(R.id.srl_movie_detail)
    SwipeRefreshLayout srlMovieDetail;
    @BindView(R.id.ll_movie_detail)
    LinearLayout llMovieDetail;

    @Override
    protected MovieDetailPresenter initPresenter() {
        return new MovieDetailPresenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_movie_detail;
    }

    @Override
    protected void initView() {
        //加载图片
        Glide.with(this).load(getIntent().getStringExtra("img_url")).into(ivMovieDetail);
        //设置标题
        collapsingMovieDetail.setTitle(getIntent().getStringExtra("title"));
        setSupportActionBar(toolbarMovieDetail);
        toolbarMovieDetail.setNavigationIcon(R.drawable.ic_back_white_24dp);

        //配置SwipeRefreshLayout
        srlMovieDetail.setEnabled(false);
        srlMovieDetail.setColorSchemeColors(getIntent().getIntExtra("color", getResources().getColor(R.color.colorMovie)));

        toolbarMovieDetail.setOnMenuItemClickListener(this);//子菜单点击事件 , 即点赞
        toolbarMovieDetail.setNavigationOnClickListener(this);//导航点击事件 , 即返回

        //配置RecyclerView
        initRecyclerView(rvMovieDetailDirector);
        initRecyclerView(rvMovieDetailCast);
        //加载数据
        presenter.loadingData(getIntent().getStringExtra("id"));
    }

    @OnClick(R.id.iv_movie_detail)
    public void onViewClicked() {
        Intent intent = new Intent(this, PhotoActivity.class);
        intent.putExtra("img_url", getIntent().getStringExtra("img_url"));
        startActivity(intent);
    }

    /**
     * 配置RecyclerView
     */
    private void initRecyclerView(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);//设置布局管理器
        recyclerView.setNestedScrollingEnabled(false);
    }

    /**
     * 该方法是用来加载toolbar菜单布局的
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载菜单文件
        getMenuInflater().inflate(R.menu.menu_movie_detail, menu);
        return true;
    }

    /**
     * toolbar 菜单点击事件
     */
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "收藏", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onClick(View view) {
        finish();
    }

    @Override
    public void showComplete(MovieDetailModel movieDetailModel) {
        llMovieDetail.setVisibility(View.VISIBLE);
        srlMovieDetail.setRefreshing(false);
        //年份
        tvMovieDetailYear.setText(String.format(getResources().getString(R.string.detail_year), movieDetailModel.getYear()));
        //国家地区
        String country = "";
        for (int i = 0; i < movieDetailModel.getCountries().size(); i++) {
            if (i == movieDetailModel.getCountries().size() - 1) {
                country = country + movieDetailModel.getCountries().get(i);
            } else {
                country = country + movieDetailModel.getCountries().get(i) + "、";
            }
        }
        tvMovieDetailCountry.setText(String.format(getResources().getString(R.string.detail_country), country));
        //类型
        String type = "";
        for (int i = 0; i < movieDetailModel.getGenres().size(); i++) {
            if (i == movieDetailModel.getGenres().size() - 1) {
                type = type + movieDetailModel.getGenres().get(i);
            } else {
                type = type + movieDetailModel.getGenres().get(i) + "、";
            }
        }
        tvMovieDetailType.setText(String.format(getResources().getString(R.string.detail_type), type));
        //分数
        tvMovieDetailAverage.setText(String.format(getResources().getString(R.string.average), "" + movieDetailModel.getRating().getAverage()));
        //导演
        ArrayList<String> imgs = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> ids = new ArrayList<>();
        for (MovieDetailModel.DirectorsBean directorsBean : movieDetailModel.getDirectors()) {
            if (directorsBean.getAvatars() != null && directorsBean.getId() != null) {
                imgs.add(directorsBean.getAvatars().getMedium());
                names.add(directorsBean.getName());
                ids.add(directorsBean.getId());
            }
        }
        MovieDetailAdapter directorsAdapter = new MovieDetailAdapter(imgs, names, ids);
        rvMovieDetailDirector.setAdapter(directorsAdapter);
        directorsAdapter.setOnItemClickListener(this);
        //演员
        imgs = new ArrayList<>();
        names = new ArrayList<>();
        ids = new ArrayList<>();
        for (MovieDetailModel.CastsBean castsBean : movieDetailModel.getCasts()) {
            if (castsBean.getAvatars() != null && castsBean.getId() != null) {
                imgs.add(castsBean.getAvatars().getMedium());
                names.add(castsBean.getName());
                ids.add(castsBean.getId());
            }
        }
        MovieDetailAdapter castsAdapter = new MovieDetailAdapter(imgs, names, ids);
        rvMovieDetailCast.setAdapter(castsAdapter);
        castsAdapter.setOnItemClickListener(this);
        //简介
        tvMovieDetailSummary.setText(String.format(getResources().getString(R.string.detail_summary), movieDetailModel.getSummary()));
    }

    @Override
    public void showLoading() {
        srlMovieDetail.setRefreshing(true);
    }

    @Override
    public void showEmpty() {
        srlMovieDetail.setRefreshing(false);
    }

    @Override
    public void showError() {
        srlMovieDetail.setRefreshing(false);
        Toast.makeText(this, getText(R.string.error_tips), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(String id, String name) {
        Intent intent = new Intent(this, CelebrityDetailActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("theme", getIntent().getIntExtra("theme", R.style.MovieThemeTransNav));
        intent.putExtra("title", name);
        intent.putExtra("color", getIntent().getIntExtra("color", getResources().getColor(R.color.colorMovie)));
        startActivity(intent);
    }

}
