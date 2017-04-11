package com.palmintelligence.administrator.nethardnewsv001.mvp.presenter;

import android.content.Intent;
import android.util.Log;

import com.palmintelligence.administrator.nethardnewsv001.NewshowActivity;
import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.BeanDate;
import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.GamesBean;
import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.NewsBean;
import com.palmintelligence.administrator.nethardnewsv001.mvp.model.BaseModel;
import com.palmintelligence.administrator.nethardnewsv001.mvp.model.GameListModelImpl;
import com.palmintelligence.administrator.nethardnewsv001.mvp.model.GamesData;

import com.palmintelligence.administrator.nethardnewsv001.mvp.view.BaseView;
import com.palmintelligence.administrator.nethardnewsv001.util.LogUtils;
import com.palmintelligence.administrator.nethardnewsv001.util.UIcollector;

import java.util.List;

/**
 * Created by Administrator on 2017/2/21 0021.
 */
public class GamesListPresenter extends BasePresenter<BaseView> implements BeanDate<GamesBean>,GamesData {

    private final BaseModel.GamesListModel gamesListModel;


    public GamesListPresenter(BaseView mView){
        attach(mView);
        this.gamesListModel = new GameListModelImpl();
    }

    public void requestNetWork(String type, boolean isNull) {

        LogUtils.i("GamesListPresenter","GamesListPresenter的requestNetWork被调用了");


            if (!isNull) {
                mView.showFoot();
            }

        gamesListModel.netWorkGamesList(type, this);
    }

    public void addData(List<GamesBean> datas){

        mView.setData(datas);
        mView.hideFoot();
        mView.hideProgress();

    }

    @Override
    public void error(){

        mView.hideFoot();
        mView.hideProgress();
        mView.netWorkError();

    }

    public void onClick(GamesBean info) {
            NewshowActivity.startIntent(info.getUrl());
        Log.i("onClick",info.getTitle()+"into webview"+info.getUrl());
    }
}
