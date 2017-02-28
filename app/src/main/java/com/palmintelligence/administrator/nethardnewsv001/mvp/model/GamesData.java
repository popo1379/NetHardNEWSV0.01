package com.palmintelligence.administrator.nethardnewsv001.mvp.model;

import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.GamesBean;
import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.NewsBean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/21 0021.
 */
public interface GamesData {
    void addData(List<GamesBean> datas);

    void error();

}
