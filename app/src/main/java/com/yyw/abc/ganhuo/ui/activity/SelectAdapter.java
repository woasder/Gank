package com.yyw.abc.ganhuo.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.yyw.abc.ganhuo.R;
import com.yyw.abc.ganhuo.Type;

import java.util.List;

/**
 * Created by abc on 2016/6/17.
 */
public class SelectAdapter extends RecyclerView.Adapter<SelectAdapter.NomalHolder>{
    private List<Type> mData;
    private OnChecked onChecked;

    public SelectAdapter(List<Type> mData) {
        this.mData = mData;

    }

    @Override
    public NomalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_select,parent,false);
        return new NomalHolder(view);
    }

    @Override
    public void onBindViewHolder(NomalHolder holder, final int position) {
        holder.tvTitle.setText(mData.get(position).getType());
        holder.cbSelect.setChecked(mData.get(position).getIsChecked());

        holder.cbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               onChecked.add(position,mData.get(position).getType(),isChecked);
                Log.d("select",position+"-->"+isChecked);
               // mData.get(position).setIsChecked(isChecked);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }

    public static class NomalHolder extends RecyclerView.ViewHolder{
        public TextView tvTitle;
        public CheckBox cbSelect ;
        public NomalHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView)itemView.findViewById(R.id.tvTitle);
            cbSelect = (CheckBox)itemView.findViewById(R.id.cbSelect);
        }
    }

    public void setOnChecked(OnChecked onChecked){
        this.onChecked = onChecked;
    }

    public interface OnChecked{
        void add(int position,String type,boolean flag);
    }
}
