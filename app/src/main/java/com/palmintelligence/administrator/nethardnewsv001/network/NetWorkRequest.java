package com.palmintelligence.administrator.nethardnewsv001.network;



import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.BaseBean;
import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.JUHEBean;
import com.palmintelligence.administrator.nethardnewsv001.util.Rxjavacollector;


import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/2/10 0010.
 */
public class NetWorkRequest {

    public static void gamesList(String type,Subscriber<JUHEBean> subscriber) {
        Rxjavacollector.unsubscribe();
        Rxjavacollector.subscription = NetWork.getJUHEAPI().getGamesList(type,Api.NEWS_KEY)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}