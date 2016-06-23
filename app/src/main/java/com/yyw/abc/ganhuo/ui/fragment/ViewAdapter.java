package com.yyw.abc.ganhuo.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.yyw.abc.ganhuo.ui.activity.FragmentEntity;

import java.util.List;

/**
 * Created by abc on 2016/6/22.
 */
public class ViewAdapter extends FragmentStatePagerAdapter{
    private List<FragmentEntity> fragments;
    public ViewAdapter(FragmentManager fm,List<FragmentEntity> fragments) {
        super(fm);
        this.fragments =fragments;
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
