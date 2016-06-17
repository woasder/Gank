package com.yyw.abc.ganhuo.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.yyw.abc.ganhuo.R;
import com.yyw.abc.ganhuo.ui.common.BaseDrawActivity;
import com.yyw.abc.ganhuo.ui.fragment.BaseFragment;
import com.yyw.abc.ganhuo.ui.common.BaseActivity;
import com.yyw.abc.ganhuo.ui.fragment.ListAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseDrawActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] types= {"福利","Android","iOS","休息视频","拓展资源","前端","all"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initView() {
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        List<String> titleList = Arrays.asList(types);
        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0;i<titleList.size();i++){
            Log.d("BM",titleList.get(i));
            BaseFragment baseFragment = BaseFragment.getInstance(titleList.get(i));
            fragmentList.add(baseFragment);
        }
        ListAdapter listAdapter = new ListAdapter(getSupportFragmentManager(),fragmentList,titleList);
        viewPager.setAdapter(listAdapter);
        viewPager.setOffscreenPageLimit(7);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }


}
