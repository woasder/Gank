package com.yyw.abc.ganhuo.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yyw.abc.ganhuo.R;
import com.yyw.abc.ganhuo.RxBus.RxBus;
import com.yyw.abc.ganhuo.RxBus.UserEvent;
import com.yyw.abc.ganhuo.Type;
import com.yyw.abc.ganhuo.presenter.select.SelectPresenter;
import com.yyw.abc.ganhuo.presenter.select.SelectPresenterImpl;
import com.yyw.abc.ganhuo.ui.common.BaseActivity;
import com.yyw.abc.ganhuo.ui.view.IShowSelect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by abc on 2016/6/17.
 */
public class SelectActivity extends BaseActivity implements IShowSelect{

    private RecyclerView recyclerView;
    private SelectAdapter selectAdapter;
    private Button btSave;

    private String[] types= {"福利","Android","iOS","休息视频","拓展资源","前端","all"};
    private List<String> stringlist;
    private List<Type> typeList;
    private SelectPresenter selectPresenter;

    public static void startSelectActivity(Activity activity){
        Intent intent = new Intent(activity,SelectActivity.class);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        setupToolBar();
        init();
    }

    private void init() {
        selectPresenter = new SelectPresenterImpl(this);

        recyclerView = (RecyclerView)findViewById(R.id.recycle);
        btSave = (Button)findViewById(R.id.btSave);

        stringlist = Arrays.asList(types);
        typeList = new ArrayList<>();

        selectAdapter = new SelectAdapter(typeList);
        recyclerView.setAdapter(selectAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new SelectItemDecoration(this,SelectItemDecoration.VERTICAL_LIST));
        //selectAdapter.notifyDataSetChanged();

        selectPresenter.loadType();
        selectAdapter.setOnChecked(new SelectAdapter.OnChecked() {
            @Override
            public void add(int position, String type, boolean flag) {
                typeList.get(position).setIsChecked(flag);
            }
        });
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("select","-->save");
                selectPresenter.saveType(typeList);
                RxBus.getDefaultInstance().post(new UserEvent(102,"select"));
            }
        });

    }

    @Override
    protected void setupToolBar() {
        super.setupToolBar();
        if (getToolbar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SelectActivity.this.finish();
                }
            });
        }
    }


    @Override
    public void setType(List<Type> list) {

        if (list.isEmpty()){
            Log.d("select","setType list==null");
            typeList.clear();
            for (int i =0;i<stringlist.size();i++){
                Type type = new Type();
                type.setType(stringlist.get(i));
                type.setIsChecked(true);
                type.setSid(i);
                typeList.add(i,type);
            }
        }else {
            Log.d("select","setType list!=null");
            typeList.clear();
            for (int i=0;i<list.size();i++){
                if (list.get(i).getIsChecked()){
                    Log.d("select","number "+i);
                }
                Type type = new Type();
                type.setType(list.get(i).getType());
                type.setIsChecked(list.get(i).getIsChecked());
                type.setSid(list.get(i).getSid());
                typeList.add(i,type);
            }
        }
        Log.d("select","setType "+typeList.size());
        selectAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoad() {
        Log.d("selsect","showLoad");
    }

    @Override
    public void hideLoad() {
        Log.d("selsect","success");
    }

    @Override
    public void showError() {
        Log.d("selsect","error");
    }
}
