package cn.flyexp.douban_movie.view.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.adapter.MovieAdapter;
import cn.flyexp.douban_movie.assistview.MyRecyclerView;
import cn.flyexp.douban_movie.base.BaseActivity;
import cn.flyexp.douban_movie.model.CelebrityDetailModel;
import cn.flyexp.douban_movie.model.MovieModel;
import cn.flyexp.douban_movie.presenter.CelebrityDetailPresenter;
import cn.flyexp.douban_movie.view.iview.ICelebrityDetailView;

public class CelebrityDetailActivity extends BaseActivity<ICelebrityDetailView, CelebrityDetailPresenter> implements ICelebrityDetailView, View.OnClickListener, MovieAdapter.IOnItemClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_celebrity_avatar)
    ImageView ivCelebrityAvatar;
    @BindView(R.id.tv_celebrity_name)
    TextView tvCelebrityName;
    @BindView(R.id.tv_celebrity_name_en)
    TextView tvCelebrityNameEn;
    @BindView(R.id.tv_celebrity_place)
    TextView tvCelebrityPlace;
    @BindView(R.id.tv_celebrity_roles)
    TextView tvCelebrityRoles;
    @BindView(R.id.rv_works)
    MyRecyclerView rvWorks;
    @BindView(R.id.tv_celebrity_more)
    TextView tvCelebrityMore;
    @BindView(R.id.srl_celebrity_detail)
    SwipeRefreshLayout srlCelebrityDetail;
    @BindView(R.id.ll_celebrity_detail)
    LinearLayout llCelebrityDetail;

    private String avatars_large;

    @Override
    protected CelebrityDetailPresenter initPresenter() {
        return new CelebrityDetailPresenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_celebrity_detail;
    }

    @Override
    protected void initView() {
        //toolbar设置初始标题
        toolbar.setTitle(getIntent().getStringExtra("title"));
        //以上属性必须在setSupportActionBar(toolbar)之前调用
        setSupportActionBar(toolbar);
        //设置导航icon
        toolbar.setNavigationIcon(R.drawable.ic_back_white_24dp);
        //配置SwipeRefreshLayout
        srlCelebrityDetail.setEnabled(false);
        srlCelebrityDetail.setColorSchemeColors(getIntent().getIntExtra("color", getResources().getColor(R.color.colorMovie)));

        //配置RecyclerView
        rvWorks.setLayoutManager(new LinearLayoutManager(this));//设置list列风格
        //解决嵌套滑动冲突
        rvWorks.setNestedScrollingEnabled(false);

        toolbar.setNavigationOnClickListener(this);//导航点击事件 , 即返回

        //加载数据
        presenter.loadingData(getIntent().getStringExtra("id"));
    }

    @OnClick({R.id.iv_celebrity_avatar, R.id.tv_celebrity_more})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.iv_celebrity_avatar:
                intent = new Intent(this, PhotoActivity.class);
                intent.putExtra("img_url", avatars_large);
                startActivity(intent);
                break;
            case R.id.tv_celebrity_more:
                intent = new Intent(this, SearchDetailActivity.class);
                intent.putExtra("theme", getIntent().getIntExtra("theme", R.style.MovieThemeTransNav));
                intent.putExtra("color", getIntent().getIntExtra("color", getResources().getColor(R.color.colorMovie)));
                intent.putExtra("keyword", getIntent().getStringExtra("title"));
                startActivity(intent);
                break;
        }
    }

    @Override
    public void showLoading() {
        srlCelebrityDetail.setRefreshing(true);
    }

    @Override
    public void showEmpty() {
        srlCelebrityDetail.setRefreshing(false);
    }

    @Override
    public void showError() {
        srlCelebrityDetail.setRefreshing(false);
        Toast.makeText(this, getText(R.string.error_tips), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete(CelebrityDetailModel celebrityDetailModel) {
        srlCelebrityDetail.setRefreshing(false);
        llCelebrityDetail.setVisibility(View.VISIBLE);
        //头像
        avatars_large = celebrityDetailModel.getAvatars().getLarge();
        Glide.with(this).load(avatars_large).
                diskCacheStrategy(DiskCacheStrategy.SOURCE).crossFade().into(ivCelebrityAvatar);
        //名字
        tvCelebrityName.setText(celebrityDetailModel.getName());
        tvCelebrityNameEn.setText(celebrityDetailModel.getName_en());
        //地区
        tvCelebrityPlace.setText(celebrityDetailModel.getBorn_place());
        //角色
        ArrayList<String> roles = new ArrayList<>();
        ArrayList<MovieModel.SubjectsBean> subjectsBeans = new ArrayList<>();
        for (CelebrityDetailModel.WorksBean worksBean : celebrityDetailModel.getWorks()) {
            subjectsBeans.add(worksBean.getSubject());
            for (String role : worksBean.getRoles()) {
                if (!roles.contains(role)) {
                    roles.add(role);
                }
            }
        }
        String role = "";
        for (int i = 0; i < roles.size(); i++) {
            if (i == roles.size() - 1) {
                role = role + roles.get(i);
            } else {
                role = role + roles.get(i) + " / ";
            }
        }
        tvCelebrityRoles.setText(role);
        //作品
        MovieAdapter worksAdapter = new MovieAdapter(subjectsBeans);
        rvWorks.setAdapter(worksAdapter);
        worksAdapter.setOnItemClickListener(this);
        //更多作品
        tvCelebrityMore.setBackgroundColor(getIntent().getIntExtra("color", getResources().getColor(R.color.colorMovie)));
    }

    @Override
    public void onClick(View view) {
        finish();
    }

    @Override
    public void onItemClick(String id, String img_url, String title) {
        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("theme", getIntent().getIntExtra("theme", R.style.MovieThemeTransNav));
        intent.putExtra("img_url", img_url);
        intent.putExtra("title", title);
        intent.putExtra("color", getIntent().getIntExtra("color", getResources().getColor(R.color.colorMovie)));
        startActivity(intent);
    }
}
