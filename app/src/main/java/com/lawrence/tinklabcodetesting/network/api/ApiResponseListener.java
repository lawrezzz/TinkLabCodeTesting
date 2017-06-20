package com.lawrence.tinklabcodetesting.network.api;

import com.lawrence.tinklabcodetesting.network.response.BaseResponse;

/**
 * Created by Kit on 19/6/2017.
 */

public interface ApiResponseListener {

    void onApiSuccess(BaseResponse baseResponse);

    void onApiFailure();

}
