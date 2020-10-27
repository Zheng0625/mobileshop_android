package com.huatec.edu.mobileshop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.entity.CategoryEntity;

import java.util.List;

public class CategoryLeftListAdapter extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private List<CategoryEntity> mLeftData;
    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener = null;
    //选中的索引
    private int selectedCategoryId = 0;
    public CategoryLeftListAdapter(Context context, List<CategoryEntity> leftData) {
        this.mContext = context;
        this.mLeftData = leftData;
        Log.e("mLeftData", mLeftData.toString());

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category_list_left, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        //将创建View注册点击事件
        view.setOnClickListener(this);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder) {
            ViewHolder newHolder = (ViewHolder) viewHolder;
            //填充数据
            CategoryEntity entity = mLeftData.get(i);
            newHolder.textView.setText(entity.getName());
            //将数据保存在itemView的Tag中，以便点击时进行获取
            newHolder.itemView.setTag(entity);
            //修改状态
            if (entity.getCatId() == selectedCategoryId) {
                newHolder.itemView.setBackgroundResource(R.drawable.category_left_bg_focus);
                newHolder.textView.setTextColor(viewHolder.itemView.getResources().getColor(R.color.category_left_red_font));
            } else {
                newHolder.itemView.setBackgroundResource(R.drawable.category_left_bg_normal);
                newHolder.textView.setTextColor(viewHolder.itemView.getResources().getColor(R.color.category_left_dark_font));
            }
        }

    }

    @Override
    public int getItemCount() {
        return mLeftData.size();
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.onRecyclerViewItemClickListener = listener;
    }

    /**
     * 设置选中行
     */
    public void setSelection(int categoryId) {
        selectedCategoryId = categoryId;
        this.notifyDataSetChanged();
    }
    @Override
    public void onClick(View v) {
        if (onRecyclerViewItemClickListener != null) {
            //注意这里使用getTag()方法获取数据
            CategoryEntity entity = (CategoryEntity) v.getTag();
            onRecyclerViewItemClickListener.OnItemClick(v,entity);
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }
    }

}
