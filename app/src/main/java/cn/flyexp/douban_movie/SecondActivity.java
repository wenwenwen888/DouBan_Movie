package cn.flyexp.douban_movie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.second_toolbar)
    Toolbar secondToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTheme(getIntent().getIntExtra("theme" , R.style.MovieThemeTransNav));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        //toolbar设置初始标题
        secondToolbar.setTitle(getResources().getString(R.string.movie));
        //以上属性必须在setSupportActionBar(toolbar)之前调用
        setSupportActionBar(secondToolbar);
        secondToolbar.setBackgroundColor(getIntent().getIntExtra("color" , getResources().getColor(R.color.colorMovie)));

    }
}
