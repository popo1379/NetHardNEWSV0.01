package com.palmintelligence.administrator.nethardnewsv001.mvp.view;

import java.util.List;

/**
 * Created by Administrator on 2017/2/10 0010.
 */
public interface BaseView<T> {




    void setData(List<T> datas);

    void netWorkError();

    void hideProgress();

    void showProgress();

    void showFoot();

    void hideFoot();




}