package com.palmintelligence.administrator.nethardnewsv001.util;

import rx.Subscription;

/**
 * Created by Administrator on 2017/2/12 0012.
 *
 * 取消订阅
 */
public class Rxjavacollector  {



    public static Subscription subscription;

    public static void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }



}
