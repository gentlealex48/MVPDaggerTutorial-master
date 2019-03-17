package com.mobileapps.mvpdaggertutorial.mvp;

import com.mobileapps.mvpdaggertutorial.models.Model;

public class BasePresenter implements BaseContract.PresenterCallBack, BaseContract.ModelCallBack.OnFinishedListener {
    private BaseContract.ViewCallBack mainView;
    private Model model;

    public BasePresenter(BaseContract.ViewCallBack mainView, Model model) {
        this.mainView = mainView;
        this.model = model;
    }

    @Override
    public void onFinished(String string) {
        if (mainView != null) {
            mainView.setQuote(string);
            mainView.hideProgress();
        }
    }

    @Override
    public void onButtonClick() {
        if (mainView != null) {
            mainView.showProgress();
        }
        model.getNextQuote(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }
}
