package cn.flyexp.douban_movie.view.fragment;

import android.content.Intent;

import butterknife.BindView;
import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.adapter.TagAdapter;
import cn.flyexp.douban_movie.assistview.FullyGridLayoutManager;
import cn.flyexp.douban_movie.assistview.MyRecyclerView;
import cn.flyexp.douban_movie.assistview.SpaceItemDecoration;
import cn.flyexp.douban_movie.base.LazyFragment;
import cn.flyexp.douban_movie.model.TagData;
import cn.flyexp.douban_movie.view.activity.SearchDetailActivity;

/**
 * Created by Won on 2016/5/4.
 */
public class TagFragment extends LazyFragment implements TagAdapter.IOnItemClickListener {

    private static final String TAG = "TagFragment";

    @BindView(R.id.rv_type)
    MyRecyclerView rvType;
    @BindView(R.id.rv_country)
    MyRecyclerView rvCountry;
    @BindView(R.id.rv_artist)
    MyRecyclerView rvArtist;
    @BindView(R.id.rv_year)
    MyRecyclerView rvYear;

    @Override
    protected int setLayoutId() {
        return R.layout.main_tag;
    }

    @Override
    protected void initView() {
        initRecyclerView(rvType, TagData.types);
        initRecyclerView(rvCountry, TagData.countrys);
        initRecyclerView(rvArtist, TagData.artists);
        initRecyclerView(rvYear, TagData.years);
    }

    private void initRecyclerView(MyRecyclerView myRecyclerView, String[] datas) {
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.item_space);

        myRecyclerView.setLayoutManager(new FullyGridLayoutManager(getContext(), 4));//Gird类型
        myRecyclerView.addItemDecoration(new SpaceItemDecoration(spacingInPixels));//设置间隔
        myRecyclerView.setNestedScrollingEnabled(false);

        TagAdapter tagAdapter = new TagAdapter(datas);
        myRecyclerView.setAdapter(tagAdapter);

        tagAdapter.setOnItemClickListener(this);//监听点击
    }


    /**
     * 实现懒加载,当屏幕显示这个界面的时候才会触发次方法
     */
    @Override
    protected void lazyLoad() {
        //显示数据
        if (isPrepared && isVisible) {

        }
    }

    @Override
    public void onItemClick(String tag) {
        Intent intent = new Intent(getContext(), SearchDetailActivity.class);
        intent.putExtra("theme", R.style.TagThemeTransNav);
        intent.putExtra("color", getResources().getColor(R.color.colorTag));
        intent.putExtra("tag", tag);
        startActivity(intent);
    }
}
