package com.yyw.abc.ganhuo.ui.view;

import com.yyw.abc.ganhuo.model.Ganhuo;
import com.yyw.abc.ganhuo.model.entity.Gank;
import com.yyw.abc.ganhuo.model.entity.GankInfo;

import java.util.List;

/**
 * Created by abc on 2016/5/27.
 */
public interface IShowGankView {
    void showLoading();
    void hideLoading();
    void setGankInfo(List<Ganhuo> list);
    void showFailedError();
    void showMark();
}
