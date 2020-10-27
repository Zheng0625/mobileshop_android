package com.huatec.edu.mobileshop.http.presenter;

import com.huatec.edu.mobileshop.entity.MemberEntity;
import com.huatec.edu.mobileshop.entity.test.TestD1;
import com.huatec.edu.mobileshop.entity.test.TestData;
import com.huatec.edu.mobileshop.util.HttpMethods;

import rx.Observable;
import rx.Subscriber;

public class MemberPresenter extends HttpMethods {
    /*
     *  数据格式统一时，可以使用map方式将数据包装
     */
    public static void register(Subscriber<MemberEntity> subscriber, String username, String password, String email) {
        Observable observable = memberService.register(username, password, email)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable, subscriber);
    }
    public static void login(Subscriber<MemberEntity> subscriber, String username, String password) {
        Observable observable = memberService.login(username, password)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable, subscriber);
    }

    //修改密码
    public static void changePassword(Subscriber subscriber,String memberId,String old_pwd,String new_pwd){
        Observable observable=memberService.changePassword(memberId,old_pwd,new_pwd);
        toSubscribe(observable,subscriber);
    }
    //找回密码,修改成功或者失败后的data数据为null
    public static void findPassword(Subscriber subscriber,String email){
        Observable observable=memberService.findPassword(email);
        toSubscribe(observable,subscriber);
    }

    /**
     * 数据格式不统一
     */
    public static void getTest(Subscriber<TestData> subscriber) {
        Observable observable = memberService.getTestData();
        toSubscribe(observable, subscriber);
    }
    public static  void Test1(Subscriber<TestD1> subscriber){
        Observable observable=memberService.getTestBasic();
        toSubscribe(observable,subscriber);
    }


}
