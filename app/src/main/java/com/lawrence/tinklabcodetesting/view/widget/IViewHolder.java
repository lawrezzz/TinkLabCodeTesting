package com.lawrence.tinklabcodetesting.view.widget;

import android.content.Context;
import android.widget.RelativeLayout;

import com.lawrence.tinklabcodetesting.model.bean.CityGuide;

import org.androidannotations.annotations.EViewGroup;

/**
 * Created by Kit on 19/6/2017.
 */

@EViewGroup
public class IViewHolder extends RelativeLayout {

    public IViewHolder(Context context) {
        super(context);
    }

    public void bind(CityGuide cityGuide) {

    }

}
