package com.example.rumpilstilstkin.lesson5;


import android.app.Application;


public class MainApp extends Application {

    private static AppComponentSingleton singletonComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        singletonComponent = DaggerAppComponentSingleton
                .builder()
                .appModule(new AppModule(this))
                .build();

    }

    public static AppComponentSingleton getComponentSingleton() {
        return singletonComponent;
    }
}

