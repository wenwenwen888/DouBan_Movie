package cn.flyexp.douban_movie.view.iview;

import java.util.List;

import cn.flyexp.douban_movie.model.MovieSubjectsModel;

/**
 * Created by Won on 2017/3/12.
 */

public interface IFavoriteView {
    /**
     * showLoading 方法主要用于页面请求数据时显示加载状态
     */
    void showLoading();

    /**
     * showEmpty 方法用于请求的数据为空的状态
     */
    void showEmpty();

    /**
     * loadingComplete 方法用于请求数据完成
     */
    void showComplete(List<MovieSubjectsModel> movieSubjectsModels);
}
