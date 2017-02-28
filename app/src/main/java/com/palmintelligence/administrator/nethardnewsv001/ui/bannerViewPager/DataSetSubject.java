package com.palmintelligence.administrator.nethardnewsv001.ui.bannerViewPager;


public interface DataSetSubject {
    void registerSubscriber(DataSetSubscriber subscriber);
    void removeSubscriber(DataSetSubscriber subscriber);
    void notifySubscriber();
}
