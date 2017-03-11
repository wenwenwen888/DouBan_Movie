package cn.flyexp.douban_movie.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.flyexp.douban_movie.R;
import cn.flyexp.douban_movie.assistview.LazyFragment;


/**
 * Created by Won on 2016/5/4.
 */
public class Top250Fragment extends LazyFragment {

    private static final String TAG = "Top250Fragment";

    private View view;
    // 标志位，标志已经初始化完成。
    private boolean isPrepared;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_top250, container, false);

        initUI();//实例化控件
        isPrepared = true;
        lazyLoad();//加载数据

        return view;
    }

    /**
     * 实例化组件
     */
    private void initUI() {

    }



    @Override
    public void onDestroy() {
        //销毁时释放资源
        super.onDestroy();
    }

    /**
     * 实现懒加载,当屏幕显示这个界面的时候才会触发次方法
     */
    @Override
    protected void lazyLoad() {
        //显示数据
        if (isPrepared && isVisible) {
            Log.e(TAG, "lazyLoad: " + TAG );
        }
    }

}
