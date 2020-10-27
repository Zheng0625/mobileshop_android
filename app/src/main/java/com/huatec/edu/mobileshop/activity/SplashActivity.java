package com.huatec.edu.mobileshop.activity;
/**
*
*  @Author: Geek
*  @CreateDate: 2019/5/09 14:44
*/

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.huatec.edu.mobileshop.R;

public class SplashActivity extends AppCompatActivity {
    private ImageView mSplashItem_iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        //ImageView 初始化
        mSplashItem_iv = findViewById(R.id.splash_loading_item);
        /**  添加动画 */
        Animation translate = AnimationUtils.loadAnimation(this, R.anim.splash_loading);
        translate.setAnimationListener(new Animation.AnimationListener() {
            //动画开始时的操作
            @Override
            public void onAnimationStart(Animation animation) {

            }
            //动画结束后的操作
            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this, AdActivity.class));
                /**
                 * R.anim.push_left_in 新的Activity进入时的动画，这里是指OtherActivity进入时的动画
                 *
                 * R.anim.push_left_out 旧的Activity出去时的动画，这里是指this进入时的动画
                 */
                overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mSplashItem_iv.setAnimation(translate); //为ImageView设置动画
    }
}
