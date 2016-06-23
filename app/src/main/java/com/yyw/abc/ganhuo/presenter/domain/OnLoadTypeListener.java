package com.yyw.abc.ganhuo.presenter.domain;

import com.yyw.abc.ganhuo.Type;

import java.util.List;

/**
 * Created by abc on 2016/6/21.
 */
public interface OnLoadTypeListener {
    void onSuccess(List<Type> list);
    void onError();
}
