package com.huatec.edu.mobileshop.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.activity.GoodsActivity;
import com.huatec.edu.mobileshop.adapter.CategoryLeftListAdapter;
import com.huatec.edu.mobileshop.adapter.CategoryRightListAdapter;
import com.huatec.edu.mobileshop.adapter.OnRecyclerViewItemClickListener;
import com.huatec.edu.mobileshop.common.Constant;
import com.huatec.edu.mobileshop.entity.CategoryEntity;
import com.huatec.edu.mobileshop.http.presenter.CategoryPresenter;
import com.huatec.edu.mobileshop.util.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscriber;

public class CategoryFragment extends BaseFragment {
    //返回图标
    @BindView(R.id.title_back)
    ImageView titleBack;

    @BindView(R.id.search_title_icon)
    ImageView searchTitleIcon;

    //搜索关键词
    @BindView(R.id.search_keyword)
    TextView searchKeyword;
    @BindView(R.id.product_list_search_clean)
    ImageButton productListSearchClean;
    //搜索布局
    @BindView(R.id.search_layout)
    RelativeLayout searchLayout;
    @BindView(R.id.product_list_search_layout)
    RelativeLayout productListSearchLayout;
    @BindView(R.id.common_title)
    RelativeLayout commonTitle;
    //左右列表
    @BindView(R.id.left_list)
    RecyclerView leftList;
    @BindView(R.id.right_list)
    RecyclerView rightList;
    @BindView(R.id.mainlayout)
    LinearLayout mainlayout;

    private List<CategoryEntity> leftData = new ArrayList<>();
    private List<CategoryEntity> rightData = new ArrayList<>();
    private CategoryRightListAdapter rightListAdapter;
    private CategoryLeftListAdapter leftListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container,false);
        ButterKnife.bind(this, view);
        initViews();
        return view;

    }

    private void initViews() {
        //调整搜索栏的样式
        titleBack.setVisibility(View.GONE);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                AndroidUtils.dp2px(this.getActivity(), 30));
        layoutParams.setMargins(10, 3, 10, 0);//设置外边距
        searchLayout.setLayoutParams(layoutParams);
        //设置列表样式
        LinearLayoutManager leftManager = new LinearLayoutManager(getActivity());
        leftManager.setOrientation(OrientationHelper.VERTICAL);
        //垂直表格  Constant.SPAN_COUNT设置显示列数，为常量值，暂定为3
        GridLayoutManager reightManager = new GridLayoutManager(getActivity(), Constant.SPAN_COUNT, OrientationHelper.VERTICAL, false);
        leftList.setLayoutManager(leftManager);
        rightList.setLayoutManager(reightManager);
        //初始化适配数据
        leftListAdapter = new CategoryLeftListAdapter(getActivity(), leftData);
        rightListAdapter = new CategoryRightListAdapter(getActivity(), rightData);
        leftList.setAdapter(leftListAdapter); //设置载入数据
        rightList.setAdapter(rightListAdapter);
        //根据接口获取并加载左侧列表数据和item0 对应的右侧列表数据
        CategoryPresenter.getTopList(new Subscriber<List<CategoryEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                Log.e("xxx", e.getMessage());
            }

            @Override
            public void onNext(List<CategoryEntity> list) {
                if (list.size() > 0) {
                    leftData.addAll(list);//加载数据
                    leftListAdapter.notifyDataSetChanged();//刷新列表
                    //载入item0的右侧列表数据，这样做是因为我们进入分类页面需要默认先显示第一类商品
                    int cat_id = list.get(0).getCatId();
                    loadRight(cat_id);
                    //默认选中第一项
                    leftListAdapter.setSelection(cat_id);
                }
            }
        });
        //左侧列表点击事件
        leftListAdapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void OnItemClick(View view, CategoryEntity data) {
                //加载右侧数据，根据分类id去获取对应的分类数据
                loadRight(data.getCatId());
                leftListAdapter.setSelection(data.getCatId());
            }
        });
        //右侧列表点击事件
        rightListAdapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void OnItemClick(View view, CategoryEntity data) {
                //跳转到商品列表界面
                Intent intent = new Intent(getActivity(), GoodsActivity.class);
                intent.putExtra("cat_id", data.getCatId());
                startActivity(intent);
            }
        });
    }


    /**
     * 加载右侧列表数据
     * @param cat_id  一级目录类型id
     */
    private void loadRight(int cat_id) {
        CategoryPresenter.getSecondList(new Subscriber<List<CategoryEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<CategoryEntity> list) {
                if (list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        Log.i("CategoryFragment", "rightList-->" + list.get(0).toString());
                    }
                    rightData.clear();//每次切换产品类型后，需要将元数据清除，再重新加载数据
                    rightData.addAll(list);//加载新数据
                    rightListAdapter.notifyDataSetChanged();//刷新界面
                }

            }
        },cat_id);
    }
}
