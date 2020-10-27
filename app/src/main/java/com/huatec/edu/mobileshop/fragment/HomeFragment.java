package com.huatec.edu.mobileshop.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.activity.GoodsActivity;
import com.huatec.edu.mobileshop.activity.LoginActivity;
import com.huatec.edu.mobileshop.activity.MainActivity;
import com.huatec.edu.mobileshop.util.NetworkUtils;
import com.huatec.edu.mobileshop.view.MyWebView;

public class HomeFragment extends BaseFragment {

    /**
     * 优化MainActivity
     * 由于我们首页主要是用于显示商品列表和刷新，这些个功能均需要网络支持，为此我们需要添加一个公共的判断网络状态的方法
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    private static final String TAG = "HomeFragment";
    private MainActivity mainActivity;
    private final int SEARCH_ACTIVITY = 1;
    private MyWebView myWebView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView searchTV;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        mainActivity = (MainActivity) getActivity();
        //搜索按钮功能
        searchTV = view.findViewById(R.id.home_search);
        searchTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainActivity, "此功能待解锁，请充值VIP尽享尊贵特权。。。", Toast.LENGTH_SHORT).show();
            }
        });
        myWebView = view.findViewById(R.id.webView);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        initMyWebView(view);
        initSwipeRefreshLayout();

//        ImageView imageView = view.findViewById(R.id.imgtest);
//        GridView gridView = view.findViewById(R.id.gridView);
//        gridView.setAdapter(new HomeAdapter(getActivity()));//通过设置适配器实现网格内布局
//        ImageLoader.getInstance().displayImage("http://pic15.nipic.com/20110628/1369025_192645024000_2.jpg",,ImageLoaderManager.product_options);
        return view;
    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //这边是刷新功能，刷新功能是否可以用，我们需要先判断网络是否正常
                if (NetworkUtils.isNetworkAvailable(mainActivity)) {
                    myWebView.reload();
                } else {
                    swipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(mainActivity, "当前网络不可用",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 初始化WebView
     * @param view
     */
    private void initMyWebView(View view) {
        /**
         * 这边需要创建一个连接对象WebViewClient
         */
        myWebView.setWebViewClient(new JWebViewClient());
        myWebView.addJavascriptInterface(this, "app");
        myWebView.setVerticalScrollBarEnabled(false);//设置无垂直方向的ScrollBar
        myWebView.setHorizontalScrollBarEnabled(false);//设置无水平方向的ScrollBar
        WebSettings settings = myWebView.getSettings();
        settings.setJavaScriptEnabled(true); //设置启用javascript脚本
        settings.setSupportZoom(false); //设置不支持缩放
        settings.setBuiltInZoomControls(false); //设置不启用内置缩放装置
        /*
        * 设置滚动
         */

        myWebView.setOnCustomScrollChanger(new MyWebView.IWebViewScroll() {

            @Override
            public void onTop() {

            }

            @Override
            public void notOnTop() {

            }
        });
        /**
         * 点击后退按钮
         */
        myWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction()==KeyEvent.ACTION_DOWN){
                    if(keyCode==KeyEvent.KEYCODE_BACK&&myWebView.canGoBack()){
                        myWebView.goBack();
                        return true;
                    }

                }
                return false;
            }

        });
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl("");
                return  true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                myWebView.loadUrl("");
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                swipeRefreshLayout.setRefreshing(true);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        myWebView.loadUrl("https://www.baidu.com/");
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //预留功能，搜索功能返回后的操作
        if (requestCode == SEARCH_ACTIVITY) {

        }
    }

    /**
     * 内部类，具体功能待完成
     */
    private class JWebViewClient extends WebViewClient {
        //以下方法都是继承后我们重写的
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            view.getSettings().setDefaultTextEncodingName("UTF-8");
            super.onReceivedError(view, request, error);
            view.loadDataWithBaseURL("", "", "", "", "");
        }
    }

    //通过注解实现javascript的方法
    @JavascriptInterface
    public void changeTab(final int index) {
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainActivity.changeTab(index);
            }
        });
    }

    public void showGoods(final int goodsId) {
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 该方法为实现显示商品详情方法，此方法几乎在所有的acitvity中都有可能被使用，为了简化代码
                 * 我们将该方法进行优化和实现。通过在父类中实现该方法就可以实现前面说的效果
                 */
                mainActivity.showGoods(goodsId);
            }
        });
    }

    /**
     * 以下两个方法，我们在写的时候都是将预实现功能或者activity先添加，通过这样我们也能尽快知道哪些功能是我们后续需要实现的
     */
    @JavascriptInterface
    public void showGroupbuy(final int goodsId, final int groupbuy_id) {
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //这边是跳转到商品界面，这边我们先临时建一个
                Intent intent = new Intent(mainActivity, GoodsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);//设置启动时不使用动画
                intent.putExtra("goods_id", goodsId);
                intent.putExtra("groupbuy_id", groupbuy_id);
                startActivity(intent);
            }
        });
    }

    @JavascriptInterface
    public void myorder() {
        //缺少登录
        startActivity(new Intent(mainActivity, LoginActivity.class));
        Toast.makeText(mainActivity, "请先登录后再进行操作！", Toast.LENGTH_SHORT).show();
    }
    //自定义适配器（通过继承BaseAdapter）
//    class HomeAdapter extends BaseAdapter {
//
//        String url[] = {"http://pic15.nipic.com/20110628/1369025_192645024000_2.jpg",
//                "http://pic1.win4000.com/wallpaper/9/5450ae2fdef8a.jpg",
//                "http://pic37.nipic.com/20140113/8800276_184927469000_2.png",
//                "http://b.zol-img.com.cn/desk/bizhi/image/3/960x600/1369964516723.jpg",
//                "http://k.zol-img.com.cn/sjbbs/7692/a7691515_s.jpg",
//                "http://pic32.nipic.com/20130823/13339320_183302468194_2.jpg",
//                "http://pic40.nipic.com/20140412/18428321_144447597175_2.jpg",
//                "http://pic37.nipic.com/20140110/17563091_221827492154_2.jpg",
//                "http://pic29.nipic.com/20130517/9252150_140653449378_2.jpg",
//                "http://pic36.nipic.com/20131129/8821914_111419739001_2.jpg"};
//
//        private Context mContext;
//
//        public HomeAdapter(Context context) {
//            mContext = context;
//        }
//
//        @Override
//        public int getCount() {
//            return url.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return url[position];
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
//            ImageView imageView = convertView.findViewById(R.id.iv);
//            ImageLoader.getInstance().displayImage(url[position],imageView,ImageLoaderManager.product_options);
//            return convertView;
//        }
//    }

}
