package com.yyw.abc.ganhuo.ui.view;

import com.yyw.abc.ganhuo.Type;

import java.util.List;

/**
 * Created by abc on 2016/6/20.
 */
public interface IShowSelect {
    void setType(List<Type> list);
    void showLoad();
    void hideLoad();
    void showError();
}
