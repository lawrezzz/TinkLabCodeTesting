package com.lawrence.tinklabcodetesting.presenter.interactor;

import android.support.annotation.NonNull;

import com.lawrence.tinklabcodetesting.network.api.ApiResponseListener;

/**
 * Created by Kit on 19/6/2017.
 */

public interface MainInteractor {

    void getCityGuideList(@NonNull ApiResponseListener listener);

}
