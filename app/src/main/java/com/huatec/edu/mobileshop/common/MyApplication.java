package com.huatec.edu.mobileshop.common;

import android.app.Application;
import android.content.Context;

import com.huatec.edu.mobileshop.activity.MainActivity;
import com.huatec.edu.mobileshop.db.DbUtils;
import com.huatec.edu.mobileshop.db.GreenDaoManager;
import com.huatec.edu.mobileshop.util.HttpMethods;
import com.huatec.edu.mobileshop.util.ImageLoaderManager;

public class MyApplication extends Application {
    private static Context mContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        //GreenDao管理类得实例化
        GreenDaoManager.getInstance();
        HttpMethods.getInstall();
        //初始化UIL
        ImageLoaderManager.getInstance();

//        DbUtils dbUtils = new DbUtils(mContext);
//        dbUtils.add();
//        dbUtils.selectAllData();

    }

    public static Context getmContext() {
        return mContext;
    }
}
