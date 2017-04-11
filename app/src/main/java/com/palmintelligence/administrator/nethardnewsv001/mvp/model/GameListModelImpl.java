package com.palmintelligence.administrator.nethardnewsv001.mvp.model;

import android.util.Log;

import com.chad.library.adapter.base.BaseViewHolder;
import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.BaseBean;
import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.GamesBean;
import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.JUHEBean;

import com.palmintelligence.administrator.nethardnewsv001.network.NetWorkRequest;
import com.palmintelligence.administrator.nethardnewsv001.util.MySubscriber;

/**
 * Created by Administrator on 2017/2/21 0021.
 */
public class GameListModelImpl implements BaseModel.GamesListModel{



    public void netWorkGamesList(String type ,final GamesData gameData) {

        NetWorkRequest.gamesList(type, new MySubscriber<JUHEBean>() {

            @Override
            public void onCompleted() {
                Log.i(" GameListModelImpl", " GameListModelImpl的onCompleted被调用了");
            }

            @Override
            public void onError(Throwable e) {
                gameData.error();
            }

            @SuppressWarnings("unchecked")
            @Override
            public void onNext(JUHEBean gameNewsListBean) {
                gameData.addData(gameNewsListBean.getResult().getData());
            }
        });
    }
}
