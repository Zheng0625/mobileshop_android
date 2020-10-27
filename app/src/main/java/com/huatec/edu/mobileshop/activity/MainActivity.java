package com.huatec.edu.mobileshop.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.entity.test.TestData2;
import com.huatec.edu.mobileshop.fragment.NavigationFragment;
import com.huatec.edu.mobileshop.http.service.GoodsService;
import com.huatec.edu.mobileshop.util.RxJavaUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private NavigationFragment navigationFragment;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        navigationFragment = new NavigationFragment();
        fragmentTransaction.replace(R.id.main_frame, navigationFragment);
        fragmentTransaction.commit();
        RxJavaUtils rx = new RxJavaUtils();
        rx.startRxJava();
//        MemberPresenter.register(new ProgressDialogSub<MemberEntity>(this) {
//            @Override
//            public void onNext(MemberEntity memberEntity) {
//                Toast.makeText(MainActivity.this,"member:"+memberEntity.toString(),Toast.LENGTH_SHORT).show();
//            }
//        },"zzyb","123456","7515@qq.com");
//        testWeak();
//        MemberPresenter.getTest(new Subscriber<TestData>() {
//            @Override
//            public void onCompleted() {
//                Log.i("---onCompleted---","Completed + TestData------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.i("---onError---",e.getMessage()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//            }
//
//            @Override
//            public void onNext(TestData testData) {
//                for (TestData.ListBean.RowsBean t:testData.getList().getRows()) {
//                    Log.i("===onNext===",t.toString());
//                }
//                Log.i("===onNext===",testData.getList().getRows().get(0).toString());
//            }
//        });

//        MemberPresenter.Test1(new Subscriber<TestD1>() {
//            @Override
//            public void onCompleted() {
//                Log.i("---onCompleted---","Completed + TestD1------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.i("---onError---",e.getMessage()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//            }
//
//            @Override
//            public void onNext(TestD1 testd1) {
//                for (TestD1.ListBean t:testd1.getList()
//                     ) {
//                    Log.i("===onNext===",t.toString());
//                }
//                }
//        });

//        getGoodsDetail();
//        testgetData();
//        testgetData1();
//        testgetData2();
//        testgetData3();
//        testGet3();
//        testGet2();
//        testGet3();
//        testPost();
//        String jsob = Tools.getAssetsFile(this,"testlogin.txt");
//        String jsob = Tools.getAssetsFile(this,"testjson2.txt");
//        testGetData(jsob);
//        testToLoginE(jsob);
//        testToList(jsob);
//        testList(jsob);
//        testGetData4();testGetData4();
    }

    /**
     * 切换下方的tab标签
     *
     * @param tableIndex
     */
    //selectTab 为NavigationFragment 中的方法，原为private 需改成public
    public void changeTab(int tableIndex) {
        switch (tableIndex) {
            case 1:
                navigationFragment.selectTab(R.id.tab_item_home);
                break;
            case 2:
                navigationFragment.selectTab(R.id.tab_item_category);
                break;
            case 3:
                navigationFragment.selectTab(R.id.tab_item_cart);
                break;
            case 4:
                navigationFragment.selectTab(R.id.tab_item_personal);
                break;


        }
    }

    /**
     * 点击返回按键监听
     * 修改NavigationFragment 中的currentId 类型
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //currrentId 为NavigationFragment 中的方法，原为private 需改成public
        if (navigationFragment.currrentId != R.id.tab_item_home) {
            changeTab(1);
            return;
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        String action = intent.getStringExtra("action");
        if ("toIndex".equals(action)) {
            changeTab(1);

        }
        super.onNewIntent(intent);
    }
    public void showGoods(int goodsId) {
    }

    public boolean isLogin() {
        return true;
    }

    public void setVisible(int gone) {

    }

    //弱引用的简单学习
//    private void testWeak() {
//        String str = "JAVA";
//        WeakReference<String> wr = new WeakReference<>(str);//弱引用的实例化
//        str = null;
//        System.out.println(str);
//        System.out.println(wr.get());
//        System.gc();
//        System.out.println(wr.get());
//    }

//        private void testGet() {
//        final DbUtils dbUtils = new DbUtils(this);
//        OkHttpClient okHttpClient = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url("http://japi.juhe.cn/joke/content/list.from?key=c037fdc5bbb9e640d6b5a701dcb11441&page=1\t&pageSize=10&sort=asc&time=1418745237")
//                .get()
//                .build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                //请求失败
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                //请求成功
//                String backdata = response.body().string();
//                JsonObject jsonObject = new JsonParser().parse(backdata).getAsJsonObject();
//                JsonObject dataJson = jsonObject.get("result").getAsJsonObject();
//                JsonArray jsonArray = dataJson.get("data").getAsJsonArray();
//                Gson gson = new Gson();
//                /** 将我们的jsonArray映射成List列表*/
//                List<Test> dataList = gson.fromJson(jsonArray, new TypeToken<List<Test>>() {}.getType());
//                //测试输出
////                for (int i = 0; i < dataList.size(); i++) {
////                    Log.i("=========", "===========" + dataList.get(i).toString());
////                }
////                for (Test data:dataList
////                     ) {
////                    dbUtils.add(new Test(null,data.getContent(),data.getHashId(),data.getUnixtime(),data.getUpdatetime()));
////                    Log.i("========", data.toString());
////                }
//            }
//        });
//    }

