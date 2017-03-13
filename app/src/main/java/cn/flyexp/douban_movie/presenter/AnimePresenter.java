package cn.flyexp.douban_movie.presenter;

import cn.flyexp.douban_movie.base.BasePresenter;
import cn.flyexp.douban_movie.presenter.ipresenter.IAnimePresenter;
import cn.flyexp.douban_movie.view.iview.IAnimeView;

/**
 * Created by Won on 2017/3/12.
 */

public class AnimePresenter extends BasePresenter<IAnimeView> implements IAnimePresenter{

    @Override
    protected void onDestory() {

    }
}
