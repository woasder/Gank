package com.yyw.abc.ganhuo.presenter.select;

import com.yyw.abc.ganhuo.Type;

import java.util.List;

/**
 * Created by abc on 2016/6/19.
 */
public interface SelectPresenter {
    void loadType();
    void saveType(List<Type> list);
}
