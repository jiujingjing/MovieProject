package com.u2androidproject.app;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2017/6/18.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
