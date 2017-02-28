package com.palmintelligence.administrator.nethardnewsv001.mvp.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/10 0010.
 */
public class BaseBean<T> {


    private List<T> tngou;


    public List<T> getInfo() {
        return tngou;
    }

    public void setInfo(List<T> tngou) {
        this.tngou = tngou;
    }

    public class NewsListBean extends BaseBean<NewsBean> {
    }


}
