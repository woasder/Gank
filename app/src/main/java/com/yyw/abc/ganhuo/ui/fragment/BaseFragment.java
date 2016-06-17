package com.yyw.abc.ganhuo.ui.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.yyw.abc.ganhuo.R;
import com.yyw.abc.ganhuo.RxBus.RxBus;
import com.yyw.abc.ganhuo.RxBus.UserEvent;
import com.yyw.abc.ganhuo.model.Ganhuo;
import com.yyw.abc.ganhuo.model.entity.Gank;
import com.yyw.abc.ganhuo.model.entity.GankInfo;
import com.yyw.abc.ganhuo.presenter.GankPresenter;
import com.yyw.abc.ganhuo.presenter.GankPresenterImpl;
import com.yyw.abc.ganhuo.ui.view.IShowGankView;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by abc on 2016/5/29.
 */
public class  BaseFragment extends Fragment implements IShowGankView{
    private static final String TAG = "Fragment";
    private String type;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private GankPresenter gankPresenter;
    private ProgressDialog progressDialog;
    private List<Ganhuo> gankInfos = new ArrayList<>();
    private GankAdapter gankAdapter;
    private int page = 1;
    private boolean isOnScrolling = true;
    private Subscription subscription;

    public static BaseFragment getInstance(String type){
        BaseFragment baseFragment = new BaseFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type",type);
        baseFragment.setArguments(bundle);
        return baseFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        type = bundle.getString("type");
        Log.d("TAG",type);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("TAG",type);
        View view = inflater.inflate(R.layout.base_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycle);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swip);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BMark",type+"-->recyclerView ");
            }
        });
        gankPresenter = new GankPresenterImpl(this);

        gankAdapter = new GankAdapter(gankInfos,type);

        recyclerView.setAdapter(gankAdapter);

        gankPresenter.getGank(type,20,page);

       // swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d("TAG","swip onRefresh");

                page = 1;
                gankPresenter.refresh(type,20);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    swipeRefreshLayout.setRefreshing(false);
                    }
                },5000);
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visible = linearLayoutManager.getChildCount();
                int total = linearLayoutManager.getItemCount();
                int past = linearLayoutManager.findFirstVisibleItemPosition();
                Log.d("",visible+","+total+","+past+",");
                if (isOnScrolling && visible + past >= total && dy >0){
                    isOnScrolling = false;
                    page++;
                    gankPresenter.getGank(type,20,page);
                }
            }
        });
        progressDialog = new ProgressDialog(getActivity());

        progressDialog.setTitle("加载中");

        gankAdapter.setGankItemListener(new GankAdapter.GankItemListener() {
            @Override
            public void OnAdd(int position) {
                Log.d("BMark",type+"-->OnAdd "+position);

                com.yyw.abc.ganhuo.Gank gank = new com.yyw.abc.ganhuo.Gank();
                Log.d("BMark","-->click "+gankInfos.get(position).getDesc());
                Log.d("BMark","-->click "+gankInfos.get(position).getSid());
                Log.d("BMark","-->click "+gankInfos.get(position).getWho());
                Log.d("BMark","-->click "+gankInfos.get(position).getPublishedAt());
                gank.setDesc(gankInfos.get(position).getDesc());
                gank.setSid(gankInfos.get(position).getSid());
                gank.setWho(gankInfos.get(position).getWho());
                gank.setPublishedAt(gankInfos.get(position).getPublishedAt());
                gank.setType(type);
                gank.setUrl(gankInfos.get(position).getUrl());
                gankPresenter.addToMark(gank);
            }

            @Override
            public void Ondel(int position) {
                Log.d("BMark",type+"-->Ondel "+position);
                com.yyw.abc.ganhuo.Gank gank = new com.yyw.abc.ganhuo.Gank();
                gank.setSid(gankInfos.get(position).getSid());
                gankPresenter.delFromMark(gank);
            }
        });
        //gankInfos.
      //  recyclerView.getChildAt(gankInfos.indexOf("")).findViewById(R.id.btnlike).performClick();
        subscription = RxBus.getDefaultInstance().toObservable(UserEvent.class)
                .subscribe(new Action1<UserEvent>() {
                    @Override
                    public void call(UserEvent userEvent) {
                        long id = userEvent.getId();
                        String sid = userEvent.getName();
                        if (id == 101){
                            for (int i = 0;i<gankInfos.size();i++){
                                if (gankInfos.get(i).getSid().equals(sid)){
                                    ImageButton imageButton = (ImageButton)recyclerView.getChildAt(i).findViewById(R.id.btnlike);
                                    imageButton.setImageResource(R.drawable.ic_heart_outline_grey);
                                    gankInfos.get(i).setMarked(false);
                                }
                            }
                        }else if (id == 102){

                        }


                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        //// TODO: 2016/6/14 error
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

    @Override
    public void showLoading() {
        Log.d("TAG","showLoading");
      //  progressDialog.show();
     //   swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        Log.d("TAG","hideLoading");
     //   progressDialog.dismiss();
        isOnScrolling = true;
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setGankInfo(List<Ganhuo> list) {
        Log.d("BM",type);
        if (page == 1){
            gankInfos.clear();
        }
        for (int i = 0;i<list.size();i++){
            gankInfos.add(list.get(i));
        }
        gankAdapter.notifyDataSetChanged();
    }

    @Override
    public void showFailedError() {
      //  Snackbar.make(getActivity(),"加载错误",Snackbar.LENGTH_LONG);
    }

    @Override
    public void showMark() {

    }

}
