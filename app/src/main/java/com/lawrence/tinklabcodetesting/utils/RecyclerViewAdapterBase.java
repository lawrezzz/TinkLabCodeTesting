package com.lawrence.tinklabcodetesting.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kit on 19/6/2017.
 */

public abstract class RecyclerViewAdapterBase<V extends View> extends RecyclerView.Adapter<ViewWrapper<V>> {

    @Override
    public final ViewWrapper<V> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewWrapper<V>(onCreateItemView(parent, viewType));
    }

    protected abstract V onCreateItemView(ViewGroup parent, int viewType);

}
