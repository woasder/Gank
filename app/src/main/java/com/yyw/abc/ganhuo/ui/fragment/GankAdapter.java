package com.yyw.abc.ganhuo.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yyw.abc.ganhuo.R;
import com.yyw.abc.ganhuo.model.Ganhuo;
import com.yyw.abc.ganhuo.utils.GanhuoApplication;

import java.util.List;

/**
 *
 * Created by abc on 2016/5/30.
 */
public class GankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<Ganhuo> resultsBeens;
    private int nomalType = 1;
    private int endType = 2;
    private String type;
    private  GankItemListener gankItemListener;

    public GankAdapter(List<Ganhuo> resultsBeens,String type){
        this.resultsBeens = resultsBeens;
        this.type = type;
    }
    public void setGankItemListener(GankItemListener gankItemListener){
        this.gankItemListener = gankItemListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == nomalType){
            if (type.equals("福利")){
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_image,parent,false);
                return new ImageHolder(view);
            }else {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_nomal,parent,false);
                return new NomalHolder(view);
            }

        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_end,parent,false);
            return new EndHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof NomalHolder){
            ((NomalHolder) holder).tvDes.setText(resultsBeens.get(position).getDesc());
            ((NomalHolder) holder).tvAuthor.setText(resultsBeens.get(position).getWho());
            String time = resultsBeens.get(position).getPublishedAt();
            String time1 = time.substring(0,time.indexOf("T"));
            ((NomalHolder) holder).tvTime.setText(time1);
            boolean isMarked = resultsBeens.get(position).isMarked();
            if (isMarked){
                ((NomalHolder) holder).btnlike.setImageResource(R.drawable.ic_heart_red);
            }else {
                ((NomalHolder) holder).btnlike.setImageResource(R.drawable.ic_heart_outline_grey);
            }
            ((NomalHolder) holder).btnlike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isMarked = resultsBeens.get(position).isMarked();
                    if (isMarked){
                        resultsBeens.get(position).setMarked(false);
                        ((NomalHolder) holder).btnlike.setImageResource(R.drawable.ic_heart_outline_grey);
                        gankItemListener.Ondel(position);

                    }else {
                        resultsBeens.get(position).setMarked(true);
                        ((NomalHolder) holder).btnlike.setImageResource(R.drawable.ic_heart_red);
                        gankItemListener.OnAdd(position);
                    }

                }
            });
        }else if (holder instanceof ImageHolder){

            Picasso.with(GanhuoApplication.getContext()).load(resultsBeens.get(position).getUrl())
                    .placeholder(R.drawable.sycg5)

                    .into(((ImageHolder) holder).ivRecycle);
        }

    }


    @Override
    public int getItemCount() {
        return resultsBeens.isEmpty()?0:resultsBeens.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == resultsBeens.size()){
            return endType;
        }
        return nomalType;
    }

    public static class NomalHolder extends RecyclerView.ViewHolder {
        public TextView tvDes;
        public TextView tvAuthor;
        public TextView tvTime;
        public ImageButton btnlike;
        public NomalHolder(View itemView) {
            super(itemView);
            tvDes = (TextView) itemView.findViewById(R.id.tvDes);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            btnlike = (ImageButton)itemView.findViewById(R.id.btnlike);

        }
    }

    public static class EndHolder extends RecyclerView.ViewHolder{
        public TextView tvEnd;
        public EndHolder(View itemView) {
            super(itemView);
            tvEnd = (TextView)itemView.findViewById(R.id.tvEnd);
        }
    }

    public static class ImageHolder extends RecyclerView.ViewHolder{
        public ImageView ivRecycle;
        public ImageHolder(View itemView) {
            super(itemView);
            ivRecycle = (ImageView)itemView.findViewById(R.id.ivRecycle);
        }
    }

    public interface GankItemListener{
        void OnAdd(int position);
        void Ondel(int possition);
    }
}
