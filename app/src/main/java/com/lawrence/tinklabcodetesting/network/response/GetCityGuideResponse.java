package com.lawrence.tinklabcodetesting.network.response;

import com.lawrence.tinklabcodetesting.model.bean.CityGuideList;
import com.lawrence.tinklabcodetesting.model.bean.Result;

import java.io.Serializable;

/**
 * Created by Kit on 19/6/2017.
 */

public class GetCityGuideResponse extends BaseResponse {

    CityGuideList data;

    public CityGuideList getData() {
        return data;
    }

    public void setResult(Result result) {
        this.data = data;
    }

}
