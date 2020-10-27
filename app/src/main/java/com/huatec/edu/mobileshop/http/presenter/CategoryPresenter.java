package com.huatec.edu.mobileshop.http.presenter;

import com.huatec.edu.mobileshop.entity.CategoryEntity;
import com.huatec.edu.mobileshop.util.HttpMethods;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class CategoryPresenter extends HttpMethods {
    public static void getTopList(Subscriber<List<CategoryEntity>> subscriber) {
        Observable observable = categoryService.getTopList().map(new HttpResultFunc<List<CategoryEntity>>());//创建被观察者
        toSubscribe(observable, subscriber);//订阅
    }

    public static void getSecondList(Subscriber<List<CategoryEntity>> subscriber, Integer parentId) {
        Observable observable = categoryService.getSecondList(parentId)
                .map(new HttpResultFunc<List<CategoryEntity>>());
        toSubscribe(observable, subscriber);

    }
}