//    private void testGet2() {
//        OkHttpClient okHttpClient = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url("http://t.weather.sojson.com/api/weather/city/101181101")
//                .get()
//                .build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                //请求失败
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                //请求成功
//                String backdata = response.body().string();
//                JsonObject jsonObject = new JsonParser().parse(backdata).getAsJsonObject();
//                String timeJson = jsonObject.get("time").getAsString();
//                String dateJson = jsonObject.get("date").getAsString();
//                String msgJson = jsonObject.get("message").getAsString();
//                String stsJson = jsonObject.get("status").getAsString();
//                Log.i("======", timeJson + "==" + dateJson + "==" + msgJson + "==" + stsJson);
//                JsonObject cityJson = jsonObject.get("cityInfo").getAsJsonObject();
//                String ccity = cityJson.get("city").getAsString();
//                String ccityid = cityJson.get("cityId").getAsString();
//                String cparent = cityJson.get("parent").getAsString();
//                String cupdateTime = cityJson.get("updateTime").getAsString();
//                Log.i("====cityInfo====", ccity + "==" + ccityid + "==" + cparent + "==" + cupdateTime);
//                JsonObject dataJson = jsonObject.get("data").getAsJsonObject();
//                String dshidu = dataJson.get("shidu").getAsString();
//                String dpm25 = dataJson.get("pm25").getAsString();
//                String dpm10 = dataJson.get("pm10").getAsString();
//                String dquality = dataJson.get("quality").getAsString();
//                String dwendu = dataJson.get("wendu").getAsString();
//                String dganmao = dataJson.get("ganmao").getAsString();
//                Log.i("====data====", dshidu + "==" + dpm25 + "==" + dpm10 + "==" + dquality + "==" + dwendu + "==" + dganmao);
//                JsonObject datayesJson = dataJson.get("yesterday").getAsJsonObject();
//                String ydate = datayesJson.get("date").getAsString();
//                String ysunrise = datayesJson.get("sunrise").getAsString();
//                String yhigh = datayesJson.get("high").getAsString();
//                String ylow = datayesJson.get("low").getAsString();
//                String ysunset = datayesJson.get("sunset").getAsString();
//                String yaqi = datayesJson.get("aqi").getAsString();
//                String yymd = datayesJson.get("ymd").getAsString();
//                String yweek = datayesJson.get("week").getAsString();
//                String yfx = datayesJson.get("fx").getAsString();
//                String yfl = datayesJson.get("fl").getAsString();
//                String ytype = datayesJson.get("type").getAsString();
//                String ynotice = datayesJson.get("notice").getAsString();
//                Log.i("====yesterday====", ydate + "==" + ysunrise + "==" + yhigh + "==" + ylow + "==" + ysunset + "==" + yaqi + "==" + yymd + "==" + yweek + "==" + yfx + "==" + yfl + "==" + ytype + "==" + ynotice);
//                JsonArray dataforJson = dataJson.get("forecast").getAsJsonArray();
//                Gson gson = new Gson();
//                /** 将我们的jsonArray映射成List列表*/
//                List<Forecast> forecastList = gson.fromJson(dataforJson, new TypeToken<List<Forecast>>() {
//                }.getType());
//                //测试输出
//                for (int i = 0; i < forecastList.size(); i++) {
//                    Log.i("=========", "===========" + forecastList.get(i).toString());
//                }
//
//            }
//        });
//    }

//    private void testPost() {
//        OkHttpClient okHttpClient = new OkHttpClient();
//        RequestBody requestBody = new FormBody.Builder()
//                .add("username", "111").add("password", "111").build();
//        Request request = new Request.Builder().url("http://www.baidu.com").post(requestBody).build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String data = response.body().string();
//                Log.i("msg", data);
//            }
//
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//        });
//    }

