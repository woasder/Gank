package com.yyw.abc.ganhuo.model;

import android.database.Cursor;
import android.util.Log;

import com.yyw.abc.ganhuo.Gank;
import com.yyw.abc.ganhuo.GankDao;
import com.yyw.abc.ganhuo.model.BookmarkModel;
import com.yyw.abc.ganhuo.presenter.BookmarkPresenter;
import com.yyw.abc.ganhuo.presenter.OnDeleteListener;
import com.yyw.abc.ganhuo.presenter.OnGankListener;
import com.yyw.abc.ganhuo.presenter.OnQueryListener;
import com.yyw.abc.ganhuo.utils.GanhuoApplication;

import java.util.List;

import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;

/**
 * Created by abc on 2016/6/7.
 */
public class BookmarkModelImpl implements BookmarkModel {
    GankDao gankDao = GanhuoApplication.getDaoSession().getGankDao();
    @Override
    public void quere(int count, int page, OnQueryListener queryListener) {
        Log.d("BMark","-->quere "+GankDao.Properties.Id+" "+GankDao.Properties.Id.columnName);

       // List<Gank> gankList = gankDao.loadAll();
       // gankDao.deleteAll();
        Query<Gank> query = gankDao.queryBuilder()
                .where(GankDao.Properties.Id.le(count*page))
                .orderAsc(GankDao.Properties.Id)
                .build();
        List<Gank> list = query.list();
        queryListener.onQuerySuccess(list);

    }

    @Override
    public void delete(Gank gank, OnDeleteListener onDeleteListener) {

       /* GankDao gankDao = GanhuoApplication.getDaoSession().getGankDao();
        String orderBy = GankDao.Properties.Id.columnName;
                Cursor cursor = GanhuoApplication.getSqLiteDatabase().query(gankDao.TABLENAME,gankDao.getAllColumns(),
                null,null,null,null,)*/

        /*gankDao.loadByRowId();
        gankDao.delete();*/
        gankDao.delete(gank);
        onDeleteListener.onDeleteError();

    }
}
