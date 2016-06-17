package com.yyw.abc.ganhuo.model;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;

import com.yyw.abc.ganhuo.Gank;
import com.yyw.abc.ganhuo.GankDao;
import com.yyw.abc.ganhuo.model.entity.GankInfo;
import com.yyw.abc.ganhuo.presenter.OnAddMarkListener;
import com.yyw.abc.ganhuo.presenter.OnGankListener;
import com.yyw.abc.ganhuo.retrofit.GankRetrofit;
import com.yyw.abc.ganhuo.retrofit.GankService;
import com.yyw.abc.ganhuo.utils.GanhuoApplication;
import com.yyw.abc.ganhuo.utils.OkHttpUtile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 * Created by abc on 2016/5/27.
 */
public class GankModelImpl implements GankModel{
    /**
     * http://gank.io/api/data/数据类型/请求个数/第几页
     * http://gank.io/api/data/Android/10/1
     */
    private static final String GANKURL = "http://gank.io/api/data/";
    GankDao gankDao = GanhuoApplication.getDaoSession().getGankDao();
    String orderBy = GankDao.Properties.Id.columnName;
    Cursor cursor = GanhuoApplication.getSqLiteDatabase().query(gankDao.getTablename(),gankDao.getAllColumns(),
            null,null,null,null,orderBy);
    @Override
    public void loadGank(final String type, int count, int page, final OnGankListener onGankListener) {
        URL url = null;
        try {
            url = new URL(GANKURL+"/"+type+"/"+count+"/"+page);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
       /* Request  request = new Request.Builder().url(url).build();
        OkHttpUtile.getInstance().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onGankListener.onError();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
             //   onGankListener.onSuccess();
            }
        });*/
       /* GankRetrofit.getRetrofit().create(GankService.class)
                .getGank(type,count,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onGankListener.onError();
                    }

                    @Override
                    public void onNext(GankInfo gankInfo) {
                        onGankListener.onSuccess(gankInfo);
                    }
                });*/

        GankRetrofit.getRetrofit().create(GankService.class)
                .getGank(type,count,page)
                .concatMap(new Func1<GankInfo, Observable<List<Ganhuo>>>() {
                    @Override
                    public Observable<List<Ganhuo>> call(GankInfo gankInfo) {
                        return mergeMark(gankInfo,type);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Ganhuo>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onGankListener.onError();
                    }

                    @Override
                    public void onNext(List<Ganhuo> ganhuos) {
                        onGankListener.onSuccess(ganhuos);
                    }
                });

    }

    public Observable<List<Ganhuo>> mergeMark(final GankInfo gankInfo, final String type){

        return  Observable.create(new Observable.OnSubscribe<List<Ganhuo>>() {
            @Override
            public void call(Subscriber<? super List<Ganhuo>> subscriber) {
                List<Gank> list = gankDao.loadAll();
                List<Ganhuo> ganhuos = new ArrayList<>();
                for (int i=0;i<gankInfo.getResults().size();i++){
                    Ganhuo ganhuo = new Ganhuo();
                    ganhuo.setPublishedAt(gankInfo.getResults().get(i).getPublishedAt());
                    ganhuo.setWho(gankInfo.getResults().get(i).getWho());
                    ganhuo.setDesc(gankInfo.getResults().get(i).getDesc());
                    ganhuo.setSid(gankInfo.getResults().get(i).get_id());
                    ganhuo.setType(gankInfo.getResults().get(i).getType());
                    ganhuo.setUrl(gankInfo.getResults().get(i).getUrl());
                    boolean isMarked = false;
                    for (int j = 0;j<list.size();j++){
                        Log.d("BMark","rx "+i+" "+j+type);
                        if (gankInfo.getResults().get(i).get_id().equals(list.get(j).getSid())){
                           // ganhuo.setMarked(true);
                            isMarked = true;
                            break;
                        }else {
                            isMarked = false;
                        }
                    }
                    ganhuo.setMarked(isMarked);
                    ganhuos.add(ganhuo);
                }
                subscriber.onNext(ganhuos);
                subscriber.onCompleted();
            }
        });
    }
    @Override
    public void addToMark(Gank gank, OnAddMarkListener onAddMarkListener) {
        List<Gank> list = gankDao.queryBuilder()
                .where(GankDao.Properties.Sid.eq(gank.getSid()))
                .orderAsc(GankDao.Properties.Id)
                .build().list();

        boolean flag = list.isEmpty()?false:true;

        Log.d("BMark",flag?"true ":"false "+ gank.getSid());
        if (flag){
            onAddMarkListener.onAddError();
            Log.d("BMark","add fail");
        }else {
            long id=gankDao.insert(gank);
            onAddMarkListener.onAddSuccess();
            cursor.requery();
            Log.d("BMark","add Success");
        }

    }


    @Override
    public void delFromMark(Gank gank) {
     //   GankDao gankDao = GanhuoApplication.getDaoSession().getGankDao();
        Log.d("BMark"," delFromMark");
        String sid = gank.getSid();
        List<Gank> list = gankDao.queryBuilder()
                .where(GankDao.Properties.Sid.eq(gank.getSid()))
                .list();
        if (!list.isEmpty()){
            for (int i = 0;i<list.size();i++){
                gankDao.delete(list.get(i));
            }
        }
    }


}
