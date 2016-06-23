package com.yyw.abc.ganhuo.ui.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.Collections;
import java.util.List;

/**
 * Created by abc on 2016/6/17.
 */
public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback{
    private List<String> mData;
    private SelectAdapter selectAdapter;
    public SimpleItemTouchHelperCallback(List<String> mData,SelectAdapter selectAdapter) {
        this.mData = mData;
        this.selectAdapter = selectAdapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        final int swipeFlags = 0;

        return makeMovementFlags(dragFlags,swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int fromPosition = viewHolder.getAdapterPosition();
        int toPosition = target.getAdapterPosition();
        if (fromPosition < toPosition){
            for (int i = fromPosition;i<toPosition;i++){
                Collections.swap(mData,i,i+1);
            }
        }else {
            for (int i= fromPosition;i>toPosition;i--){
                Collections.swap(mData,i,i-1);
            }
        }
        selectAdapter.notifyItemMoved(fromPosition,toPosition);
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }
}
