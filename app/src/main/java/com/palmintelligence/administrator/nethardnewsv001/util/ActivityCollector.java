package com.palmintelligence.administrator.nethardnewsv001.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity管理类
 */
@SuppressWarnings("ALL")
public class ActivityCollector {


    private static final List<Activity> list = new ArrayList<>();


    public static void addActivity(Activity activity) {
        list.add(activity);
    }

    public static void removeActivity(Activity activity) {
        list.remove(activity);
    }

    public static void removeAllActivity() {

        for (Activity activity : list) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

}
