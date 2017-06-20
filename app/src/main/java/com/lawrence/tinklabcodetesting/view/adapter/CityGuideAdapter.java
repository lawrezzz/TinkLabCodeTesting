package com.lawrence.tinklabcodetesting.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.lawrence.tinklabcodetesting.model.bean.CityGuide;
import com.lawrence.tinklabcodetesting.utils.RecyclerViewAdapterBase;
import com.lawrence.tinklabcodetesting.utils.ViewWrapper;
import com.lawrence.tinklabcodetesting.view.widget.CityGuideDescriptionView_;
import com.lawrence.tinklabcodetesting.view.widget.CityGuideImageView_;
import com.lawrence.tinklabcodetesting.view.widget.IViewHolder;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kit on 19/6/2017.
 */

@EBean
public class CityGuideAdapter extends RecyclerViewAdapterBase<IViewHolder> {

    public enum ITEM_TYPE {
        ITEM_TYPE_WITH_DESC,
        ITEM_TYPE_IMG_ONLY
    }


    private Context context;
    private List<CityGuide> itemList = new ArrayList<CityGuide>();

    public CityGuideAdapter(Context context) {
        this.context = context;
    }

    public void setItems(List<CityGuide> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void onBindViewHolder(ViewWrapper<IViewHolder> holder, int position) {
        IViewHolder view = holder.getView();
        CityGuide cityguide = itemList.get(position);
        view.bind(cityguide);
    }

    @Override
    protected IViewHolder onCreateItemView(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.ITEM_TYPE_WITH_DESC.ordinal()) {
            return CityGuideDescriptionView_.build(context);
        } else if (viewType == ITEM_TYPE.ITEM_TYPE_IMG_ONLY.ordinal()) {
            return CityGuideImageView_.build(context);
        }
        return null;
    }


    @Override
    public int getItemViewType(int position) {
        if (itemList.get(position).getType().equals(CityGuide.TYPE_DESC)) {
            return ITEM_TYPE.ITEM_TYPE_WITH_DESC.ordinal();
        } else {
            return ITEM_TYPE.ITEM_TYPE_IMG_ONLY.ordinal();
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
