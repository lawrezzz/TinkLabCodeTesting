package com.lawrence.tinklabcodetesting.network.response;

import com.lawrence.tinklabcodetesting.model.bean.Result;

import java.io.Serializable;

/**
 * Created by Kit on 19/6/2017.
 */

public class BaseResponse implements Serializable {
    Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
