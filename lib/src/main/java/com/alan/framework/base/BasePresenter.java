package com.alan.framework.base;


import android.content.Context;

import com.alan.framework.base.state.IBaseStateView;
import com.alan.framework.base.state.StateHelper;

/**
 * @author Alan
 * 时 间：2020-01-17
 * 简 述：<功能简述>
 */
public class BasePresenter {

    private IBaseStateView iBaseStateView;
    private Context context;

    public BasePresenter(Context context, IBaseStateView iBaseStateView) {
        this.iBaseStateView = iBaseStateView;
        this.context = context;
    }

    public void showToast(String text) {
        this.iBaseStateView.showToast(text);
    }

    public void showSuccess() {
        this.iBaseStateView.showSuccessState();
    }

    public void showFailure(String text, boolean isRetry) {
        this.iBaseStateView.showFailureState(text, isRetry);
    }

    public void showFailure() {
        this.iBaseStateView.showFailureState(StateHelper.DEFAULT_LOADING_FAILURE_TEXT, true);
    }

    public void showLoadingState(String text) {
        this.iBaseStateView.showLoadingState(text);
    }

    public void showLoadingState() {
        showLoadingState(StateHelper.DEFAULT_LOADING_TEXT);
    }

    public void showLoadingDialog(String text) {
        this.iBaseStateView.showLoadingDialog(text);
    }

    public void showLoadingDialog() {
        showLoadingDialog(StateHelper.DEFAULT_LOADING_TEXT);
    }

}
