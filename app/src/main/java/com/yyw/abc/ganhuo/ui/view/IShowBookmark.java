package com.yyw.abc.ganhuo.ui.view;

import com.yyw.abc.ganhuo.Gank;
import com.yyw.abc.ganhuo.model.entity.GankInfo;

import java.util.List;

/**
 * Created by abc on 2016/6/7.
 */
public interface IShowBookmark {
    void showLoading();
    void hideLoading();
    void setMatkGank(List<Gank> list);
}
