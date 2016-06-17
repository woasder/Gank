package com.yyw.abc.ganhuo.retrofit;

import com.yyw.abc.ganhuo.model.entity.Gank;
import com.yyw.abc.ganhuo.model.entity.GankInfo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by abc on 2016/5/29.
 */
public interface GankService {
    /**
     * http://gank.io/api/data/数据类型/请求个数/第几页
     * http://gank.io/api/data/Android/10/1
     */
    @GET("api/data/{type}/{count}/{page}")
    Observable<GankInfo> getGank(@Path("type") String type,
                                 @Path("count") int count,
                                 @Path("page") int page);

}
