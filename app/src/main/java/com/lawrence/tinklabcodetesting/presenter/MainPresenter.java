package com.lawrence.tinklabcodetesting.presenter;

import com.lawrence.tinklabcodetesting.presenter.view.IView;

/**
 * Created by Kit on 19/6/2017.
 */

public interface MainPresenter {

    void setView(IView view);

    void getCityGuideList();

}
