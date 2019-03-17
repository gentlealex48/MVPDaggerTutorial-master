package com.mobileapps.mvpdaggertutorial.di.components;

import com.mobileapps.mvpdaggertutorial.di.modules.MVPModule;
import com.mobileapps.mvpdaggertutorial.di.scopes.ActivityScope;
import com.mobileapps.mvpdaggertutorial.mvp.BaseContract;
import com.mobileapps.mvpdaggertutorial.views.mainactivity.MainActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = MVPModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

    BaseContract.PresenterCallBack getMainPresenter();
}
