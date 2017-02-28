package com.palmintelligence.administrator.nethardnewsv001.network;


import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.JUHEBean;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/2/23 0023.
 */
public interface JUHEAPI {

    @GET(Api.JUHE_NEWS)
    Observable<JUHEBean> getGamesList(@Query("type") String type, @Query("key")String key);
}
