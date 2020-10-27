package com.huatec.edu.mobileshop.util;

import android.app.Activity;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {
    /**
     * 读取assrts 目录下的文件
     * @param context  Context = Activity
     *                 在MainActivity中
     * @param path     文件路径
     * @return
     */

    public static  String getAssetsFile(Activity context,String path){
        StringBuilder stringBuilder = new StringBuilder();
        AssetManager assetManager = context.getAssets();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(path)));
            String line;
            /**
             * 读数据流，所谓数据流 ，就是二进制数据。通过二进制数据转换成字符数据
             * 整行读取，当数据非空则直接加入，否则跳出循环
             */
            while ((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();//字符串转换
    }
    /**
     * 正则表达式判断字符串是否为IP地址
     * @param str
     * @return
     */
    public boolean isIPV4(String str) {
        String pStr = "\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b";
        Pattern pattern = Pattern.compile(pStr);
        Matcher m = pattern.matcher(str);
        return m.matches();
    }
    /**
     * 正则表达式判断字串是否为email地址
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }
    /**
     * 正则表达式判断字串是否为手机号码
     * @param phoneNum
     * @return
     */
    public static boolean isCellphone(String phoneNum) {
        String str ="(^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57]|19[89])[0-9]{8}$)" ;
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(phoneNum);
        return matcher.matches();
    }

}
