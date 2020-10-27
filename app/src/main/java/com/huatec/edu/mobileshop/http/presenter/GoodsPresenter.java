package com.huatec.edu.mobileshop.http.presenter;

import com.huatec.edu.mobileshop.entity.GoodsEntity;
import com.huatec.edu.mobileshop.entity.MemberEntity;
import com.huatec.edu.mobileshop.util.HttpMethods;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class GoodsPresenter extends HttpMethods {
    /**
     * 根据二级分类获取商品列表
     */
    public static void list(Subscriber<List<GoodsEntity>> subscriber, int catId) {
        Observable<List<GoodsEntity>> observable = goodsService.list(catId)
                .map(new HttpResultFunc<List<GoodsEntity>>());
        toSubscribe(observable, subscriber);
    }

    public static void listByKeywords(Subscriber<List<GoodsEntity>> subscriber, String keyword) {
    }
}
