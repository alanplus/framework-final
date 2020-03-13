package com.alan.framework;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.alan.common.AndroidTools;
import com.alan.common.Logger;
import com.alan.common.exception.NeverCrash;
import com.alan.framework.base.activity.IActivityListener;
import com.alan.framework.base.state.IFailureView;
import com.alan.framework.base.state.ILoadingView;
import com.alan.framework.base.state.view.CommonFailureView;
import com.alan.framework.base.state.view.CommonLoadingView;

/**
 * @author Alan
 * 时 间：2020-03-13
 * 简 述：<功能简述>
 */
public class BaseApplication extends MultiDexApplication {

    public static BaseApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        update();
        initNeverCrash();
    }

    protected void initNeverCrash() {
        NeverCrash.init(new NeverCrash.CrashHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                onCatchException(e);
            }
        });
    }


    protected void onCatchException(Throwable e) {
        Logger.d(Log.getStackTraceString(e));

    }


    protected void update() {
        int version = getShareSystemVersion();
        int versionCode = AndroidTools.getVersionCode(this);
        if (versionCode > version) {
            onUpdate();
            updateSystemVersion(versionCode);
        }
    }

    protected void onUpdate() {


    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    public int getShareSystemVersion() {
        SharedPreferences sharedPreferences = getSharedPreferences("version_info", MODE_PRIVATE);
        return sharedPreferences.getInt("version", 0);
    }

    public void updateSystemVersion(int version) {
        SharedPreferences sharedPreferences = getSharedPreferences("version_info", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("version", version);
        edit.commit();
    }

    public IActivityListener getActivityListener() {
        return null;
    }

    /**
     * 创建loading加载状态View
     *
     * @param context
     * @return
     */
    public ILoadingView getILoadingView(Context context) {
        return new CommonLoadingView(context);
    }

    /**
     * 加载失败状态的View
     *
     * @param context
     * @return
     */
    public IFailureView getIFailureView(Context context) {
        return new CommonFailureView(context);
    }
}
