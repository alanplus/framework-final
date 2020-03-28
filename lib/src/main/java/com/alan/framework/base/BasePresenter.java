package com.alan.framework.base;


import android.content.Context;
import android.content.Intent;

import com.alan.framework.base.state.IBaseStateView;
import com.alan.framework.base.state.StateHelper;

/**
 * @author Alan
 * 时 间：2020-01-17
 * 简 述：<功能简述>
 */
public class BasePresenter<T extends IBaseStateView> {

    protected T mView;
    protected Context context;

    public BasePresenter(Context context, T view) {
        this.mView = view;
        this.context = context;
    }

    public void init(Intent intent) {


    }

    public void showToast(String text) {
        this.mView.showToast(text);
    }

    public void showSuccess() {
        this.mView.showSuccessState();
    }

    public void showFailure(String text, boolean isRetry) {
        this.mView.showFailureState(text, isRetry);
    }

    public void showFailure() {
        this.mView.showFailureState(StateHelper.DEFAULT_LOADING_FAILURE_TEXT, true);
    }

    public void showLoadingState(String text) {
        this.mView.showLoadingState(text);
    }

    public void showLoadingState() {
        showLoadingState(StateHelper.DEFAULT_LOADING_TEXT);
    }

    public void showLoadingDialog(String text) {
        this.mView.showLoadingDialog(text);
    }

    public void showLoadingDialog() {
        showLoadingDialog(StateHelper.DEFAULT_LOADING_TEXT);
    }

}
