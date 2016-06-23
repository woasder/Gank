package com.yyw.abc.ganhuo.utils;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;

import com.yyw.abc.ganhuo.DaoMaster;
import com.yyw.abc.ganhuo.DaoSession;

/**
 * Created by abc on 2016/6/7.
 */
public class GanhuoApplication extends Application{
    private static Context context;
    public static SQLiteDatabase sqLiteDatabase;
    private static DaoSession daoSession;
    private static DaoMaster daoMaster;
    private static DaoMaster.DevOpenHelper helper;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        setupDatabase();
    }
    public static Context getContext(){
        return context;
    }

    private void setupDatabase(){
        helper = new DaoMaster.DevOpenHelper(this, "gank", null);
        sqLiteDatabase = helper.getWritableDatabase();
        daoMaster = new DaoMaster(sqLiteDatabase);
        daoSession = daoMaster.newSession();
    }

    /*public static DaoMaster getDaoMaster(){
      //  if ()
    }*/
    public static DaoSession getDaoSession(){
        /*if (daoSession == null){
            daoSession =
        }*/
        return daoSession;
    }

    public static SQLiteDatabase getSqLiteDatabase(){
        return sqLiteDatabase;
    }
}
