package com.lawrence.tinklabcodetesting.presenter;

import android.os.CountDownTimer;

import com.lawrence.tinklabcodetesting.model.bean.CityGuideList;
import com.lawrence.tinklabcodetesting.network.api.ApiResponseListener;
import com.lawrence.tinklabcodetesting.network.response.BaseResponse;
import com.lawrence.tinklabcodetesting.network.response.GetCityGuideResponse;
import com.lawrence.tinklabcodetesting.presenter.interactor.MainInteractor;
import com.lawrence.tinklabcodetesting.presenter.interactor.MainInteractorImpl;
import com.lawrence.tinklabcodetesting.presenter.view.IMainView;
import com.lawrence.tinklabcodetesting.presenter.view.ISplashView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

/**
 * Created by Kit on 19/6/2017.
 */

@EBean
public class MainPresenterImpl extends BasePresenter implements MainPresenter {

    @Bean(MainInteractorImpl.class)
    MainInteractor mainInteractor;

    @Override
    public void getCityGuideList() {
        mainInteractor.getCityGuideList(new ApiResponseListener() {
            @Override
            public void onApiSuccess(BaseResponse baseResponse) {
                CityGuideList cityGuideList = ((GetCityGuideResponse) baseResponse).getData();
                ((IMainView) view).updateCityGuideList(cityGuideList.getCityGuideList());
            }

            @Override
            public void onApiFailure() {

            }
        });
    }
}
