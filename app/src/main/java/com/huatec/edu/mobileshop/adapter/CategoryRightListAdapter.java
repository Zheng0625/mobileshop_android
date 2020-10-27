package com.huatec.edu.mobileshop.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.db.Category;
import com.huatec.edu.mobileshop.entity.CategoryEntity;
import com.huatec.edu.mobileshop.util.DesityUtils;
import com.huatec.edu.mobileshop.util.ImageLoaderManager;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

public class CategoryRightListAdapter extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private List<CategoryEntity> mRightData;
    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener = null;
    //选中的索引
    private int selectedCategoryId = 0;
    public CategoryRightListAdapter(Context context, List<CategoryEntity> rightData) {
        this.mContext = context;
        this.mRightData = rightData;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category_list_right, viewGroup, false);
        //获取左侧列表的宽度
        int left_width = (int) mContext.getResources().getDimension(R.dimen.category_list_left_width);
        //获取手机的屏幕宽度
        int width = DesityUtils.getWidth(mContext);
        //设置右侧列表的每个选项的宽度和高度
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((width - left_width) / 3, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        ViewHolder holder = new ViewHolder(view);
        //将创建的view注册点击事件
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof CategoryRightListAdapter.ViewHolder) {
            final CategoryRightListAdapter.ViewHolder newHolder = (ViewHolder) viewHolder;
            CategoryEntity entity = mRightData.get(i);
            //适配item数据
            newHolder.title1.setText(entity.getName());
            ImageLoader.getInstance().displayImage(entity.getImage(), newHolder.imageView, ImageLoaderManager.product_options, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {

                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    //设置图片高度?宽度
                    int image_width = (int) mContext.getResources().getDimension(R.dimen.category_list_right_image_width);
                    //重新计算图片，让图片始终显示为正方形
                    if (loadedImage != null) {
                        Bitmap bmp = Bitmap.createBitmap(loadedImage, 0, 0, loadedImage.getWidth(), loadedImage.getHeight());
                        bmp = Bitmap.createScaledBitmap(bmp, image_width, image_width, false);
                        newHolder.imageView.setImageBitmap(bmp);
                    }
                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {

                }
            });
            ((ViewHolder) viewHolder).imageView.setTag(entity);

        }

    }

    @Override
    public int getItemCount() {
        return mRightData.size();
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.onRecyclerViewItemClickListener = listener;
    }

    @Override
    public void onClick(View v) {
        if (onRecyclerViewItemClickListener != null) {
            //注意这里使用getTag()方法获取数据
            onRecyclerViewItemClickListener.OnItemClick(v, (CategoryEntity) v.getTag());
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title1;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title1 = itemView.findViewById(R.id.category_item_have_picture_text_1);
            imageView = itemView.findViewById(R.id.category_item_have_picture_image_1);
        }
    }

}
