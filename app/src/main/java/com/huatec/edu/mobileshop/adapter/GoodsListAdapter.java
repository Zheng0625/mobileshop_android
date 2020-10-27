package com.huatec.edu.mobileshop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.entity.GoodsEntity;
import com.huatec.edu.mobileshop.util.ImageLoaderManager;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class GoodsListAdapter extends RecyclerView.Adapter<GoodsListAdapter.ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private List<GoodsEntity> listData;
    public OnGoodsItemClickListener monGoodsItemClickListener;
    public  GoodsListAdapter(Context context,List<GoodsEntity> data){
        this.mContext=context;
        this.listData=data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.item_goods_list,parent,false);
        view.setOnClickListener(this);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GoodsEntity entity=listData.get(position);
        ImageLoader.getInstance().displayImage(entity.getSmall(),holder.imageView,ImageLoaderManager.product_options);
        holder.title.setText(entity.getName());
        holder.price.setText("$"+String.format("%.2f",entity.getPrice()));
        holder.itemView.setTag(entity);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public void onClick(View v) {
    if(monGoodsItemClickListener!=null){
        monGoodsItemClickListener.onClick(v,(GoodsEntity)v.getTag());
    }
    }
    public void setOnGoodsItemClickListener(OnGoodsItemClickListener listener){
        this.monGoodsItemClickListener=listener;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;//商品图片
        private TextView title;//商品名称
        private TextView price;//商品价格
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.goodlist_img);
            title=(TextView)itemView.findViewById(R.id.goodslist_name);
            price=(TextView)itemView.findViewById(R.id.goodslist_price);
        }
    }
    public interface OnGoodsItemClickListener {
        void onClick(View v, GoodsEntity tag);
    }
}
