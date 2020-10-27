package com.huatec.edu.mobileshop;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUrlConnection {
    public static String doGet(String url){
        String result="";
        try{
            URL newUrl=new URL(url);
            HttpURLConnection conn=(HttpURLConnection)newUrl.openConnection();
            conn.setRequestMethod("Get");  //设置请求类型
            conn.setConnectTimeout(8000);//设置连接超时
            conn.setReadTimeout(8000);//设置读取超时
            conn.setRequestProperty("User-Agent","Mozilla/5.0(Windows NT6.3;WOW64;rv:27.0) Gecko.20100101 Firefox/27.0");
            conn.setRequestProperty("Content-Type","application/json;charset=utf-8");
            //同步Cookie,根据情况添加
            CookieManager cookieManager=CookieManager.getInstance();
            if(cookieManager.hasCookies()){
                String cookie=cookieManager.getCookie(url);
                if(!TextUtils.isEmpty(cookie)){
                    conn.setRequestProperty("Cookie",cookie);
                }
            }
            InputStream is=null;
            ByteArrayOutputStream baos=null;
            if(conn.getResponseCode()==200){//成功获取数据
                is=conn.getInputStream();
                baos=new ByteArrayOutputStream();
                int len=0;
                byte[] buffer=new byte[1024];
                while((len=is.read(buffer))!=-1){
                    baos.write(buffer,0,len);
                }
                result=baos.toString();
                return result;
            }
            if(is!=null){
                is.close();
            }
            if(baos!=null){
                baos.close();
            }
            return  "";
        } catch (MalformedURLException e) {
            Log.e("",e.getMessage());
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("",e.getMessage());
            e.printStackTrace();
        }
        return "";
    }


}