//    private void testGetData(String jsonStr) {
//        //将jsonstr转换成一个json对象
//        JsonObject jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();
//        //通过jsonObject将data对象标签数据提取出来并转换成一个新的对象
//        JsonObject dataJson = jsonObject.get("data").getAsJsonObject();
//        //将data对象标签下的数据根据字段提取
//        int id = dataJson.get("id").getAsInt();
//        String name = dataJson.get("name").getAsString();
//        String address = dataJson.get("address").getAsString();
//        Log.i("==", id + "==" + name + "==" + address);
//    }

//    private void testToPerson(String jsonstr) {
//        //将jsonstr转换成一个json对象
//        JsonObject jsonObject = new JsonParser().parse(jsonstr).getAsJsonObject();
//        //通过jsonObject将data对象标签数据提取出来并转换成一个新的对象
//        JsonObject dataJson = jsonObject.get("data").getAsJsonObject();
//        Gson gson = new Gson();
//        /** 将data对象标签的数据直接映射成person对象*/
//        Person person = gson.fromJson(dataJson, Person.class);
//        Log.i("==", "=======Person=======" + person.toString());
//    }

//    private void testToLoginE(String jsonstr) {
//        //将jsonstr转换成一个json对象
//        JsonObject jsonObject = new JsonParser().parse(jsonstr).getAsJsonObject();
//        //通过jsonObject将data对象标签数据提取出来并转换成一个新的对象
//        JsonObject dataJson = jsonObject.get("data").getAsJsonObject();
//        Gson gson = new Gson();
//        /** 将data对象标签的数据直接映射成person对象*/
//        LoginEntity loginEntity = gson.fromJson(dataJson, LoginEntity.class);
//        Log.i("==", "=======LoginEntity=======" + loginEntity.toString());
//    }

//    //将json数据转换成List链表
//    private void testToList(String jsonstr) {
//        JsonObject jsonObject = new JsonParser().parse(jsonstr).getAsJsonObject();
//        //将data数组标签提取并转换成JsonArray
//        JsonArray jsonArray = jsonObject.get("data").getAsJsonArray();
//        Gson gson = new Gson();
//        /** 将我们的jsonArray映射成List列表*/
//        List<Person> personList = gson.fromJson(jsonArray, new TypeToken<List<Person>>() {
//        }.getType());
//        //测试输出
//        for (int i = 0; i < personList.size(); i++) {
//            Log.i("=========", "===========" + personList.get(i).toString());
//        }
//    }

//    private void testList(String jsonstr) {
//        JsonObject jsonObject = new JsonParser().parse(jsonstr).getAsJsonObject();
//        String stsJson = jsonObject.get("status").getAsString();
//        String msgJson = jsonObject.get("msg").getAsString();
//        JsonObject dataJson = jsonObject.get("data").getAsJsonObject();
//        JsonArray jsonArray = dataJson.get("arr").getAsJsonArray();
//        int id = dataJson.get("id").getAsInt();
//        String name = dataJson.get("name").getAsString();
//        String address = dataJson.get("address").getAsString();
//        Log.i("==", stsJson + "==" + msgJson + "==" + id + "==" + name + "==" + address);
//
//        Gson gson = new Gson();
//        /** 将我们的jsonArray映射成List列表*/
//        List<Person> personList = gson.fromJson(jsonArray, new TypeToken<List<Person>>() {
//        }.getType());
//        //测试输出
//        for (int i = 0; i < personList.size(); i++) {
//            Log.i("=========", "===========" + personList.get(i).toString());
//        }
//
//    }

//    private void testGet3() {
//        final DbUtils dbUtils = new DbUtils(this);
//        OkHttpClient okHttpClient = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url("http://gank.io/api/today")
//                .get()
//                .build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                //请求失败
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                //请求成功
//                String backdata = response.body().string();
//                JsonObject jsonObject = new JsonParser().parse(backdata).getAsJsonObject();
//                JsonObject dataJson = jsonObject.get("results").getAsJsonObject();
//                JsonArray categoryArray = jsonObject.get("category").getAsJsonArray();
//                for (int i = 0; i < categoryArray.size(); i++) {
//                    Log.i("11111111", categoryArray.get(i).toString());
//                    String test = categoryArray.get(i).toString();
//                    String str = test.replace("\"", "");
//                    JsonArray testArray = dataJson.get(str).getAsJsonArray();
//                    Gson gson = new Gson();
//                    /** 将我们的jsonArray映射成List列表*/
//                    List<Today> dataList = gson.fromJson(testArray, new TypeToken<List<Today>>() {
//                    }.getType());
//                    //测试输出
//                    for (int j = 0; j < dataList.size(); j++) {
//                        Log.i("=========", "===========" + dataList.get(j).toString());
//                    }
//                    for (Today data:dataList
//                            ) {
//                        dbUtils.add(new Today(null, data.get_id(), data.getCreatedAt(), data.getDesc(), data.getPublishedAt(), data.getSource(), data.getType(), data.getUrl(), data.getUsed(), data.getWho()));
//                        Log.i("========", data.toString());
//                    }
//                }
//            }
//        });
//    }

