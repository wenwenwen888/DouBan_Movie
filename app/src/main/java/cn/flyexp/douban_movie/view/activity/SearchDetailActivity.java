package cn.flyexp.douban_movie.view.activity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

import butterknife.BindView;
import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.base.BaseActivity;
import cn.flyexp.douban_movie.presenter.SearchDetailPresenter;
import cn.flyexp.douban_movie.view.iview.ISearchDetailView;

public class SearchDetailActivity extends BaseActivity<ISearchDetailView, SearchDetailPresenter> implements ISearchDetailView, IOnSearchClickListener, Toolbar.OnMenuItemClickListener, View.OnClickListener {


    @BindView(R.id.tb_search_detail)
    Toolbar tbSearchDetail;

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
        //toolbar设置初始标题
        tbSearchDetail.setTitle(getIntent().getStringExtra("keyword"));
        //以上属性必须在setSupportActionBar(toolbar)之前调用
        setSupportActionBar(tbSearchDetail);
        tbSearchDetail.setBackgroundColor(getIntent().getIntExtra("color", getResources().getColor(R.color.colorMovie)));
        tbSearchDetail.setNavigationIcon(R.drawable.ic_back_white_24dp);

        //实例化搜索框
        searchFragment = SearchFragment.newInstance();
        searchFragment.setOnSearchClickListener(this);//搜索监听事件
        tbSearchDetail.setOnMenuItemClickListener(this);//添加子菜单点击事件
        tbSearchDetail.setNavigationOnClickListener(this);

        presenter.search(getIntent().getStringExtra("keyword"));
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
    public void setTitle(String keyword) {
        tbSearchDetail.setTitle(keyword);
        Toast.makeText(this, keyword, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnSearchClick(String keyword) {
        presenter.search(keyword);
    }

    /**
     * toolbar 菜单点击事件
     */
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        searchFragment.show(getSupportFragmentManager(), SearchFragment.TAG);
        return true;
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
