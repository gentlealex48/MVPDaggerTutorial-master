package com.mobileapps.mvpdaggertutorial.di;

import android.app.Application;
import android.content.Context;

import com.mobileapps.mvpdaggertutorial.di.components.AppComponent;
import com.mobileapps.mvpdaggertutorial.di.components.DaggerAppComponent;
import com.mobileapps.mvpdaggertutorial.di.modules.ApplicationModule;
import com.mobileapps.mvpdaggertutorial.di.modules.ContextModule;
import com.mobileapps.mvpdaggertutorial.di.modules.DataModule;

public class InitApplication extends Application {
    private AppComponent component;

    public static InitApplication get(Context context) {
        return (InitApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .contextModule(new ContextModule(this))
                .dataModule(new DataModule())
                .build();
    }

    public AppComponent component() {
        return component;
    }
}
