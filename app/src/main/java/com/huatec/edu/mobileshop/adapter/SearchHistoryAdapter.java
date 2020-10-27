package com.huatec.edu.mobileshop.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huatec.edu.mobileshop.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchHistoryAdapter extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener  {
    private Context mContext;
    private List<String> mData;
    private LayoutInflater mLayoutInflater;
    private OnHistoryItemClickListener mOnHistoryItemClickListener = null;

    /*
        实现构造函数
     */
    public SearchHistoryAdapter(Context context, List<String> data) {
        this.mContext = context;
        this.mData = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    /**
     * 在没使用butterknifer 时，我们需要将自己写自定义ViewHolder类,现在我们只要使用辅助工具自动实现即可
     * 光标停留在数据适配器布局id上按alt + insert
     * 添加后稍微修改即可
     * 在自动生成的全局类中添加继承
     * 添加超类。
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.item_search_history, viewGroup, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder) {
            ViewHolder mViewHolder = (ViewHolder) viewHolder;
            mViewHolder.keyword.setText(mData.get(i));
            mViewHolder.itemView.setTag(mData.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnItemClickListener(OnHistoryItemClickListener listener) {
        this.mOnHistoryItemClickListener = listener;
    }
    @Override
    public void onClick(View v) {
        if (mOnHistoryItemClickListener != null) {
            mOnHistoryItemClickListener.OnItemClick(v,(String)v.getTag());
        }

    }
    /*添加按键内部监听接口类*/
    public interface OnHistoryItemClickListener {
        void OnItemClick(View view, String tag);
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.keyword)
        TextView keyword;
        @BindView(R.id.keyword_correct_layout)
        LinearLayout keywordCorrect_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

