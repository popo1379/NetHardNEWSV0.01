package com.palmintelligence.administrator.nethardnewsv001;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.palmintelligence.administrator.nethardnewsv001.util.ActivityCollector;
import com.palmintelligence.administrator.nethardnewsv001.util.Rxjavacollector;

import butterknife.ButterKnife;

/**
 * Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static Context context;
    private static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        activity = this;
        setContentView(getLayoutId());
        Log.i("BaseActivity", getClass().getSimpleName());
        ButterKnife.bind(this);
        ActivityCollector.addActivity(this);
    }

    void Toast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    public static Context getContext() {
        return context;
    }

    public static Activity getActivity() {
        return activity;
    }

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Rxjavacollector.unsubscribe();
    }
}
