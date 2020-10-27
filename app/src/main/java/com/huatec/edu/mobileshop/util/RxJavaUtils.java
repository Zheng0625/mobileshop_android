package com.huatec.edu.mobileshop.util;

import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class RxJavaUtils {
    /**
     * 1、创建观察者
     */
    Observer<String> observer = new Observer<String>() {
        @Override
        public void onCompleted() {
            Log.i("====", "====1、observer====onCompleted");
        }

        @Override
        public void onError(Throwable e) {
            Log.i("====", "====2、observer====onError" + e.getMessage());
        }

        @Override
        public void onNext(String s) {
            Log.i("====", "====3、observer===="+s);
        }
    };
    Subscriber subscriber = new Subscriber() {
        @Override
        public void onCompleted() {
            Log.i("====", "====1、subscriber====onCompleted");
        }

        @Override
        public void onError(Throwable e) {
            Log.i("====", "====2、subscriber====onError" + e.getMessage());
        }

        @Override
        public void onNext(Object o) {
            Log.i("====", "====3、subscriber===="+o);
        }
    };
    /**
     * 2、创建被观察者
     * 调用方法
     * RxJavaUtils rxJavaUtils = new RxJavaUtils()
     * rxJavaUtils.startRxJava();
     */
    Observable observable = Observable.create(new Observable.OnSubscribe() {
        @Override
        public void call(Object o) {
            subscriber.onNext("hello1");
            subscriber.onNext("hello2");
            subscriber.onNext("hello3");
            subscriber.onCompleted();
        }
    });
    String[] data={"1","2","3","4"};
    Observable observableArr=Observable.from(data);//快速创建1：如何使用
    Observable observableJust=Observable.just("j1","j2","j3");//快速创建2：如何使用
    /**
     * 实现订阅
     */
    public void startRxJava() {
        observable.subscribe(observer);//订阅方式一
        observable.subscribe(subscriber);//订阅方式二
//        observableArr.subscribe(observer);
//        observableJust.subscribe(subscriber);
    }

}
