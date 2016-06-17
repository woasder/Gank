package com.yyw.abc.ganhuo.ui.common;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.yyw.abc.ganhuo.R;
import com.yyw.abc.ganhuo.utils.AppManager;

/**
 *
 * Created by abc on 2016/5/27.
 */
public  class BaseActivity extends AppCompatActivity{

    private Toolbar toolbar;
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        /*initView();
        initData();*/


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
    }



    protected void setupToolBar(){
        Log.d("Base","toolbar");
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        if (toolbar != null){
            Log.d("Base","toolbar!=null");
            toolbar.setTitle("Gank");
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_menu_white);

        }
    }

    public Toolbar getToolbar(){
        return toolbar;
    }

}
