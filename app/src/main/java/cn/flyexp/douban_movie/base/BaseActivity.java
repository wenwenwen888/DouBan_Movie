package cn.flyexp.douban_movie.base;

import android.os.Bundle;

import com.aitangba.swipeback.SwipeBackActivity;

import butterknife.ButterKnife;
import cn.flyexp.douban_movie.R;

/**
 * Created by Won on 2017/3/11.
 */

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends SwipeBackActivity {

    protected T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(getIntent().getIntExtra("theme", R.style.MovieThemeTransNav));
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        ButterKnife.bind(this);
        presenter = initPresenter();
        presenter.attach((V) this);
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
        presenter.onDestroy();
    }

    abstract protected T initPresenter();

    abstract protected int setLayoutId();

    abstract protected void initView();

}
