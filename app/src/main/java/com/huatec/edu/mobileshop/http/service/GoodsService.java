package com.huatec.edu.mobileshop.http.service;

import com.huatec.edu.mobileshop.entity.GoodsEntity;
import com.huatec.edu.mobileshop.entity.HttpResult;
import com.huatec.edu.mobileshop.entity.TestWeather;
import com.huatec.edu.mobileshop.entity.test.Test;
import com.huatec.edu.mobileshop.entity.test.TestData;
import com.huatec.edu.mobileshop.entity.test.TestData1;
import com.huatec.edu.mobileshop.entity.test.TestData2;
import com.huatec.edu.mobileshop.entity.test.TestData3;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;
import rx.Observer;

public interface GoodsService {
    @GET("goods/page/{pageId}")
    Call<Test> getGoodsList(@Path("pageId") int pageId);

    @GET("filebox/listBoxInfo")
    Call<TestData> getTestData();
    @GET("basic/getCorpList")
    Call<TestData1> getTestData1();
    @GET("user/checklogin")
    Call<TestData2> getTestData2(@Query("username") String username, @Query("password") int password);
    @GET("list.from")
    Call<TestData3> getTestData3(@QueryMap Map<String,String> params);

    /**
     * 根据二级分类的id，获取商品列表
     * @param catId
     * @return
     */
    @GET("goods/cat/{catId}")
    Observable<HttpResult<List<GoodsEntity>>> list(@Path("catId") int catId);
}
