package com.alan.framework.base.state;


import com.alan.framework.view.loading.LoadingDialog;

/**
 * @author Alan
 * 时 间：2019-11-21
 * 简 述：<功能简述>
 */
public interface IStateConfig {
    String getLoadingSuccessText();
    String getLoadingFailureText();
    LoadingDialog.OnDialogDismissListener getLoadingDismissLister();
}
