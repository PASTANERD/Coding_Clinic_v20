package com.example.a0xbistrot.codingcleanic_v20.ui.basement;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this); // Stetho : Facebook에서 만듦.
    }
}
