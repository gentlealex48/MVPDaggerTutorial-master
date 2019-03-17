package com.mobileapps.mvpdaggertutorial.di.modules;

import com.mobileapps.mvpdaggertutorial.models.Model;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    public Model provideModelClass() {
        return new Model();
    }
}
