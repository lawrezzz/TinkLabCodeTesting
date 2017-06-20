package com.lawrence.tinklabcodetesting.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.lawrence.tinklabcodetesting.R;
import com.lawrence.tinklabcodetesting.ui.Fragment.CityGuideFragment_;

import java.lang.ref.WeakReference;

/**
 * Created by Kit on 19/6/2017.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    // Tab id
    public static final int TAB_CITY_GUIDE = 0;
    public static final int TAB_SHOP = 1;
    public static final int TAB_EAT = 2;

    private int[] tabIds = {
            TAB_CITY_GUIDE,
            TAB_SHOP,
            TAB_EAT
    };

    // Tab title
    private int[] tabTitleResIds = {
            R.string.tab_city_guide,
            R.string.tab_shop,
            R.string.tab_eat
    };

    private Context context;
    private WeakReference<Fragment> currentFragmentRef;

    public MainPagerAdapter(FragmentManager manager, Context context) {
        super(manager);
        this.context = context;
    }

    public Fragment getCurrentFragment() {
        if (currentFragmentRef != null) {
            return currentFragmentRef.get();
        }
        return null;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        currentFragmentRef = new WeakReference(object);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case TAB_CITY_GUIDE:
                return CityGuideFragment_.builder().build();

            case TAB_SHOP:
                return CityGuideFragment_.builder().build();

            case TAB_EAT:
                return CityGuideFragment_.builder().build();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabIds.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return context.getString(tabTitleResIds[position]);
    }
}
