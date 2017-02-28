package com.palmintelligence.administrator.nethardnewsv001.mvp.presenter;

import com.palmintelligence.administrator.nethardnewsv001.MainActivity;
import com.palmintelligence.administrator.nethardnewsv001.NewshowActivity;
import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.BeanDate;
import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.NewsBean;
import com.palmintelligence.administrator.nethardnewsv001.mvp.model.BaseModel;
import com.palmintelligence.administrator.nethardnewsv001.mvp.model.NewsData;
import com.palmintelligence.administrator.nethardnewsv001.mvp.model.NewsListModelImpl;
import com.palmintelligence.administrator.nethardnewsv001.mvp.view.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/13 0013.
 */
public class NewsListPresenter extends BasePresenter<BaseView> implements BeanDate<NewsBean>,NewsData{


    private final BaseModel.NewsListModel newsListModel;


public NewsListPresenter(BaseView mView){
    attach(mView);
    this.newsListModel = new NewsListModelImpl();
}

public void requestNetWork(int id, int page, boolean isNull) {
    if (page == 1) {
        mView.showProgress();
    } else {
        if (!isNull) {
            mView.showFoot();
        }
    }
    newsListModel.netWorkNewList(id, page, this);
}




    @Override
    public void addData(List<NewsBean> datas){

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


    public void onClick(NewsBean info) {
        NewshowActivity.startIntent(info.getFromurl());
    }



}
