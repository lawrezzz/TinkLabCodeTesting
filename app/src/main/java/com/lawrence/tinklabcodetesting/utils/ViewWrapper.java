package com.lawrence.tinklabcodetesting.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Kit on 19/6/2017.
 */

public class ViewWrapper<V extends View> extends RecyclerView.ViewHolder {

    private V view;

    public ViewWrapper(V itemView) {
        super(itemView);
        view = itemView;
    }

    public V getView() {
        return view;
    }
}