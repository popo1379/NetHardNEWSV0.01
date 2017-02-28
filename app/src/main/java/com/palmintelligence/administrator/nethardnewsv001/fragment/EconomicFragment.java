package com.palmintelligence.administrator.nethardnewsv001.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import android.view.View;


import com.palmintelligence.administrator.nethardnewsv001.R;
import com.palmintelligence.administrator.nethardnewsv001.adapter.BaseRecyclerViewAdapter;
import com.palmintelligence.administrator.nethardnewsv001.adapter.GamesListAdapter;

import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.GamesBean;

import com.palmintelligence.administrator.nethardnewsv001.mvp.presenter.GamesListPresenter;

import com.palmintelligence.administrator.nethardnewsv001.mvp.view.BaseView;
import com.palmintelligence.administrator.nethardnewsv001.ui.MyRecyclerView;

import com.palmintelligence.administrator.nethardnewsv001.util.UIcollector;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/16 0016.
 */
public class EconomicFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, MyRecyclerView.LoadingData, BaseRecyclerViewAdapter.OnItemClickListener<GamesBean>,
        BaseView<GamesBean> {

    private SwipeRefreshLayout srfLayout;
    private MyRecyclerView recyclerView;
    private GamesListAdapter gamesListAdapter;
    private boolean isPrepared;
    private boolean isLoad;
    private GamesListPresenter gamesListPresenter;
    private String type = "caijing";
    @Override
    protected View initView() {
        if (view == null) {
            view = View.inflate(UIcollector.getActivity(), R.layout.fragment_game, null);
            recyclerView = (MyRecyclerView) view.findViewById(R.id.game_recyclerview);
            srfLayout = (SwipeRefreshLayout) view.findViewById(R.id.game_srf_layout);
            isPrepared = true;
        }
        return view;}

    @Override
    protected void initData() {

        if (!isPrepared || !isVisible || isLoad) {
            return;
        }
        Log.i("EconomicFragment","initData()");
        LinkedList<GamesBean> list = new LinkedList<>();

        gamesListAdapter = new GamesListAdapter(list);

        gamesListPresenter= new GamesListPresenter(this);

        srfLayout.setOnRefreshListener(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingData(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(gamesListAdapter);

        srfLayout.post(new Runnable() {
            @Override
            public void run() {
                onRefresh();
            }
        });
        isLoad = true;
    }


    @Override
    public void setData(List<GamesBean> datas) {
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
        Log.i("EconomicFragment","onItemClick被调用了");
    }

}


