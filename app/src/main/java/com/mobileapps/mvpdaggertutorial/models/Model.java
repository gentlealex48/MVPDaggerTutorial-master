package com.mobileapps.mvpdaggertutorial.models;

import android.os.Handler;

import com.mobileapps.mvpdaggertutorial.mvp.BaseContract;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Model implements BaseContract.ModelCallBack{
    @Override
    public void getNextQuote(final BaseContract.ModelCallBack.OnFinishedListener onFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onFinishedListener.onFinished(getRandomQuote());
            }
        }, 1200);
    }

    private List<String> arrayList = Arrays.asList(
            "Be yourself. everyone else is already taken.",
            "A room without books is like a body without a soul.",
            "You only live once, but if you do it right, once is enough.",
            "Be the change that you wish to see in the world.",
            "If you tell the truth, you don't have to remember anything."
    );

    private String getRandomQuote() {

        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        return arrayList.get(index);
    }
}