//   private void getGoodsDetail() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Constant.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        GoodsService service = retrofit.create(GoodsService.class);
//        retrofit2.Call<Test> call = service.getGoodsList(1);
//        call.enqueue(new retrofit2.Callback<Test>() {
//            @Override
//            public void onResponse(retrofit2.Call<Test> call, retrofit2.Response<Test> response) {
//                for (Data data : response.body().getData()) {
//                    Log.i("====", data.toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Test> call, Throwable t) {
//                Log.i("test", "=======请求失败！！！" + t.toString());
//            }
//
//        });
//    }

//    private void testgetData() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://39.106.173.47/filemgt_test/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        GoodsService service = retrofit.create(GoodsService.class);
//        retrofit2.Call<TestData> call = service.getTestData();
//        call.enqueue(new retrofit2.Callback<TestData>() {
//            @Override
//            public void onResponse(retrofit2.Call<TestData> call, retrofit2.Response<TestData> response) {
//                TestData testData = response.body();
//                Log.i("------testgetData------", testData.getList().getRows().get(2).toString());
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<TestData> call, Throwable t) {
//
//            }
//        });
//    }

//    private void testgetData1() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://39.106.173.47/filemgt_test/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        GoodsService service = retrofit.create(GoodsService.class);
//        retrofit2.Call<TestData1> call = service.getTestData1();
//        call.enqueue(new retrofit2.Callback<TestData1>() {
//            @Override
//            public void onResponse(retrofit2.Call<TestData1> call, retrofit2.Response<TestData1> response) {
//                TestData1 testData1 = response.body();
//                Log.i("===testgetData1===", testData1.getList().toString());
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<TestData1> call, Throwable t) {
//
//            }
//        });
//
//    }

//    private void testgetData2() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://39.106.173.47/filemgt_test/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        GoodsService service = retrofit.create(GoodsService.class);
//        retrofit2.Call<TestData2> call = service.getTestData2("admin", 123456);
//        call.enqueue(new retrofit2.Callback<TestData2>() {
//            @Override
//            public void onResponse(retrofit2.Call<TestData2> call, retrofit2.Response<TestData2> response) {
//                TestData2 ts = response.body();
//                Log.i("===testgetData2===", ts.getUser().toString());
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<TestData2> call, Throwable t) {
//            }
//        });
//    }

//    private void testgetData3() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://japi.juhe.cn/joke/content/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        GoodsService service = retrofit.create(GoodsService.class);
//        Map<String, String> params = new HashMap<>();
//        params.put("key", "c037fdc5bbb9e640d6b5a701dcb11441");
//        params.put("page", "1");
//        params.put("pageSize", "10");
//        params.put("sort", "asc");
//        params.put("time", "1418745237");
//        //params.entrySet(params);
//        retrofit2.Call<TestData3> call = service.getTestData3(params);
//        call.enqueue(new retrofit2.Callback<TestData3>() {
//            @Override
//            public void onResponse(retrofit2.Call<TestData3> call, retrofit2.Response<TestData3> response) {
//                TestData3 testData3 = response.body();
//                for (int i = 0; i < 20; i++) {
//                    Log.i("====testgetData3====", testData3.getResult().getData().get(i).toString());
//                }
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<TestData3> call, Throwable t) {
//
//            }
//        });
//
//    }

//    private void testGetData4() {
//        final DbUtils dbUtils = new DbUtils(this);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://t.weather.sojson.com/api/weather/city/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        GoodsService service = retrofit.create(GoodsService.class);
//        retrofit2.Call<TestWeather> call = service.getTestData4();
//        call.enqueue(new retrofit2.Callback<TestWeather>() {
//            @Override
//            public void onResponse(retrofit2.Call<TestWeather> call, retrofit2.Response<TestWeather> response) {
//                //请求成功
//                TestWeather tw = response.body();
//                Log.i("====zzzzzz=", tw.toString());
//                Log.i("====zzzzzz=", "--------------------------------------------------------");
//                for (TestWeather.DataBean.ForecastBean w:tw.getData().getForecast()
//                     ) {
//                    dbUtils.add(new WeatherEntity(null,w.getDate(),w.getSunrise(),w.getHigh(),w.getLow(),w.getSunset(),w.getAqi(),w.getYmd(),w.getWeek(),w.getFx(),w.getFl(),w.getType(),w.getNotice()));
//                }
//            }
//        @Override
//        public void onFailure (Call < TestWeather > call, Throwable t){
//            Log.i("====", t.toString());
//        }
//    });
//
//}

}
