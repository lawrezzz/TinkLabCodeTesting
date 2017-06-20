package com.lawrence.tinklabcodetesting.ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lawrence.tinklabcodetesting.R;
import com.lawrence.tinklabcodetesting.presenter.SplashPresenter;
import com.lawrence.tinklabcodetesting.presenter.SplashPresenterImpl_;
import com.lawrence.tinklabcodetesting.presenter.view.ISplashView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;


@EActivity(R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashView {

    SplashPresenter splashPresenter;

    @SystemService
    ConnectivityManager connectivityManager;

    @ViewById(R.id.tv_progress_text)
    TextView ProgressStringTextView;

    @ViewById(R.id.tv_progress)
    TextView ProgressTextView;

    @StringRes(R.string.warning_network)
    String noNetworkString;

    @StringRes(R.string.global_okay)
    String okayString;

    @AfterViews
    void init() {
        if (isNetworkConnected()) {
            initPresenter();
            splashPresenter.init();
        }
    }

    protected void initPresenter() {
        splashPresenter = SplashPresenterImpl_.getInstance_(this);
        splashPresenter.setView(this);
    }

    private boolean isNetworkConnected() {

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        /// if no network is available networkInfo will be null
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(noNetworkString);
        builder.setCancelable(false);
        builder.setPositiveButton(okayString, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });
        builder.show();
        return false;
    }

    @Override
    public void updateStatus(int percentage) {
        ProgressStringTextView.setVisibility(View.VISIBLE);
        ProgressTextView.setText(Integer.toString(percentage));
    }

    @Override
    public void goToMainPage() {
        MainActivity_.intent(this).start();
        finish();
    }

}