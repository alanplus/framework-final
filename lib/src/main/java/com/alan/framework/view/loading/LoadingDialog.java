package com.alan.framework.view.loading;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.TextView;

import com.alan.framework.R;


/**
 * 数据操作状态对话框
 * Created by Mouse on 2017/10/28.
 */

public class LoadingDialog extends Dialog implements LoadDialogView.OnFinishListener {

    private LoadDialogView mLoadView;
    private String text;
    private TextView textView;

    public LoadingDialog(@NonNull Context context) {
        super(context);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
        initView();
    }

    @Override
    public void show() {
        super.show();
        mLoadView.showLoading();
    }


    public void initView() {
        setCanceledOnTouchOutside(false);
        textView = findViewById(R.id.text);
        mLoadView = findViewById(R.id.loading_img);
        if (!TextUtils.isEmpty(text)) {
            textView.setText(text);
        }
        mLoadView.setOnFinishListener(this);
    }

    public LoadingDialog setText(String text) {
        this.text = text;
        if (null != textView) {
            textView.setText(text);
        }
        return this;
    }

    public void dismiss(String text, boolean success) {
        if (mLoadView != null && isShowing()) {
            textView.setText(text);
            if (success) {
                mLoadView.showSuccess();
            } else{
                mLoadView.showError();
            }
        }
    }

    public void dismiss(String text, boolean success, OnDialogDismissListener listener) {
        mOnDialogDismissListener = listener;
        if (mLoadView != null && isShowing()) {
            textView.setText(text);
            if (success) mLoadView.showSuccess();
            else mLoadView.showError();
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (null != mLoadView) mLoadView.destroy();
    }

    @Override
    public void viewDismiss() {
        mLoadView.postDelayed(() -> {
            textView.setText("正在加载");
            dismiss();
            if (mOnDialogDismissListener != null) mOnDialogDismissListener.onDialogDismiss();
        }, 800);
    }

    private OnDialogDismissListener mOnDialogDismissListener;

    public interface OnDialogDismissListener {
        void onDialogDismiss();
    }
}
