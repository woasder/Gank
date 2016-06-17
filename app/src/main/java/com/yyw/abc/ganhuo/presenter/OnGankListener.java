package com.yyw.abc.ganhuo.presenter;

import com.yyw.abc.ganhuo.model.Ganhuo;
import com.yyw.abc.ganhuo.model.entity.Gank;
import com.yyw.abc.ganhuo.model.entity.GankInfo;

import java.util.List;

/**
 * 获取数据
 * Created by abc on 2016/5/27.
 */
public interface OnGankListener {

    void onSuccess(List<Ganhuo> list);

    /**
     *  失败
     */
    void onError();

}
