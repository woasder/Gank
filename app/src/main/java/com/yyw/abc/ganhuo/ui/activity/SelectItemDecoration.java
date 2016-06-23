package com.yyw.abc.ganhuo.ui.activity;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by abc on 2016/6/18.
 */
public class SelectItemDecoration extends RecyclerView.ItemDecoration{

    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    private int mOrientation;
    private Drawable mDrawble;

    public SelectItemDecoration(Context context , int mOrientation) {
        TypedArray typedArray = context.obtainStyledAttributes(new int[]{android.R.attr.listDivider});
        mDrawble = typedArray.getDrawable(0);
        typedArray.recycle();
        setOrientation(mOrientation);
    }

    public void setOrientation(int orientation){
        if (orientation  != HORIZONTAL_LIST && orientation != VERTICAL_LIST){
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (parent.getLayoutManager() instanceof GridLayoutManager){

        }else {
            if (mOrientation == VERTICAL_LIST){
                drawVertical(c,parent);
            }else {
                drawHorizontal(c,parent);
            }
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (mOrientation == VERTICAL_LIST){
            outRect.set(0,0,0,mDrawble.getIntrinsicHeight());
        }else {
            outRect.set(0,0,mDrawble.getIntrinsicWidth(),0);
        }
    }

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int top = recyclerView.getPaddingTop();
        int bottom = recyclerView.getBottom() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i=0;i<childCount;i++){
            View child = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getRight()+layoutParams.rightMargin;
            int right = left+mDrawble.getIntrinsicHeight();
            mDrawble.setBounds(left,top,right,bottom);
            mDrawble.draw(canvas);
        }

    }

    private void drawVertical(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0;i<childCount;i++){
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom()+layoutParams.bottomMargin;
            int bottom = top + mDrawble.getIntrinsicHeight();
            mDrawble.setBounds(left,top,right,bottom);
            mDrawble.draw(c);
        }
    }
}
