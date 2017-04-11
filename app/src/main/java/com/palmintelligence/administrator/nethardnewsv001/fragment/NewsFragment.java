package com.palmintelligence.administrator.nethardnewsv001.fragment;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.palmintelligence.administrator.nethardnewsv001.R;
import com.palmintelligence.administrator.nethardnewsv001.adapter.BaseRecyclerViewAdapter;
import com.palmintelligence.administrator.nethardnewsv001.adapter.GamesListAdapter;

import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.GamesBean;

import com.palmintelligence.administrator.nethardnewsv001.mvp.presenter.GamesListPresenter;

import com.palmintelligence.administrator.nethardnewsv001.mvp.view.BaseView;
import com.palmintelligence.administrator.nethardnewsv001.ui.MyRecyclerView;
import com.palmintelligence.administrator.nethardnewsv001.ui.bannerViewPager.BannerViewPager;
import com.palmintelligence.administrator.nethardnewsv001.ui.bannerViewPager.OnPageClickListener;
import com.palmintelligence.administrator.nethardnewsv001.ui.bannerViewPager.ViewPagerAdapter;

import com.palmintelligence.administrator.nethardnewsv001.util.UIcollector;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/13 0013.
 */
public class NewsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, MyRecyclerView.LoadingData, BaseRecyclerViewAdapter.OnItemClickListener<GamesBean>,
        BaseView<GamesBean>{

    private SwipeRefreshLayout srfLayout;
    private MyRecyclerView recyclerView;
    private GamesListAdapter gamesListAdapter;
    private boolean isPrepared;
    private boolean isLoad;
    private GamesListPresenter gamesListPresenter;
    private String type = "top";
    private BannerViewPager  bannerViewPager;
    private ImageView iv1,iv2,iv3,iv4,iv5;

    @Override
    protected View initView() {

        if (view == null) {
            view = View.inflate(UIcollector.getActivity(), R.layout.fragment_news, null);
            recyclerView = (MyRecyclerView) view.findViewById(R.id.news_recyclerview);
            srfLayout = (SwipeRefreshLayout) view.findViewById(R.id.srf_layout);

            isPrepared = true;
             bannerViewPager = (BannerViewPager)view.findViewById(R.id.banner);
            iv1 = (ImageView) LayoutInflater.from(UIcollector.getActivity()).inflate(R.layout.banner_item,bannerViewPager,false);
            iv2 = (ImageView) LayoutInflater.from(UIcollector.getActivity()).inflate(R.layout.banner_item,bannerViewPager,false);
            iv3 = (ImageView) LayoutInflater.from(UIcollector.getActivity()).inflate(R.layout.banner_item,bannerViewPager,false);
            iv4 = (ImageView) LayoutInflater.from(UIcollector.getActivity()).inflate(R.layout.banner_item,bannerViewPager,false);
            iv5 = (ImageView) LayoutInflater.from(UIcollector.getActivity()).inflate(R.layout.banner_item,bannerViewPager,false);
        }

        return view;

    }

    @Override
    protected void initData() {


        if (!isPrepared || !isVisible || isLoad) {
            return;
        }
        LinkedList<GamesBean> list = new LinkedList<>();

        gamesListAdapter = new GamesListAdapter(list);

        gamesListAdapter.setOnItemClickListener(this);

        gamesListPresenter= new GamesListPresenter(this);

        srfLayout.setOnRefreshListener(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingData(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(gamesListAdapter);

        iv1.setImageResource(R.drawable.main_viewpager_pic1);
        iv2.setImageResource(R.drawable.main_viewpager_pic2);
        iv3.setImageResource(R.drawable.main_viewpager_pic3);
        iv4.setImageResource(R.drawable.main_viewpager_pic4);


        final List<ImageView> mViews = new ArrayList<>();
        mViews.add(iv1);
        mViews.add(iv2);
        mViews.add(iv3);
        mViews.add(iv4);
        mViews.add(iv5);

        //实例化ViewPagerAdapter，第一个参数是View集合，第二个参数是页面点击监听器
        ViewPagerAdapter mAdapter = new ViewPagerAdapter(mViews, new OnPageClickListener(){
            @Override
            public void onPageClick(View view, int position) {
                Log.d("cylog","position:"+position);
            }
        });
//设置适配器
        bannerViewPager.setAdapter(mAdapter);



        srfLayout.post(new Runnable() {
            @Override
            public void run() {
                onRefresh();
            }
        });
        isLoad = true;

    }

    @Override
    public void setData(List<GamesBean>datas) {
        if (datas.isEmpty()) {
            isNull = true;
        } else {
            gamesListAdapter.addAll(datas);
        }
    }

    @Override
    public void onRefresh() {
        gamesListAdapter.removeAll();
        gamesListPresenter.requestNetWork(type,isNull);

    }

    @Override
    public void onLoadMore() {
        gamesListAdapter.removeAll();
        gamesListPresenter.requestNetWork(type,isNull);
    }


        @Override
        public void netWorkError() {
            Toast(UIcollector.getString(R.string.network_error));
        }

 //刷新开关：开
    @Override
    public void showProgress() {
        if (!srfLayout.isRefreshing()) {
            srfLayout.setRefreshing(true);
        }
    }

//刷新开关：关
    @Override
    public void hideProgress() {
        if (srfLayout.isRefreshing()) {
            srfLayout.setRefreshing(false);
        }
    }

    @Override
        public void showFoot() {
        gamesListAdapter.isShowFooter(true);
    }

    @Override
        public void hideFoot() {
        gamesListAdapter.isShowFooter(false);
        }

    @Override
    public void onItemClick(View view, int position, GamesBean info) {
        gamesListPresenter.onClick(info);
        Log.i("NewsFragment","onItemClick被调用了");
    }
    }







