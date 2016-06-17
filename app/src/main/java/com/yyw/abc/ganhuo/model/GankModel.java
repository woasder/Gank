package com.yyw.abc.ganhuo.model;

import com.yyw.abc.ganhuo.Gank;
import com.yyw.abc.ganhuo.presenter.OnAddMarkListener;
import com.yyw.abc.ganhuo.presenter.OnGankListener;

/**
 * Created by abc on 2016/5/27.
 */
public interface GankModel {
    void loadGank(String type,int count,int page,OnGankListener onGankListener);
    void addToMark(Gank gank,  OnAddMarkListener onAddMarkListener);
    void delFromMark(Gank gank);
}
