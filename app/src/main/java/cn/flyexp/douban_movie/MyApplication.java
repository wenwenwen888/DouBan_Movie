package cn.flyexp.douban_movie;

import com.aitangba.swipeback.ActivityLifecycleHelper;

import org.litepal.LitePalApplication;

/**
 * Created by Won on 2017/3/11.
 */

public class MyApplication extends LitePalApplication {

    public static int REQUESTCODE = 0x00;

    public static int RESULTCODE = 0x01;

    @Override
    public void onCreate() {
        super.onCreate();
        //滑动返回注册
        registerActivityLifecycleCallbacks(ActivityLifecycleHelper.build());
    }
}
