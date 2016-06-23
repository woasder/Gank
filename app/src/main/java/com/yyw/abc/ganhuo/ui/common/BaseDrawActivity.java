package com.yyw.abc.ganhuo.ui.common;

import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.yyw.abc.ganhuo.ui.activity.BookMarkActivity;
import com.yyw.abc.ganhuo.ui.activity.SelectActivity;
import com.yyw.abc.ganhuo.utils.AppManager;
import com.yyw.abc.ganhuo.utils.CropCircleTransformation;
import com.yyw.abc.ganhuo.R;

/**
 *
 * Created by abc on 2016/6/6.
 */
public abstract class BaseDrawActivity extends BaseActivity{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView imageView;
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(R.layout.activity_draw);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawlayout);
        navigationView = (NavigationView)findViewById(R.id.navigation_header_container);
        ViewGroup viewGroup = (ViewGroup)findViewById(R.id.flRoot);
        LayoutInflater.from(this).inflate(layoutResID,viewGroup,true);
        initData();
        initView();
        setupHeader();
        setupToolBar();
    }

    protected abstract void initData();

    protected abstract void initView();

    @Override
    protected void setupToolBar() {
        super.setupToolBar();
        if (getToolbar() != null){
            getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("toolbar","-->open");
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
            });
        }
    }

    private void setupHeader(){
        View  headerView = navigationView.getHeaderView(0);
        imageView = (ImageView)headerView.findViewById(R.id.profilePhoto);
        headerView.findViewById(R.id.navigation_header).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGlobalMenuHeaderClick();
            }
        });
       Menu menu =  navigationView.getMenu();
        menu.getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d("menu","-->");
                drawerLayout.closeDrawer(Gravity.LEFT);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BookMarkActivity.startBookmark(BaseDrawActivity.this);
                    }
                }, 200);
                return false;
            }
        });
        menu.getItem(3).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AppManager.getAppManager().finishAllActivity();
                return false;
            }
        });
        menu.getItem(1).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                drawerLayout.closeDrawer(Gravity.LEFT);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        SelectActivity.startSelectActivity(BaseDrawActivity.this);
                    }
                }, 200);
                return false;
            }
        });
        Picasso.with(this).load(R.drawable.sycg5)
                .transform(new CropCircleTransformation())
                .into(imageView);
    }
    public void onGlobalMenuHeaderClick(){
        drawerLayout.closeDrawer(Gravity.LEFT);
    }
}
