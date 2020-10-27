package com.huatec.edu.mobileshop.adapter;

import android.view.View;

import com.huatec.edu.mobileshop.entity.CategoryEntity;

public interface OnRecyclerViewItemClickListener {
    void OnItemClick(View view, CategoryEntity data);
}
