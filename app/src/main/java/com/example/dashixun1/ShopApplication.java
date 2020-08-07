package com.example.dashixun1;

import android.app.Application;

import com.example.httplibrary1.HttpConstant;
import com.example.httplibrary1.HttpGlobalConfig;
//import com.squareup.leakcanary.LeakCanary;

import com.tencent.bugly.crashreport.CrashReport;

public class ShopApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
      /*  HttpGlobalConfig.getInstance()
                .setBaseurl("https://www.wanandroid.com/")
                .setTimeout(HttpConstant.TIME_OUT)
                .setShowLog(true)
                .setTimeUnit(HttpConstant.TIME_UNIT)
                .initReady(this);*/
      HttpGlobalConfig.getInstance()
              .setBaseurl("http://api.ergedd.com/")
              .setTimeout(HttpConstant.TIME_OUT)
             .setShowLog(true)
              .setTimeUnit(HttpConstant.TIME_UNIT)
              .initReady(this);

        CrashReport.initCrashReport(getApplicationContext(), "ef93bab6b8", true);
       // CrashReport.initCrashReport(getApplicationContext());

        CrashReport.testJavaCrash();

    }
}
