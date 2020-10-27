package com.huatec.edu.mobileshop.entity.JsonTest;

import android.content.Context;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class Test {
    public void WriteStringToFile(String data) throws IOException {
        try {
            File absoluteFile = new File("D:\\Android_WSpace\\MobileShop\\app\\src\\main\\assets\\testjson4.txt");
            BufferedWriter out = new BufferedWriter(new FileWriter(absoluteFile));
            out.write(data);
            out.flush(); // 把缓存区内容压入文件
            out.close();
            Log.i("111", "写入成功");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.i("111", e.toString());
        }
    }
    public static String readAssetsTxt(Context context, String fileName) {
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "读取错误";
    }
}
