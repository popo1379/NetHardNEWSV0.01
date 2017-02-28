package com.palmintelligence.administrator.nethardnewsv001.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.palmintelligence.administrator.nethardnewsv001.R;
import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.GamesBean;
import com.palmintelligence.administrator.nethardnewsv001.mvp.bean.NewsBean;
import com.palmintelligence.administrator.nethardnewsv001.network.Api;
import com.palmintelligence.administrator.nethardnewsv001.util.GlideUtils;
import com.palmintelligence.administrator.nethardnewsv001.util.UIcollector;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/2/22 0022.
 */
public class GamesListAdapter extends BaseRecyclerViewAdapter<GamesBean> {

    public GamesListAdapter(List<GamesBean> data){
    super(data);
    }


    @Override
    protected void onBind(RecyclerView.ViewHolder holder, int position, final GamesBean data) {

        ((ViewHolder) holder).setData(data);

    }

    @Override
    protected BaseRecyclerViewHolder onCreate(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_ITEM:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item, parent, false));
            default:
                return new BaseRecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foot, parent, false));
        }
    }

    class ViewHolder extends BaseRecyclerViewHolder {

        @SuppressWarnings("unused")
        @Bind(R.id.image)
        ImageView image;
        @SuppressWarnings("unused")
        @Bind(R.id.tv_fromname)
        TextView tvFromname;
        @SuppressWarnings("unused")
        @Bind(R.id.tv_time)
        TextView tvTime;
        @SuppressWarnings("unused")
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @SuppressWarnings("unused")
        @Bind(R.id.tv_url)
        TextView tvUrl;

        public ViewHolder(View itemView) {
            super(itemView);
        }


        @Override
        protected void setData(@NonNull final GamesBean data) {
            super.setData(data);
            tvTime.setText(data.getAuthorName());
            tvTitle.setText(data.getTitle());
            tvUrl.setText(data.getUrl());
            GlideUtils.glide(data.getThumbnailPicS(),image,UIcollector.getContext());
        }
    }


}
