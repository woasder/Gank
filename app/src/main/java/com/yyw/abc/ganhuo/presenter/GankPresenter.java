package com.yyw.abc.ganhuo.presenter;

import com.yyw.abc.ganhuo.Gank;

/**
 * Created by abc on 2016/5/27.
 */
public interface GankPresenter {
    void getGank(String type,int count,int page);
    void refresh(String type,int count);
    void addToMark(Gank gank);
    void delFromMark(Gank gank);
}
