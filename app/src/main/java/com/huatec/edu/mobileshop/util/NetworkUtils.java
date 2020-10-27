package com.huatec.edu.mobileshop.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {
    public static boolean isNetworkAvailable(Activity activity) {
        Context context = activity.getApplicationContext();
        //获取手机所有连接管理对象
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        } else {
            //获取NetworkInfo对象
            NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();
            if (networkInfos != null && networkInfos.length > 0) {
                for (int i = 0; i < networkInfos.length; i++) {
                    System.out.println(i + "===状态===" + networkInfos[i].getState());
                    System.out.println(i + "===类型===" + networkInfos[i].getTypeName());
                    //判断当前网络状态是否为连接状态
                    if (networkInfos[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
