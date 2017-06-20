package com.lawrence.tinklabcodetesting.model.bean;

import java.io.Serializable;

/**
 * Created by Kit on 20/6/2017.
 */

public class Result implements Serializable {

    private int error_code;
    private String message;

    public Result() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        if (error_code < 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getErrorCode() {
        return error_code;
    }

    public void setErrorCode(int error_code) {
        this.error_code = error_code;
    }

}
