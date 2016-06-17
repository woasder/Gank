package com.yyw.abc.ganhuo.utils;

import android.content.Context;

import okhttp3.OkHttpClient;

/**
 * Created by abc on 2016/5/28.
 */
public class OkHttpUtile {
    private static final String TAg = "OKHTTP";
    private static volatile OkHttpClient defaultOkHttpClient;

    public static OkHttpClient getInstance(){
        OkHttpClient okHttpClient = defaultOkHttpClient;
        if (okHttpClient == null){
            synchronized (OkHttpUtile.class){
                okHttpClient = defaultOkHttpClient;
                if (okHttpClient == null){
                    okHttpClient = new OkHttpClient();
                    defaultOkHttpClient = okHttpClient;
                }
            }
        }
        return okHttpClient;
    }
}
