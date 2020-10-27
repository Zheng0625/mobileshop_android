package com.huatec.edu.mobileshop.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.huatec.edu.mobileshop.R;

public class BaseActivity extends AppCompatActivity {

    /**
     * 显示商品
     */
    public void showGoods(int goodsid) {
        Intent intent = new Intent(this, GoodsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.putExtra("goods_id", goodsid);
        startActivity(intent);
    }

    /**
     * protected 只有继承的子类能调用
     * public 能被继承的子类，或者实例化后直接调用
     * private只能被本类所使用
     */
    protected void show() {

    }
    /**
     * 是否登陆
     * @return
     */
    public boolean isLogin(){
        SharedPreferences sharedPreferences=getSharedPreferences("user",0);
        return  !TextUtils.isEmpty(sharedPreferences.getString("username",""));
    }
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);
//    }
}
