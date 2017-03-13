package cn.flyexp.douban_movie.presenter;

import cn.flyexp.douban_movie.base.BasePresenter;
import cn.flyexp.douban_movie.presenter.ipresenter.IMoviePresenter;
import cn.flyexp.douban_movie.view.iview.IMovieView;

/**
 * Created by Won on 2017/3/12.
 */

public class MoviePresenter extends BasePresenter<IMovieView> implements IMoviePresenter{

    @Override
    public void setData() {
        mView.showData();
    }

    @Override
    protected void onDestory() {

    }
}
