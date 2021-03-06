package com.alan.framework.base.fragment;

import android.view.View;
import android.view.ViewGroup;

import com.alan.framework.base.state.IBaseStateView;
import com.alan.framework.base.state.IStateConfig;
import com.alan.framework.base.state.StateHelper;
import com.alan.framework.view.loading.LoadingDialog;


/**
 * @author Alan
 * 时 间：2020-01-17
 * 简 述：<功能简述>
 */
public abstract class BaseStateFragment extends BaseFragment implements IStateConfig, IBaseStateView, LoadingDialog.OnDialogDismissListener {

    protected StateHelper stateHelper;

    @Override
    protected void initView() {
        stateHelper = new StateHelper(getActivity(), (ViewGroup) mRoot, this);
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

    @Override
    public void showLoadingState(String text) {
        stateHelper.showLoadingState(text);
    }

    @Override
    public void showFailureState(String text, boolean isRetry) {
        stateHelper.showFailureState(text, isRetry);
        setRetryListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retryListener(v);
            }
        });
    }

    @Override
    public void showSuccessState() {
        stateHelper.showSuccessState();
    }

    @Override
    public void showLoadingDialog(String dialog) {
        stateHelper.showLoadingDialog(getActivity());
    }

    @Override
    public void dismissLoadingDialog(boolean isSuccess) {
        stateHelper.dismissLoadingDialog(isSuccess);
    }

    @Override
    public void dismissLoadingDialog(boolean isSuccess, String text, LoadingDialog.OnDialogDismissListener onDialogDismissListener) {
        stateHelper.dismissLoadingDialog(isSuccess, text, onDialogDismissListener);
    }

    @Override
    public void dismissImmediately() {
        stateHelper.dismissImmediately();
    }

    @Override
    public void showToast(String text) {
        stateHelper.showToast(text);
    }

    @Override
    public void onDialogDismiss() {

    }

    @Override
    public void setRetryListener(View.OnClickListener onClickListener) {
        stateHelper.setRetryListener(onClickListener);
    }

    public void retryListener(View v) {


    }
}
