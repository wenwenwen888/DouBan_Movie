package cn.flyexp.douban_movie.presenter.ipresenter;

import java.util.ArrayList;

/**
 * Created by Won on 2017/3/12.
 */

public interface IFavoritePresenter {

    //加载内容
    void loadData();

    //删除内容
    boolean deleteData(ArrayList<String> selectIds);

}
