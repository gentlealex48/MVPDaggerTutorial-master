package com.mobileapps.mvpdaggertutorial.di.modules;

import com.mobileapps.mvpdaggertutorial.models.Model;
import com.mobileapps.mvpdaggertutorial.mvp.BaseContract;
import com.mobileapps.mvpdaggertutorial.mvp.BasePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MVPModule {
    private BaseContract.ViewCallBack viewCallBack;

    public MVPModule(BaseContract.ViewCallBack viewCallBack) {
        this.viewCallBack = viewCallBack;
    }

    @Provides
    public BaseContract.ViewCallBack provideView() {
        return viewCallBack;
    }

    @Provides
    public BaseContract.PresenterCallBack providePresenter(BaseContract.ViewCallBack view, Model model) {
        return new BasePresenter(view, model);
    }
}
