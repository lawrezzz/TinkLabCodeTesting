package com.lawrence.tinklabcodetesting.presenter;

import android.content.Context;

import com.lawrence.tinklabcodetesting.presenter.view.IView;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by Kit on 19/6/2017.
 */

@EBean
public abstract class BasePresenter {

    IView view;

    public void setView(IView view) {
        this.view = view;
    }

}
