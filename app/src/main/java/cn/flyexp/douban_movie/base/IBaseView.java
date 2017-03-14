package cn.flyexp.douban_movie.base;

import java.util.ArrayList;

/**
 * Created by Won on 2017/3/12.
 */

public interface IBaseView {

    /**
     * showLoading 方法主要用于页面请求数据时显示加载状态
     */
    void showLoading();

    /**
     * showEmpty 方法用于请求的数据为空的状态
     */
    void showEmpty();

    /**
     * showError 方法用于请求数据出错
     */
    void showError();

    /**
     * loadingComplete 方法用于请求数据完成
     */
    void showComplete(ArrayList<?> models);

}
