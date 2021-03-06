package com.huatec.edu.mobileshop.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class DesityUtils {

    /**
     * 获取屏幕宽度
     *
     * @param context
     * @return
     */
    public static int getWidth(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }
}
