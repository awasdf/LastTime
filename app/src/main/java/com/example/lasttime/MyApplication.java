package com.example.lasttime;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

/**
 * Created by ggrc on 2017/10/27.
 * 获取上下文
 */

public class MyApplication extends Application {
    private static Context context;
    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
        context=getApplicationContext();
    }
    public static Context getContext() {
        return context;
    }
}