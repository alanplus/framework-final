package com.alan.framework.base;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alan.common.ResourceUtils;
import com.alan.common.statusbar.StatusBarTools;
import com.alan.framework.R;
import com.alan.framework.base.activity.ActivityManager;
import com.alan.framework.base.state.IBaseStateView;
import com.alan.framework.base.state.IStateConfig;
import com.alan.framework.base.state.StateHelper;
import com.alan.framework.view.loading.LoadingDialog;

import org.greenrobot.eventbus.EventBus;

/**
 * @author Alan
 * 时 间：2019-11-20
 * 简 述：<功能简述>
 */
public abstract class BaseActivity extends AppCompatActivity implements IStateConfig, IBaseStateView, LoadingDialog.OnDialogDismissListener {

    protected StateHelper stateHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentId());
        registEventBus();
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        stateHelper = new StateHelper(this, viewGroup, this);
        ActivityManager.onCreate(this);
        initStatusBar();
        initView();

    }


    protected void initStatusBar() {
        int bgColor = ResourceUtils.getColorFromTheme(this, R.attr.status_bar_color, Color.WHITE);
        boolean textColorIsWhite = ResourceUtils.getBoolFromTheme(this, R.attr.status_bar_text_is_white, false);
        StatusBarTools.getStatusBarTools().setStatusBarColor(this, bgColor, textColorIsWhite);
    }

    protected abstract void initView();

    @Override
    protected void onStart() {
        super.onStart();
        ActivityManager.onStart(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityManager.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ActivityManager.onPause(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        ActivityManager.onStop(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterEventBus();
        ActivityManager.onDestroy(this);
    }

    protected abstract int getContentId();

    protected Activity getActivity() {
        return this;
    }


    @Override
    public String getLoadingSuccessText() {
        return StateHelper.DEFAULT_LOADING_SUCCESS_TEXT;
    }

    @Override
    public String getLoadingFailureText() {
        return StateHelper.DEFAULT_LOADING_FAILURE_TEXT;
    }

    @Override
    public LoadingDialog.OnDialogDismissListener getLoadingDismissLister() {
        return this;
    }

    @Override
    public void showLoadingState() {
        stateHelper.showLoadingState();
    }

    public void showLoadingDialog() {
        showLoadingDialog("正在加载");
    }

    @Override
    public void showLoadingState(String text) {
        stateHelper.showLoadingState(text);
    }

    @Override
    public void showFailureState(String text, boolean isRetry) {
        stateHelper.showFailureState(text, isRetry);
        stateHelper.setRetryListener(v -> retryOnFailure(v));
    }

    @Override
    public void setRetryListener(View.OnClickListener onClickListener) {
        stateHelper.setRetryListener(v -> retryOnFailure(v));
    }

    public void retryOnFailure(View v) {


    }

    @Override
    public void showSuccessState() {
        stateHelper.showSuccessState();
    }

    @Override
    public void showLoadingDialog(String dialog) {
        stateHelper.showLoadingDialog(this);
    }

    @Override
    public void dismissLoadingDialog(boolean isSuccess) {
        stateHelper.dismissLoadingDialog(isSuccess);
    }

    @Override
    public void dismissImmediately() {
        stateHelper.dismissImmediately();
    }

    @Override
    public void dismissLoadingDialog(boolean isSuccess, String text, LoadingDialog.OnDialogDismissListener onDialogDismissListener) {
        stateHelper.dismissLoadingDialog(isSuccess, text, onDialogDismissListener);
    }

    @Override
    public void showToast(String text) {
        stateHelper.showToast(text);
    }

    @Override
    public void onDialogDismiss() {

    }

    protected boolean configEventBus() {
        return false;
    }

    public void registEventBus() {
        if (configEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    public void unregisterEventBus() {
        if (configEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }
}
