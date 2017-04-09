package cn.flyexp.douban_movie.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.flyexp.douban_movie.R;

public class PhotoActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    PhotoView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
        //启用图片缩放功能
        imageView.enable();
        Glide.with(this).load(getIntent().getStringExtra("img_url")).
                diskCacheStrategy(DiskCacheStrategy.SOURCE).crossFade().into(imageView);
    }

    @OnClick({R.id.imageView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView:
                finish();
                break;
        }
    }

}
