package cn.flyexp.douban_movie.assistview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Won on 2016/8/30.
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int space;
    private boolean firstTop = false;

    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    public SpaceItemDecoration(int space, boolean firstTop) {
        this.space = space;
        this.firstTop = firstTop;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = space;
        //获取最后一个可见view的位置
        if (firstTop && parent.getChildPosition(view) == 0) {
            outRect.top = space;
        }
    }
}