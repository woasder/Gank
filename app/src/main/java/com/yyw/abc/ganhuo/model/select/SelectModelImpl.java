package com.yyw.abc.ganhuo.model.select;

import android.util.Log;

import com.yyw.abc.ganhuo.Type;
import com.yyw.abc.ganhuo.TypeDao;
import com.yyw.abc.ganhuo.presenter.select.LoadType;
import com.yyw.abc.ganhuo.presenter.select.SaveTYpe;
import com.yyw.abc.ganhuo.presenter.select.SelectPresenter;
import com.yyw.abc.ganhuo.utils.GanhuoApplication;

import java.util.List;

import de.greenrobot.dao.query.Query;

/**
 * Created by abc on 2016/6/19.
 */
public class SelectModelImpl implements SelectModel{

    private TypeDao typeDao = GanhuoApplication.getDaoSession().getTypeDao();
    @Override
    public void loadType(LoadType loadType) {
        Log.d("select","model load");
      //  List<Type> list = typeDao.loadAll();//issue 可以修改list里的type 同时数据库里同时修改

        List<Type> list = typeDao.loadAll();

        loadType.loadSuccess(list);

    }

    @Override
    public void saveType(List<Type> list, SaveTYpe.saveType saveType) {
        Log.d("select","model save");
        typeDao.deleteAll();
        for (int i = 0;i<list.size();i++){
            typeDao.insert(list.get(i));
        }

    }
}
