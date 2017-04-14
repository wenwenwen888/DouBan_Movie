package cn.flyexp.douban_movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.adapter.FragmentAdapter;
import cn.flyexp.douban_movie.assistview.NoScrollViewPager;
import cn.flyexp.douban_movie.view.fragment.AnimeFragment;
import cn.flyexp.douban_movie.view.fragment.MovieFragment;
import cn.flyexp.douban_movie.view.fragment.TVFragment;
import cn.flyexp.douban_movie.view.fragment.TagFragment;
import cn.flyexp.douban_movie.view.fragment.Top250Fragment;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements OnTabSelectListener, IOnSearchClickListener, View.OnClickListener, Toolbar.OnMenuItemClickListener, NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    @BindView(R.id.navigationview)
    NavigationView navigationview;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;
    @BindView(R.id.viewpager)
    NoScrollViewPager viewpager;

    //Fragment的适配器
    private FragmentAdapter fragmentAdapter;
    private List<Fragment> fragments = new ArrayList<>();

    private TextView user_link; //导航链接
    private CircleImageView user_icon;  //导航头像

    private SearchFragment searchFragment;  //搜索框
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        //toolbar设置初始标题
        toolbar.setTitle(getResources().getString(R.string.movie));
        //以上属性必须在setSupportActionBar(toolbar)之前调用
        setSupportActionBar(toolbar);
        //设置导航icon
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);

        //navigation导航的headerLayout控件
        View headerLayout = navigationview.getHeaderView(0);
        user_link = (TextView) headerLayout.findViewById(R.id.user_link);
        user_icon = (CircleImageView) headerLayout.findViewById(R.id.user_icon);
        //头像点击
        user_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "头像", Toast.LENGTH_SHORT).show();
            }
        });

        //初始化Adapter
        fragments.add(new MovieFragment());
        fragments.add(new AnimeFragment());
        fragments.add(new TVFragment());
        fragments.add(new Top250Fragment());
        fragments.add(new TagFragment());
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        //viewpager配置
        viewpager.setNoScroll(true);//viewpager禁止滑动
        viewpager.setOffscreenPageLimit(5);//默认加载5页
        viewpager.setAdapter(fragmentAdapter);
        viewpager.addOnPageChangeListener(new TabOnPageChangeListener());


        //监听drawerLayout , 改变导航图标
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.app_name, R.string.app_name);
        toggle.syncState();
        drawerlayout.setDrawerListener(toggle);

        //实例化搜索框
        searchFragment = SearchFragment.newInstance();
        searchFragment.setOnSearchClickListener(this);//搜索监听事件

        toolbar.setNavigationOnClickListener(this);//添加导航icon点击事件
        toolbar.setOnMenuItemClickListener(this);//添加子菜单点击事件
        navigationview.setNavigationItemSelectedListener(this);//右侧抽屉导航子菜单选择事件
        bottomBar.setOnTabSelectListener(this); //底部导航选择事件
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
     * 底部导航栏的点击
     */
    @Override
    public void onTabSelected(@IdRes int tabId) {
        switch (tabId) {
            case R.id.tab_movie://电影
                setTitleAndColor(0, getResources().getString(R.string.movie), getResources().getColor(R.color.colorMovie), R.style.MovieThemeTransNav);
                break;
            case R.id.tab_anime://动漫
                setTitleAndColor(1, getResources().getString(R.string.anime), getResources().getColor(R.color.colorAnime), R.style.AnimeThemeTransNav);
                break;
            case R.id.tab_tv://电视剧
                setTitleAndColor(2, getResources().getString(R.string.tv), getResources().getColor(R.color.colorTV), R.style.TVThemeTransNav);
                break;
            case R.id.tab_top250://top250
                setTitleAndColor(3, getResources().getString(R.string.top250), getResources().getColor(R.color.colorTop250), R.style.Top250ThemeTransNav);
                break;
            case R.id.tab_tag://分类
                setTitleAndColor(4, getResources().getString(R.string.tag), getResources().getColor(R.color.colorTag), R.style.TagThemeTransNav);
                break;
        }
    }

    /**
     * 设置title和主题颜色
     */
    private void setTitleAndColor(int item, String title, int color, int styleid) {
        viewpager.setCurrentItem(item, false);
        toolbar.setTitle(title);
        toolbar.setBackgroundColor(color);
        navigationview.setBackgroundColor(color);
        user_link.setLinkTextColor(color);
        intent = new Intent();
        intent.putExtra("theme", styleid);
        intent.putExtra("color", color);
    }

    /**
     * 搜索回调接口
     */
    @Override
    public void OnSearchClick(String keyword) {
        intent.setClass(this, SearchDetailActivity.class);
        intent.putExtra("keyword", keyword);
        startActivity(intent);
    }

    /**
     * toolbar导航logo点击事件
     */
    @Override
    public void onClick(View view) {
        drawerlayout.openDrawer(Gravity.LEFT);
    }

    /**
     * toolbar 菜单点击事件
     */
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        searchFragment.show(getSupportFragmentManager(), SearchFragment.TAG);
        return true;
    }

    /**
     * 右侧抽屉导航子菜单选择事件
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setCheckable(false); //取消点击后的阴影
        switch (item.getItemId()) {
            case R.id.nav_exit: //退出
                System.exit(0);
                break;
            case R.id.nav_favorite://收藏
                intent.setClass(this, FavoriteActivity.class);
                startActivity(intent);
                break;
            default:
                Snackbar.make(toolbar, item.getTitle(), Snackbar.LENGTH_SHORT).show();
                break;
        }
        drawerlayout.closeDrawers();
        return true;
    }

    /**
     * 功能：Fragment页面改变事件
     */
    public class TabOnPageChangeListener implements ViewPager.OnPageChangeListener {

        //当滑动状态改变时调用
        public void onPageScrollStateChanged(int state) {

        }

        //当前页面被滑动时调用
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        //当新的页面被选中时调用
        public void onPageSelected(int position) {

        }
    }

    /**
     * 重写返回
     */
    @Override
    public void onBackPressed() {
        showQuitTips();
    }

    private long firstPressTime = -1;// 记录第一次按下的时间
    private long lastPressTime;// 记录第二次按下的时间

    /**
     * 双击返回退出
     */
    private void showQuitTips() {
        // 如果是第一次按下 直接提示
        if (firstPressTime == -1) {
            firstPressTime = System.currentTimeMillis();
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
        }
        // 如果是第二次按下，需要判断与上一次按下的时间间隔，这里设置2秒
        else {
            lastPressTime = System.currentTimeMillis();
            if (lastPressTime - firstPressTime <= 2000) {
                System.exit(0);
            } else {
                firstPressTime = lastPressTime;
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
