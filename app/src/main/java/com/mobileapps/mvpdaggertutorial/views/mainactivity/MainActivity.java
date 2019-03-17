package com.mobileapps.mvpdaggertutorial.views.mainactivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mobileapps.mvpdaggertutorial.R;
import com.mobileapps.mvpdaggertutorial.di.InitApplication;
import com.mobileapps.mvpdaggertutorial.di.components.DaggerActivityComponent;
import com.mobileapps.mvpdaggertutorial.di.modules.MVPModule;
import com.mobileapps.mvpdaggertutorial.mvp.BaseContract;

import javax.inject.Inject;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements BaseContract.ViewCallBack {

    @Inject
    BaseContract.PresenterCallBack presenterCallBack;

    @Inject
    Context mContext;

    private TextView textView;
    private ProgressBar progressBar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerActivityComponent.builder()
                .appComponent(InitApplication.get(this.getApplicationContext()).component())
                .mVPModule(new MVPModule(this))
                .build()
                .inject(this);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterCallBack.onButtonClick();
            }
        });
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setQuote(String string) {
        textView.setText(string);
        Toast.makeText(mContext, "Quote Updated", Toast.LENGTH_SHORT).show();    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterCallBack.onDestroy();
    }
}
