package com.palmintelligence.administrator.nethardnewsv001.mvp.model;

import android.util.Log;


import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.BaseBean;
import com.palmintelligence.administrator.nethardnewsv001.network.NetWorkRequest;
import com.palmintelligence.administrator.nethardnewsv001.util.MySubscriber;

import rx.Subscriber;

/**
 * by 12406 on 2016/5/15.
 */
public class NewsListModelImpl implements BaseModel.NewsListModel {


    @Override
    public void netWorkNewList(int id, int page, final NewsData newsData) {

        NetWorkRequest.newsList(id, page, new MySubscriber<BaseBean.NewsListBean>(){

            @Override
            public void onCompleted() {
                Log.i(" NewsListModelImpl", " NewsListModelImpl的onCompleted被调用了");
            }
            @Override
            public void onError(Throwable e) {
                newsData.error();
            }

            @SuppressWarnings("unchecked")
            @Override
            public void onNext(BaseBean.NewsListBean newsListBean) {
                newsData.addData(newsListBean.getInfo());
            }
        });
    }


}
