package com.alan.framework.base.activity;

import android.app.Activity;

import com.alan.common.Logger;
import com.alan.framework.BaseApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alan
 * 时 间：2019-11-20
 * 简 述：<功能简述>
 */
public class ActivityManager {

    private static List<Activity> activityList = new ArrayList<>();


    public static void onCreate(Activity activity) {
        activityList.add(activity);
        if (BaseApplication.app.getActivityListener()!= null) {
            BaseApplication.app.getActivityListener().onCreate(activity);
        }
    }

    public static void onStart(Activity activity) {
        if (BaseApplication.app.getActivityListener() != null) {
            BaseApplication.app.getActivityListener().onStart(activity);
        }
    }

    public static void onResume(Activity activity) {
        if (BaseApplication.app.getActivityListener() != null) {
            BaseApplication.app.getActivityListener().onResume(activity);
        }
    }

    public static void onPause(Activity activity) {
        if (BaseApplication.app.getActivityListener() != null) {
            BaseApplication.app.getActivityListener().onPause(activity);
        }
    }

    public static void onStop(Activity activity) {
        if (BaseApplication.app.getActivityListener() != null) {
            BaseApplication.app.getActivityListener().onStop(activity);
        }
    }

    public static void onDestroy(Activity activity) {
        activityList.remove(activity);
        if (BaseApplication.app.getActivityListener() != null) {
            BaseApplication.app.getActivityListener().onDestroy(activity);
        }
    }

    public static void finishAll() {
        for (Activity activity : activityList) {
            try {
                activity.finish();
            } catch (Exception e) {
                Logger.error(e);
            }
        }
    }

    public static void finishOther(Class<? extends Activity>... list){
        List<Class<? extends Activity>> classes = Arrays.asList(list);
        for (Activity activity : activityList) {
            if(classes.contains(activity.getClass())){
                continue;
            }
            try {
                activity.finish();
            } catch (Exception e) {
                Logger.error(e);
            }
        }
    }

}
