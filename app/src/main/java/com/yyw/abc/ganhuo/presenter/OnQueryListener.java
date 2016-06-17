package com.yyw.abc.ganhuo.presenter;

import com.yyw.abc.ganhuo.Gank;

import java.util.List;

/**
 * Created by abc on 2016/6/9.
 */
public interface OnQueryListener {
    void onQuerySuccess(List<Gank> list);
    void onQueryError();
}
