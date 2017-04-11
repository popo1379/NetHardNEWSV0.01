package com.palmintelligence.administrator.nethardnewsv001.mvp.presenter;

import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.NewsBean;

/**
 * Created by Administrator on 2017/2/10 0010.
 */
public  class BasePresenter<T> {
    public T mView;

    public void attach(T mView){
        this.mView = mView;
    }

    public void dettach(){
        mView = null;
    }

}