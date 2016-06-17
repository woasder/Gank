package com.yyw.abc.ganhuo.ui.activity;

import android.content.pm.ProviderInfo;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yyw.abc.ganhuo.Gank;
import com.yyw.abc.ganhuo.R;
import com.yyw.abc.ganhuo.RxBus.RxBus;
import com.yyw.abc.ganhuo.RxBus.UserEvent;
import com.yyw.abc.ganhuo.utils.GanhuoApplication;

import java.util.List;

/**
 * Created by abc on 2016/6/7.
 */
public class BookmarkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int NOMALTYPE = 0;
    private static final int ENDTYPE = 2;
    private static final int IMAGETYE = 1;
    private List<Gank> list;
    public BookmarkAdapter(List<Gank> list){
        this.list= list;
    }
    private NotMark notMark;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*if (viewType == ENDTYPE){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_end,parent,false);
            return new endHolder(view);
        }else*/ if (viewType == IMAGETYE){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_image,parent,false);
            return new imageHolder(view);
        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_nomal,parent,false);
            return new nomalHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof nomalHolder){
            ((nomalHolder) holder).tvDes.setText(list.get(position).getDesc());
            ((nomalHolder) holder).tvAuthor.setText(list.get(position).getWho());
            String time = list.get(position).getPublishedAt();
            String time1 = time.substring(0,time.indexOf("T"));
            ((nomalHolder) holder).tvTime.setText(time1);
            ((nomalHolder) holder).btnlike.setImageResource(R.drawable.ic_heart_red);
            ((nomalHolder) holder).btnlike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notMark.onNotMark(position);
                    RxBus.getDefaultInstance().post(new UserEvent(101,list.get(position).getSid()));
                    removeData(position);

                }
            });
        }else if ( holder instanceof imageHolder){
            Picasso.with(GanhuoApplication.getContext()).load(list.get(position).getUrl())
                    .placeholder(R.drawable.sycg5)
                    .centerCrop()
                    .into(((imageHolder) holder).ivRecycle);
        }
    }

    @Override
    public int getItemCount() {
        return list.isEmpty()?0:list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.isEmpty()){
            return NOMALTYPE;
        }else {
           // Log.d("BMark",list.get(position).getDesc()+"-->"+list.get(position).getType());
            /*if (position == list.size()){
                return ENDTYPE;
            }else*/ if (list.get(position).getType().equals("福利")){
                return IMAGETYE;
            }else {
                return NOMALTYPE;
            }
        }

    }



    public static class nomalHolder extends RecyclerView.ViewHolder{
        public TextView tvDes;
        public TextView tvAuthor;
        public TextView tvTime;
        public ImageButton btnlike;
        public nomalHolder(View itemView) {
            super(itemView);
            tvDes = (TextView) itemView.findViewById(R.id.tvDes);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            btnlike = (ImageButton)itemView.findViewById(R.id.btnlike);
        }
    }
    public static class imageHolder extends RecyclerView.ViewHolder{
        public ImageView ivRecycle;
        public imageHolder(View itemView) {
            super(itemView);
            ivRecycle = (ImageView)itemView.findViewById(R.id.ivRecycle);
        }
    }
    /*public static class endHolder extends RecyclerView.ViewHolder{
        public TextView tvEnd;
        public endHolder(View itemView) {
            super(itemView);
            tvEnd = (TextView)itemView.findViewById(R.id.tvEnd);
        }
    }*/

    public void removeData(int position){
        list.remove(position);
        notifyItemRemoved(position);
        if (position != list.size()){
            notifyItemRangeChanged(position,list.size()-position);
        }
    }

    public void setNotMarkListener(NotMark notMarkListener){
        this.notMark = notMarkListener;
    }

    public interface NotMark{
        void onNotMark(int position);
    }
}
