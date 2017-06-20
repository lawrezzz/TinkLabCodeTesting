package com.lawrence.tinklabcodetesting.presenter.interactor;


import android.support.annotation.NonNull;

import com.lawrence.tinklabcodetesting.network.api.ApiGetCityGuide;
import com.lawrence.tinklabcodetesting.network.api.ApiResponseListener;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;


/**
 * Created by Kit on 19/6/2017.
 */

@EBean
public class MainInteractorImpl implements MainInteractor {

    @Bean
    ApiGetCityGuide apiGetCityGuide;

    @Override
    public void getCityGuideList(@NonNull ApiResponseListener listener) {
        apiGetCityGuide.getResponse(listener);
    }

}
