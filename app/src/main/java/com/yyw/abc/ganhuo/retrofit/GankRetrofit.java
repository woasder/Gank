package com.yyw.abc.ganhuo.retrofit;

import com.yyw.abc.ganhuo.model.entity.Gank;
import com.yyw.abc.ganhuo.model.entity.GankInfo;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abc on 2016/5/29.
 */
public class GankRetrofit {
    private static final String GANK_API = "http://gank.io/";
    private static  Retrofit retrofit ;
   // Retrofit retrofit =
    public static Retrofit getRetrofit(){
        if (retrofit ==null){
            synchronized (GankRetrofit.class){
                if (retrofit == null){
                    retrofit = new Retrofit.Builder()
                            .baseUrl(GANK_API)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }
}
