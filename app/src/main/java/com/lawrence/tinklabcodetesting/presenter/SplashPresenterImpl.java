package com.lawrence.tinklabcodetesting.presenter;

import android.os.CountDownTimer;
import android.util.Log;

import com.lawrence.tinklabcodetesting.presenter.view.ISplashView;

import org.androidannotations.annotations.EBean;

/**
 * Created by Kit on 19/6/2017.
 */

@EBean
public class SplashPresenterImpl extends BasePresenter implements SplashPresenter {

    private long splashTime = 3500;

    @Override
    public void init() {
        new CountDownTimer(splashTime, 100) {

            public void onTick(long millisUntilFinished) {
                int progress = (int) (((splashTime - millisUntilFinished) / (double) splashTime) * 100);
                ((ISplashView) view).updateStatus(progress);
            }

            public void onFinish() {
                ((ISplashView) view).updateStatus(100);
                ((ISplashView) view).goToMainPage();
            }
        }.start();
    }
}
