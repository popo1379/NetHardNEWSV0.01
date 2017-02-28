package com.palmintelligence.administrator.nethardnewsv001.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.palmintelligence.administrator.nethardnewsv001.R;

/**
 * Created by Administrator on 2017/2/18 0018.
 */
public class GlideUtils {

public static void glide(String url, ImageView imageView, Context context){
    Glide.with(context)
            .load(url)
            .placeholder(R.drawable.newspic_emptyuri)
            .error(R.drawable.newspic_fail).crossFade()
            .into(imageView);

}

}
