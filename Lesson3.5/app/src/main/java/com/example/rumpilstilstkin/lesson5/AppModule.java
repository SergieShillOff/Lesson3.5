package com.example.rumpilstilstkin.lesson5;

import android.content.Context;
import android.net.ConnectivityManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    private Context app;

    AppModule(Context app){
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideAppContext(){
        return app;
    }

    @Provides
    Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(getUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    Endpoints getUserEndpoints(Retrofit retrofit){
        return retrofit.create(Endpoints.class);
    }

    @Provides
    ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) app.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    private String getUrl(){
        ///мега сложная работа
        return "https://api.github.com/";
    }
}
