package com.huatec.edu.mobileshop.util;

import android.content.Context;

public class AndroidUtils {
    /**
     * dp转px
     * @param context
     * @param paramFloat
     * @return
     */
    public static int dp2px(Context context,float paramFloat){
        return (int) (0.5f+paramFloat*context.getResources().getDisplayMetrics().density);
    }

    /**
     * px转dp
     * @param context
     * @param paramFloat
     * @return
     */
    public static int px2dp(Context context,float paramFloat){
        return (int) (0.5f+paramFloat/context.getResources().getDisplayMetrics().density);
    }
}
