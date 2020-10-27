package com.huatec.edu.mobileshop.activity;
/**
*
*  @Author: Geek
*  @CreateDate: 2019/5/10 14:44
*/

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.common.Constant;
import com.huatec.edu.mobileshop.util.ImageLoaderManager;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class AdActivity extends AppCompatActivity {
    private ImageView mAd_iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        initView();
        loadAd("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=224293842,729733073&fm=26&gp=0.jpg");

        /**
         * 方式一
         */
        Button skipButton =  findViewById(R.id.skip_button);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skip();
            }
        });
        /**
         * 方式二
         */
//        Button skipButton = findViewById(R.id.skip_button);
//        skipButton.setOnClickListener(this);

//        findViewById(R.id.skip_button).setOnClickListener(this);

    }

    private void initView() {
        mAd_iv = findViewById(R.id.ad_image);

    }

    private void loadAd(String url) {
        ImageLoader.getInstance().displayImage(url, mAd_iv, ImageLoaderManager.product_options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                skip();
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                timer();
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                skip();
            }
        });
    }

    private void timer() {
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == -1) {
                    skip();
                }
            }
        };
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(Constant.AD_TIME_SECOND);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(-1);
            }
        }.start();
    }

    private void skip() {
        //简单的页面跳转
        //不带参数
        startActivity(new Intent(AdActivity.this,MainActivity.class));
        //带参数
//        Intent intent = new Intent(AdActivity.this, MainActivity.class);
//        intent.putExtra("参数名", "参数");
//        startActivity(intent);
        finish();
    }
}
