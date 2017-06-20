package com.lawrence.tinklabcodetesting.ui.activity;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.lawrence.tinklabcodetesting.R;

import com.lawrence.tinklabcodetesting.view.adapter.MainPagerAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Kit on 19/6/2017.
 */

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    MainPagerAdapter mainPagerAdapter;

    @ViewById(R.id.viewpager)
    ViewPager mainViewPager;

    @ViewById(R.id.main_tablayout)
    TabLayout mainTabLayout;

    @AfterViews
    void init() {
        initPresenter();
        initAdapter();
    }

    protected void initPresenter() {
//        splashPresenter = SplashPresenterImpl_.getInstance_(this);
//        splashPresenter.setView(this);
    }

    protected void initAdapter() {
        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), this);

        // Config Pages behavior
        mainViewPager.setAdapter(mainPagerAdapter);
        mainViewPager.setOffscreenPageLimit(mainPagerAdapter.getCount());
        mainTabLayout.setupWithViewPager(mainViewPager);
    }

}