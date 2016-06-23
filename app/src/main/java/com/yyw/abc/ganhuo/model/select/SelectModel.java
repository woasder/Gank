package com.yyw.abc.ganhuo.model.select;

import com.yyw.abc.ganhuo.Type;
import com.yyw.abc.ganhuo.presenter.select.LoadType;
import com.yyw.abc.ganhuo.presenter.select.SaveTYpe;

import java.util.List;

/**
 * Created by abc on 2016/6/19.
 */
public interface SelectModel {
    void loadType(LoadType loadType);
    void saveType(List<Type> list, SaveTYpe.saveType saveType);
}
