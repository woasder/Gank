package com.yyw.abc.ganhuo.model.domain;

import com.yyw.abc.ganhuo.Type;
import com.yyw.abc.ganhuo.TypeDao;
import com.yyw.abc.ganhuo.presenter.domain.OnLoadTypeListener;
import com.yyw.abc.ganhuo.utils.GanhuoApplication;

import java.util.List;

/**
 * Created by abc on 2016/6/21.
 */
public class DomainModelImpl implements DomianModel{
    TypeDao typeDao = GanhuoApplication.getDaoSession().getTypeDao();

    @Override
    public void loadType(OnLoadTypeListener onLoadTypeListener) {
        List<Type> list = typeDao.loadAll();
        onLoadTypeListener.onSuccess(list);
    }

}
