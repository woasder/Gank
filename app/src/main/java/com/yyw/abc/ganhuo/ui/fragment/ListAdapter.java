package com.yyw.abc.ganhuo.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yyw.abc.ganhuo.ui.activity.FragmentEntity;

import java.util.List;

/**
 * Created by abc on 2016/5/29.
 */
public class ListAdapter extends FragmentPagerAdapter{
    private List<FragmentEntity> fragments;
    private List<String> titles;
    public ListAdapter(FragmentManager fm, List<FragmentEntity> fragments ,List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getType();
    }


}
