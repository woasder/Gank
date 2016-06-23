package com.yyw.abc.ganhuo.ui.activity;

import android.support.v4.app.Fragment;

/**
 * Created by abc on 2016/6/21.
 */
public class FragmentEntity {
    private String type;
    private Fragment fragment;

    public FragmentEntity(Fragment fragment, String type) {
        this.fragment = fragment;
        this.type = type;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
