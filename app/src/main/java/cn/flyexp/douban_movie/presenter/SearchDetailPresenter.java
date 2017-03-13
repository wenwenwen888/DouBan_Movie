package cn.flyexp.douban_movie.presenter;

import cn.flyexp.douban_movie.base.BasePresenter;
import cn.flyexp.douban_movie.presenter.ipresenter.ISearchDetailPresenter;
import cn.flyexp.douban_movie.view.iview.ISearchDetailView;

/**
 * Created by Won on 2017/3/12.
 */

public class SearchDetailPresenter extends BasePresenter<ISearchDetailView> implements ISearchDetailPresenter {

    @Override
    public void search(String keyword) {
        mView.setTitle(keyword);
    }

    @Override
    protected void onDestory() {

    }

}
