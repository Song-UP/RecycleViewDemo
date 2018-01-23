package llapps.com.recycleviewdemo.been;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by wusong on 2018/1/22.
 *
 *
 */

public abstract class SpaceDecoration extends RecyclerView.ItemDecoration {
    float widthPx = 0;

    public SpaceDecoration(Context context , int widthDp) {
        float scale = context.getResources().getDisplayMetrics().density;
        this.widthPx = scale * widthDp +0.5f;

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = (int)widthPx;
        long index = parent.getChildAdapterPosition(view);  //获得所在的位置
        int isLeft = isItemLeft(index);
        if (isLeft == -1){ //在左边
            right = (int) widthPx/2 ;

        }else if (isLeft == 1){
            left = (int) widthPx/2 ;
        }

        outRect.set(left, top,right, bottom);

    }

    public abstract int isItemLeft(long position);
}
