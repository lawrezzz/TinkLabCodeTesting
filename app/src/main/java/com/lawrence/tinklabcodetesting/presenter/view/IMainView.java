package com.lawrence.tinklabcodetesting.presenter.view;

import com.lawrence.tinklabcodetesting.model.bean.CityGuide;
import com.lawrence.tinklabcodetesting.model.bean.CityGuideList;

import java.util.List;

/**
 * Created by eason on 29/11/2016.
 */

public interface IMainView extends IView {

    void updateCityGuideList(List<CityGuide> cityGuideList);

}

