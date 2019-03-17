package com.mobileapps.mvpdaggertutorial.di.components;

import android.app.Application;
import android.content.Context;

import com.mobileapps.mvpdaggertutorial.di.InitApplication;
import com.mobileapps.mvpdaggertutorial.di.modules.ApplicationModule;
import com.mobileapps.mvpdaggertutorial.di.modules.ContextModule;
import com.mobileapps.mvpdaggertutorial.di.modules.DataModule;
import com.mobileapps.mvpdaggertutorial.models.Model;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, DataModule.class, ContextModule.class})
public interface AppComponent {
    void inject(InitApplication initApplication);

    Context getContext();

    Model getFindItemsInteractor();

    Application getApplication();
}
