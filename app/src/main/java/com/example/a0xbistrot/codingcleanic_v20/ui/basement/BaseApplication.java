package com.example.a0xbistrot.codingcleanic_v20.ui.basement;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class BaseApplication extends Application {

    private static BaseApplication baseApplication;

    public static BaseApplication getInstance(){
        return baseApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        Stetho.initializeWithDefaults(this); // Stetho : Facebook에서 만듦.
    }
}
