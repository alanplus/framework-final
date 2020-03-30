package com.alan.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.alan.framework.view.loading.LoadingDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadingDialog loadingDialog = new LoadingDialog(this);
        loadingDialog.show();

        String path = getFilesDir().getPath();
        Log.d("test_app", path);
    }
}
