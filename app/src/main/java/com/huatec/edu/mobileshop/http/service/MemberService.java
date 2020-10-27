package com.huatec.edu.mobileshop.http.service;

import com.huatec.edu.mobileshop.entity.HttpResult;
import com.huatec.edu.mobileshop.entity.MemberEntity;
import com.huatec.edu.mobileshop.entity.test.TestD1;
import com.huatec.edu.mobileshop.entity.test.TestData;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface MemberService {

    @FormUrlEncoded
    @POST("member/mem_add")
    Observable<HttpResult<MemberEntity>> register(
        @Field("uname") String uname,
        @Field("password") String password,
        @Field("email") String email
    );
    @FormUrlEncoded
    @POST("member/mem_login")
    Observable<HttpResult<MemberEntity>> login(
            @Field("uname") String uname,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("member/{memberId}")
    Observable<HttpResult<MemberEntity>> changePassword(
            @Path("memberId") String memberId,
            @Field("old_pwd") String old_pwd,
            @Field("new_pwd") String new_pwd
    );
    @FormUrlEncoded
    @POST("member/pwd")
    Observable<HttpResult<MemberEntity>> findPassword(
            @Field("email") String emailr
    );

    @GET("filebox/listBoxInfo")
    Observable<TestData>getTestData();

    @GET("basic/getCorpList")
    Observable<TestD1> getTestBasic();
}
