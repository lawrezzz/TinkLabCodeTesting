package com.lawrence.tinklabcodetesting.ui.Fragment;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.lawrence.tinklabcodetesting.R;
import com.lawrence.tinklabcodetesting.model.bean.CityGuide;
import com.lawrence.tinklabcodetesting.model.bean.CityGuideList;
import com.lawrence.tinklabcodetesting.presenter.MainPresenter;
import com.lawrence.tinklabcodetesting.presenter.MainPresenterImpl;
import com.lawrence.tinklabcodetesting.presenter.view.IMainView;
import com.lawrence.tinklabcodetesting.view.adapter.CityGuideAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kit on 19/6/2017.
 */

@EFragment(R.layout.fragment_city_guide)
public class CityGuideFragment extends BaseFragment implements IMainView {

    @SystemService
    ConnectivityManager connectivityManager;

    @ViewById(R.id.srv_city_guide)
    SwipeRefreshLayout swipeRefreshLayout;

    @ViewById(R.id.rv_city_guide)
    RecyclerView recyclerView;

    @StringRes(R.string.warning_network)
    String noNetworkString;

    @Bean
    CityGuideAdapter adapter;

    @Bean(MainPresenterImpl.class)
    MainPresenter mainPresenter;

    private List<CityGuide> cityGuideList = new ArrayList<CityGuide>();
    private boolean isRefresh = false;
    private boolean isLoading = false;
    private Toast noNetworkToast;

    @AfterViews
    public void init() {
        initPresenter();
        initAdapter();
        getCityGuideList();
        initRefreshView();
    }

    @UiThread
    @Override
    public void updateCityGuideList(List<CityGuide> cityGuideList) {
        if (isRefresh) {
            this.cityGuideList = cityGuideList;
            swipeRefreshLayout.setRefreshing(false);
        } else {
            this.cityGuideList.addAll(cityGuideList);
        }
        adapter.setItems(this.cityGuideList);
        adapter.notifyDataSetChanged();
        isLoading = false;
    }

    private void getCityGuideList() {
        isLoading = true;
        mainPresenter.getCityGuideList();
    }

    private void initRefreshView() {
        swipeRefreshLayout.setColorSchemeResources(R.color.dark_gray);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (isNetworkConnected()) {
                    isRefresh = true;
                    getCityGuideList();
                } else {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });
    }

    private void initPresenter() {
        mainPresenter.setView(this);
    }

    private void initAdapter() {
        final int visibleThreshold = 1;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int totalItemCount = linearLayoutManager.getItemCount();
                int lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold) && isNetworkConnected()) {
                    getCityGuideList();
                }
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private boolean isNetworkConnected() {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        if (noNetworkToast != null) {
            noNetworkToast.cancel();
        }
        noNetworkToast = Toast.makeText(getContext(), noNetworkString, Toast.LENGTH_SHORT);
        noNetworkToast.show();

        return false;
    }

}
