package cn.flyexp.douban_movie.presenter.ipresenter;

import cn.flyexp.douban_movie.model.MovieSubjectsModel;

/**
 * Created by Won on 2017/3/12.
 */

public interface IMovieDetailPresenter {

    //加载数据
    void loadingData(String id);
    //判断是否已收藏
    boolean isFavorite(String id);
    //插入数据
    boolean saveFavorite(MovieSubjectsModel movieSubjectsModel);
    //删除数据
    boolean deleteFavorite(String id);

}
