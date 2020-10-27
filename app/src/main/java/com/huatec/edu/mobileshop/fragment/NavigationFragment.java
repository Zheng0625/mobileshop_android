package com.huatec.edu.mobileshop.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.huatec.edu.mobileshop.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class NavigationFragment extends BaseFragment implements View.OnClickListener{
    private LinearLayout tabItemHome;
    private LinearLayout tabItemCart;
    private LinearLayout tabItemCategory;
    private LinearLayout tabItemPerson;
    private ImageButton tabItemHomeBtn;
    private ImageButton tabItemCartBtn;
    private ImageButton tabItemCategoryBtn;
    private ImageButton tabItemPersonBtn;
    private FragmentManager fragmentManager;


    private HomeFragment homeFragment;
    private CartFragment cartFragment;
    private CategoryFragment categoryFragment;
    private PersonFragment personFragment;
    public int currrentId;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation,null);
        /**
         * 初始化控件、默认进入首页
         * */
        initView(view);
        selectTab(R.id.tab_item_home);
        return view;
    }

    private void initView(View view){
        tabItemHome = view.findViewById(R.id.tab_item_home);
        tabItemHome.setOnClickListener(this);
        tabItemCart = view.findViewById(R.id.tab_item_cart);
        tabItemCart.setOnClickListener(this);
        tabItemCategory = view.findViewById(R.id.tab_item_category);
        tabItemCategory.setOnClickListener(this);
        tabItemPerson = view.findViewById(R.id.tab_item_personal);
        tabItemPerson.setOnClickListener(this);

        tabItemHomeBtn = view.findViewById(R.id.tab_item_home_btn);
        tabItemCartBtn = view.findViewById(R.id.tab_item_cart_btn);
        tabItemCategoryBtn = view.findViewById(R.id.tab_item_category_btn);
        tabItemPersonBtn = view.findViewById(R.id.tab_item_personal_btn);


        fragmentManager = getFragmentManager();
    }
    @Override
    public void onClick(View v) {
        selectTab(v.getId());
    }
    public void selectTab(int id){
        tabItemHomeBtn.setImageResource(R.drawable.tab_item_home_focus);
        tabItemCartBtn.setImageResource(R.drawable.tab_item_cart_focus);
        tabItemCategoryBtn.setImageResource(R.drawable.tab_item_category_focus);
        tabItemPersonBtn.setImageResource(R.drawable.tab_item_personal_focus);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(homeFragment!=null){
                fragmentTransaction.hide(homeFragment);
        }
        if(cartFragment!=null){
            fragmentTransaction.hide(cartFragment);
        }
        if(categoryFragment!=null){
            fragmentTransaction.hide(categoryFragment);
        }
        if(personFragment!=null){
            fragmentTransaction.hide(personFragment);
        }

        switch (id){
            case R.id.tab_item_home:
                tabItemHomeBtn.setImageResource(R.drawable.tab_item_home_normal);
                if (homeFragment==null){
                    homeFragment=new HomeFragment();
                    fragmentTransaction.add(R.id.content,homeFragment);
                }else{
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case R.id.tab_item_category:
                tabItemCategoryBtn.setImageResource(R.drawable.tab_item_category_normal);
                if (categoryFragment==null){
                    categoryFragment=new CategoryFragment();
                    fragmentTransaction.add(R.id.content,categoryFragment);
                }else{
                    fragmentTransaction.show(categoryFragment);
                }
                break;
            case R.id.tab_item_cart:
                tabItemCartBtn.setImageResource(R.drawable.tab_item_cart_normal);
                if (cartFragment==null){
                    cartFragment=new CartFragment();
                    fragmentTransaction.add(R.id.content,cartFragment);
                }else{
                    fragmentTransaction.show(cartFragment);
                }
                break;
            case R.id.tab_item_personal:
                tabItemPersonBtn.setImageResource(R.drawable.tab_item_personal_normal);
                if (personFragment==null){
                    personFragment=new PersonFragment();
                    fragmentTransaction.add(R.id.content,personFragment);
                }else{
                    fragmentTransaction.show(personFragment);
                }
                break;
        }
        fragmentTransaction.commit();
        currrentId = id;
    }
}
