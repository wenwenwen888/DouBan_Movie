package cn.flyexp.douban_movie;

import android.app.Application;

import com.aitangba.swipeback.ActivityLifecycleHelper;

/**
 * Created by Won on 2017/3/11.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //滑动返回注册
        registerActivityLifecycleCallbacks(ActivityLifecycleHelper.build());
    }
}
