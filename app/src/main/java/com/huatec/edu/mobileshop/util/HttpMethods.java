package com.huatec.edu.mobileshop.util;

import android.util.Log;

import com.huatec.edu.mobileshop.common.Constant;
import com.huatec.edu.mobileshop.entity.HttpResult;
import com.huatec.edu.mobileshop.entity.test.TestD1;
import com.huatec.edu.mobileshop.http.service.CategoryService;
import com.huatec.edu.mobileshop.http.service.GoodsService;
import com.huatec.edu.mobileshop.http.service.MemberService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class HttpMethods {

    public static final String BASE_URL = Constant.BASE_URL;
    private static final int DEFAULT_TIME = 5;
    private Retrofit retrofit;
    private static HttpMethods install;
    protected static GoodsService goodsService;
    protected static MemberService memberService;
    protected static CategoryService categoryService;

    public HttpMethods() {
        if (install == null) {
            //1、OKHttp实例化
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_TIME, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIME, TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_TIME, TimeUnit.SECONDS)
                    .build();
            //2、retrofit实例化
            retrofit = new Retrofit.Builder()
                    //设置基础访问地址
                    .baseUrl(BASE_URL)
                    //设置数据解析工具为Gson
                    .addConverterFactory(GsonConverterFactory.create())
                    //设置数据回调处理工具为RxJava
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    //设置网络连接方式为okhttp
                    .client(okHttpClient).build();
            //3、将网络访问接口进行初始化
            goodsService = retrofit.create(GoodsService.class);//初始化接口
            memberService = retrofit.create(MemberService.class);//初始化接口
            categoryService = retrofit.create(CategoryService.class);//初始化接口
        }
    }

    public static HttpMethods getInstall() {
        if (install == null) {
            synchronized (HttpMethods.class) {
                if (install == null) {
                    install = new HttpMethods();
                }
            }
        }
        return install;
    }

    /**
     * Func1 是RxJava的接口，用于包装一个带返参数的方法，其他包装的方法具有返回值
     *
     * @param <T> 返回值泛型
     *            数据在获取时，以统一封装格式进行包装获取
     */
    public static class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {
        @Override
        public T call(HttpResult<T> tHttpResult) {
            Log.i("========", "=======" + tHttpResult.toString());
            return tHttpResult.getData();
        }
    }

    /**
     * 公共事件的订阅方法
     *
     * @param o   被观察者
     * @param s   观察者
     * @param <T>
     */
    public static <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())  //在IO线程中产生事件
                .unsubscribeOn(Schedulers.io())  //也是在IO线程中关闭事件
                .observeOn(AndroidSchedulers.mainThread())  //在安卓主线程中处理事件
                .subscribe(s);  //订阅事件
    }
}
