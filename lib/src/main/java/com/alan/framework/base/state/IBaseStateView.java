package com.alan.framework.base.state;

import android.view.View;

import com.alan.framework.view.loading.LoadingDialog;

/**
 * @author Alan
 * 时 间：2019-11-21
 * 简 述：<功能简述>
 */
public interface IBaseStateView {

    void showLoadingState();

    void showLoadingState(String text);

    void showFailureState(String text, boolean isRetry);

    void showSuccessState();

    void showLoadingDialog(String dialog);

    void dismissLoadingDialog(boolean isSuccess);

    void dismissImmediately();

    void dismissLoadingDialog(boolean isSuccess, String text, LoadingDialog.OnDialogDismissListener onDialogDismissListener);

    void showToast(String text);

    void setRetryListener(View.OnClickListener onClickListener);
}
