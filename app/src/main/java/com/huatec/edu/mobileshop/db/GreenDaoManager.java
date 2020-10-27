package com.huatec.edu.mobileshop.db;

import android.content.Context;

import com.huatec.edu.mobileshop.common.MyApplication;
import com.huatec.edu.mobileshop.gen.DaoMaster;
import com.huatec.edu.mobileshop.gen.DaoSession;

public class GreenDaoManager {
    private static GreenDaoManager mInstance = null;
    private static DaoMaster mDaoMaster = null;
    private static DaoSession mDaoSession = null;
    public GreenDaoManager() {
        if (mInstance == null) {
            Context context = MyApplication.getmContext();//获取Context的实例化
            DaoMaster.DevOpenHelper devOpenHelper =
                    new DaoMaster.DevOpenHelper(context, "zhengyibo_db0425", null);//"zybdb"是数据库名
            mDaoMaster = new DaoMaster(devOpenHelper.getWritableDb());
            mDaoSession = mDaoMaster.newSession();
        }
    }

    /**
     * 单例模式初始化，当GreenDaoManager的实例化为空时，则对其进行初始化。反之则直接返回其实例化对象
     */
    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {
                if (mInstance == null) {
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public static DaoMaster getDaoMaster() {
        return mDaoMaster;
    }
    public static DaoSession getDaoSession() {
        return mDaoSession;
    }
    public static DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }
}
