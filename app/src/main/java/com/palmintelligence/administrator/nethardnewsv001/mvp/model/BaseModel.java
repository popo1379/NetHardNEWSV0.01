package com.palmintelligence.administrator.nethardnewsv001.mvp.model;

/**
 * Created by Administrator on 2017/2/10 0010.
 */
public interface BaseModel<T> {


  //  void netWork(T model);



    interface NewsListModel {
        void netWorkNewList(int id, int page, NewsData newsData);
    }


    interface GamesListModel{
      void netWorkGamesList(String type ,final GamesData gameData);
    }




}
