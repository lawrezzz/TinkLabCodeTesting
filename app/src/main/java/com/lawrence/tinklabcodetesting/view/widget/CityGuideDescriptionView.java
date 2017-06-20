package com.lawrence.tinklabcodetesting.view.widget;

import android.content.Context;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lawrence.tinklabcodetesting.R;
import com.lawrence.tinklabcodetesting.model.bean.CityGuide;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Kit on 19/6/2017.
 */

@EViewGroup(R.layout.view_city_guide_description_item)
public class CityGuideDescriptionView extends IViewHolder {

    @ViewById(R.id.iv_city_guide)
    ImageView image;

    @ViewById(R.id.tv_city_guide_title)
    TextView titleText;

    @ViewById(R.id.tv_city_guide_description)
    TextView descriptionText;

    private CityGuide cityGuide;

    public CityGuideDescriptionView(Context context) {
        super(context);
    }

    @Override
    public void bind(CityGuide cityGuide) {
        this.cityGuide = cityGuide;

        Glide.with(this).load(cityGuide.getImage()).into(image);
        titleText.setText(cityGuide.getTitle());
        descriptionText.setText(cityGuide.getDescription());

    }

}
