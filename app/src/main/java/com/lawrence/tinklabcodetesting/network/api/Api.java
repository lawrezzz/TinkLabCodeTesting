package com.lawrence.tinklabcodetesting.network.api;

import com.lawrence.tinklabcodetesting.network.response.GetCityGuideResponse;

import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Rest;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

/**
 * Created by Kit on 19/6/2017.
 */


@Rest(converters = {FormHttpMessageConverter.class, GsonHttpMessageConverter.class})
public interface Api {

    @Get("https://api.myjson.com/bins/dwcgn")
    GetCityGuideResponse getCityGuide();

}
