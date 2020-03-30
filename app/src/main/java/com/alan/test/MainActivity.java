package com.alan.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.alan.framework.base.state.IStateConfig;
import com.alan.framework.base.state.StateHelper;
import com.alan.framework.view.loading.LoadingDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        StateHelper stateHelper = new StateHelper(this, (ViewGroup) decorView, new IStateConfig() {
            @Override
            public String getLoadingSuccessText() {
                return null;
            }

            @Override
            public String getLoadingFailureText() {
                return null;
            }

            @Override
            public LoadingDialog.OnDialogDismissListener getLoadingDismissLister() {
                return null;
            }
        });
        LoadingDialog loadingDialog = new LoadingDialog(this);
        loadingDialog.show();

        String path = getFilesDir().getPath();
        Log.d("test_app", path);
    }
}
