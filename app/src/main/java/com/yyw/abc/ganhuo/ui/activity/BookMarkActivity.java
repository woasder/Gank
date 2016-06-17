package com.yyw.abc.ganhuo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.yyw.abc.ganhuo.R;
import com.yyw.abc.ganhuo.model.entity.Gank;
import com.yyw.abc.ganhuo.model.entity.GankInfo;
import com.yyw.abc.ganhuo.presenter.BookmarkPresenter;
import com.yyw.abc.ganhuo.presenter.BookmarkPresenterImpl;
import com.yyw.abc.ganhuo.ui.common.BaseActivity;
import com.yyw.abc.ganhuo.ui.common.BaseDrawActivity;
import com.yyw.abc.ganhuo.ui.fragment.GankAdapter;
import com.yyw.abc.ganhuo.ui.view.IShowBookmark;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by abc on 2016/6/7.
 */
public class BookMarkActivity extends BaseActivity implements IShowBookmark{

    private RecyclerView recyclerView;
    private List<com.yyw.abc.ganhuo.Gank> resultsBeens;
    private BookmarkAdapter bookmarkAdapter;
    private int page =1;
    private boolean isOnScrolling = true;

    public static void startBookmark(Activity activity){
        Intent intent = new Intent(activity,BookMarkActivity.class);
        activity.startActivity(intent);

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
        initView();
        setupToolBar();
    }




    private void initView() {
        recyclerView = (RecyclerView)findViewById(R.id.recycle);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        resultsBeens = new ArrayList<>();
        bookmarkAdapter = new BookmarkAdapter(resultsBeens);
        recyclerView.setAdapter(bookmarkAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        final BookmarkPresenter bookmarkPresenter = new BookmarkPresenterImpl(this);
        bookmarkPresenter.queryGank(20,page);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int count = linearLayoutManager.getChildCount();
                int visiable = linearLayoutManager.getItemCount();
                int last = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if ( isOnScrolling && dy>0 && visiable+last>=count){
                    isOnScrolling = false;
                    page++;
                    bookmarkPresenter.queryGank(20,page);
                }
            }
        });
        bookmarkAdapter.setNotMarkListener(new BookmarkAdapter.NotMark() {
            @Override
            public void onNotMark(int position) {
                com.yyw.abc.ganhuo.Gank gank =resultsBeens.get(position);
                Log.d("BMark","-->before"+resultsBeens.size());
                bookmarkPresenter.deleteGank(gank);
              //  bookmarkPresenter.queryGank(20,page);

            }
        });
    }

    /*private void setupToolbar(){
        if (getToolbar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
    }*/

    @Override
    protected void setupToolBar() {
        super.setupToolBar();
        if (getToolbar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getToolbar().setTitle("收藏");
            getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
        isOnScrolling = true;
        Log.d("BMark","-->after"+resultsBeens.size());
    }

    @Override
    public void setMatkGank(List<com.yyw.abc.ganhuo.Gank> list) {
        resultsBeens.clear();
        for (int i=0;i<list.size();i++){
            resultsBeens.add(list.get(i));
            Log.d("BMMark","--> " +resultsBeens.get(i).getDesc()+" "+resultsBeens.get(i).getId() );
        }
        bookmarkAdapter.notifyDataSetChanged();
    }


}
