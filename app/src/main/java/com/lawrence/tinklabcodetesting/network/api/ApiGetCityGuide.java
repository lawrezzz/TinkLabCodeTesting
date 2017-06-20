package com.lawrence.tinklabcodetesting.network.api;

import android.content.Context;
import android.support.annotation.NonNull;

import com.lawrence.tinklabcodetesting.network.response.GetCityGuideResponse;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.rest.spring.annotations.RestService;
import org.springframework.web.client.RestClientException;

/**
 * Created by Kit on 19/6/2017.
 */

@EBean
public class ApiGetCityGuide {

    @RootContext
    Context context;

    @RestService
    Api api;

    @Background
    public void getResponse(@NonNull ApiResponseListener listener) {

        try {
            GetCityGuideResponse response = api.getCityGuide();
            listener.onApiSuccess(response);
        } catch (RestClientException e) {
            //listener.onApiFailure();
        }
    }
}


