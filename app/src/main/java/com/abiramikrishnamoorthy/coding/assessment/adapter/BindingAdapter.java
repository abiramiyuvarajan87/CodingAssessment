package com.abiramikrishnamoorthy.coding.assessment.adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BindingAdapter {

    @androidx.databinding.BindingAdapter("layoutManager")
    public static void setLayoutManagerInstance(RecyclerView recyclerView, int layoutOrientation) {
        if (layoutOrientation == RecyclerView.HORIZONTAL) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), RecyclerView.HORIZONTAL, false));
        } else if (layoutOrientation == RecyclerView.VERTICAL) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }
    }
}
