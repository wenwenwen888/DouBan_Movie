package cn.flyexp.douban_movie.view.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.flyexp.douban_movie.MyApplication;
import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.adapter.MovieAdapter;
import cn.flyexp.douban_movie.base.BaseActivity;
import cn.flyexp.douban_movie.model.MovieSubjectsModel;
import cn.flyexp.douban_movie.presenter.FavoritePresenter;
import cn.flyexp.douban_movie.view.iview.IFavoriteView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class FavoriteActivity extends BaseActivity<IFavoriteView, FavoritePresenter> implements IFavoriteView, View.OnClickListener, MovieAdapter.IOnItemClickListener, Toolbar.OnMenuItemClickListener {

    private static final String TAG = "FavoriteActivity";

    @BindView(R.id.tb_favorite_detail)
    Toolbar tbFavoriteDetail;
    @BindView(R.id.tv_tip_favorite_detail)
    TextView tvTipFavoriteDetail;
    @BindView(R.id.rv_favorite_detail)
    RecyclerView rvFavoriteDetail;
    @BindView(R.id.srl_favorite_detail)
    SwipeRefreshLayout srlFavoriteDetail;

    //收藏电影条目列表
    private ArrayList<MovieSubjectsModel> movieModelBeans = new ArrayList<>();
    //添加FooterView的适配器
    private HeaderAndFooterWrapper favoriteWrapperAdapter;
    //适配器
    private MovieAdapter favoriteAdapter;
    //footerView文字显示
    private TextView favoriteFooterViewInfo;
    //选中的条目
    private MovieSubjectsModel movieModelBean;
    //是否在选择状态
    private boolean isCheck = false;

    @Override
    protected FavoritePresenter initPresenter() {
        return new FavoritePresenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_favorite;
    }

    @Override
    protected void initView() {
        //toolbar设置初始标题
        tbFavoriteDetail.setTitle(getResources().getString(R.string.favorite));
        //以上属性必须在setSupportActionBar(toolbar)之前调用
        setSupportActionBar(tbFavoriteDetail);
        tbFavoriteDetail.setBackgroundColor(getIntent().getIntExtra("color", getResources().getColor(R.color.colorMovie)));
        tbFavoriteDetail.setNavigationIcon(R.drawable.ic_back_white_24dp);

        //配置SwipeRefreshLayout
        srlFavoriteDetail.setEnabled(false);
        srlFavoriteDetail.setColorSchemeColors(getIntent().getIntExtra("color", getResources().getColor(R.color.colorMovie)));
        //适配器
        favoriteAdapter = new MovieAdapter(movieModelBeans);
        favoriteAdapter.setOnItemClickListener(this);
        favoriteWrapperAdapter = new HeaderAndFooterWrapper(favoriteAdapter);
        //添加footerView
        View footerView = LayoutInflater.from(this).inflate(R.layout.footerview, null);
        favoriteFooterViewInfo = (TextView) footerView.findViewById(R.id.footerview_info);
        favoriteWrapperAdapter.addFootView(footerView);
        //配置RecyclerView
        rvFavoriteDetail.setLayoutManager(new LinearLayoutManager(this));//设置list列风格
        rvFavoriteDetail.setAdapter(favoriteWrapperAdapter);
        //监听点击提示文本
        tvTipFavoriteDetail.setOnClickListener(this);

        tbFavoriteDetail.setOnMenuItemClickListener(this);//添加子菜单点击事件
        tbFavoriteDetail.setNavigationOnClickListener(this);
        //加载数据
        presenter.loadData();
    }

    /**
     * 该方法是用来加载toolbar菜单布局的
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载菜单文件
        getMenuInflater().inflate(R.menu.menu_favorite, menu);
        return true;
    }

    @Override
    public void showLoading() {
        srlFavoriteDetail.setRefreshing(true);
    }

    @Override
    public void showEmpty() {
        srlFavoriteDetail.setRefreshing(false);
        if (movieModelBeans.size() > 0) {
            if (favoriteFooterViewInfo.getVisibility() == View.GONE)
                favoriteFooterViewInfo.setVisibility(View.VISIBLE);
            favoriteFooterViewInfo.setText(getText(R.string.no_data_tips));
        } else {
            if (tvTipFavoriteDetail.getVisibility() == View.GONE)
                tvTipFavoriteDetail.setVisibility(View.VISIBLE);
            tvTipFavoriteDetail.setText(getText(R.string.favorite_empty_tips));
        }
    }

    @Override
    public void showComplete(List<MovieSubjectsModel> movieSubjectsModels) {
        tvTipFavoriteDetail.setVisibility(View.GONE);
        srlFavoriteDetail.setRefreshing(false);
        movieModelBeans.addAll(movieSubjectsModels);
        favoriteWrapperAdapter.notifyDataSetChanged();
        if (favoriteFooterViewInfo.getVisibility() == View.GONE)
            favoriteFooterViewInfo.setVisibility(View.VISIBLE);
        favoriteFooterViewInfo.setText(getText(R.string.no_data_tips));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_tip_favorite_detail:
                presenter.loadData();
                break;
            default:
                finish();
                break;
        }
    }

    /**
     * toolbar 菜单点击事件
     */
    @Override
    public boolean onMenuItemClick(final MenuItem item) {

        if (isCheck) {
            Observable.create(new Observable.OnSubscribe<Boolean>() {
                @Override
                public void call(Subscriber<? super Boolean> subscriber) {
                    //删除数据
                    subscriber.onNext(presenter.deleteData(favoriteAdapter.getSelectIds()));
                }
            })
                    .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                    .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                    .subscribe(new Action1<Boolean>() {
                        @Override
                        public void call(Boolean isDelete) {
                            if (isDelete) {
                                movieModelBeans.removeAll(favoriteAdapter.getSelectModels());
                                item.setIcon(R.drawable.ic_check_white_24dp);
                                item.setTitle(R.string.favorite);
                                isCheck = false;
                                favoriteAdapter.setCheck(false);
                                favoriteWrapperAdapter.notifyDataSetChanged();
                            }
                        }
                    });
        } else {
            item.setIcon(R.drawable.ic_delete_white_24dp);
            item.setTitle(R.string.delete);
            isCheck = true;
            favoriteAdapter.setCheck(true);
            favoriteWrapperAdapter.notifyDataSetChanged();
        }
        return true;
    }

    @Override
    public void onItemClick(int position, String id, String img_url, String title) {
        movieModelBean = movieModelBeans.get(position);
        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("theme", getIntent().getIntExtra("theme", R.style.MovieThemeTransNav));
        intent.putExtra("img_url", img_url);
        intent.putExtra("title", title);
        intent.putExtra("movieSubject", movieModelBeans.get(position));
        intent.putExtra("color", getIntent().getIntExtra("color", getResources().getColor(R.color.colorMovie)));
        startActivityForResult(intent, MyApplication.REQUESTCODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MyApplication.REQUESTCODE && resultCode == MyApplication.RESULTCODE) {
            if (!data.getBooleanExtra("isFavorite", true))
                movieModelBeans.remove(movieModelBean);
            favoriteWrapperAdapter.notifyDataSetChanged();
        }
    }

}
