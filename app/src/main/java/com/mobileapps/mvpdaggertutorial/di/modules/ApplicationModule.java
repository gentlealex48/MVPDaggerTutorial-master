package com.mobileapps.mvpdaggertutorial.di.modules;

import android.app.Application;

import com.mobileapps.mvpdaggertutorial.di.InitApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private InitApplication initApplication;

    public ApplicationModule(InitApplication initApplication) {
        this.initApplication = initApplication;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return initApplication;
    }
}
