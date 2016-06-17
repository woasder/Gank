package com.yyw.abc.ganhuo.model;

import com.yyw.abc.ganhuo.Gank;
import com.yyw.abc.ganhuo.presenter.OnDeleteListener;
import com.yyw.abc.ganhuo.presenter.OnGankListener;
import com.yyw.abc.ganhuo.presenter.OnQueryListener;

/**
 * Created by abc on 2016/6/7.
 */
public interface BookmarkModel {
    void quere(int count, int page, OnQueryListener queryListener);
    void delete(Gank gank, OnDeleteListener onDeleteListener);
}
