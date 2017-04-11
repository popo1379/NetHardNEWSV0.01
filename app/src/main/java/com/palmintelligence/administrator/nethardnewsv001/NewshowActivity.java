package com.palmintelligence.administrator.nethardnewsv001;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.palmintelligence.administrator.nethardnewsv001.util.LogUtils;
import com.palmintelligence.administrator.nethardnewsv001.util.UIcollector;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/2/20 0020.
 */
public class NewshowActivity extends BaseActivity{

    @Bind(R.id.news_webview)
    WebView webView;

    private String TAG="NewshowActivity";
    private String url ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getBundle();

        webView.getSettings().setJavaScriptEnabled(true);
            //防止转跳新网页打开浏览器
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

    }


    private void getBundle() {

        Bundle bundle = getIntent().getExtras();
        if (null != bundle && !bundle.isEmpty()) {
            url = bundle.getString("url");
            LogUtils.d(TAG,"浏览器接收url："+url);
        }

    }

        @Override
        protected int getLayoutId() {
            return R.layout.activity_newshow;
        }


    public static void startIntent(String url) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        Intent intent=new Intent(UIcollector.getContext(),NewshowActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtras(bundle);
        UIcollector.getContext().startActivity(intent);
    }

    }

















