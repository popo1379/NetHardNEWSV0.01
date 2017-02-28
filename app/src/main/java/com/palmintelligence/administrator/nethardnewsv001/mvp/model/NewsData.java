package com.palmintelligence.administrator.nethardnewsv001.mvp.model;

import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.BaseBean;
import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.NewsBean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/12 0012.
 */
public interface NewsData {


    void addData(List<NewsBean> datas);

    void error();





}
