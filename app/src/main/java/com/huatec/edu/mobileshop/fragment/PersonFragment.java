package com.huatec.edu.mobileshop.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.activity.ChangePWDActivity;
import com.huatec.edu.mobileshop.activity.LoginActivity;
import com.huatec.edu.mobileshop.activity.MainActivity;
import com.huatec.edu.mobileshop.util.ImageLoaderManager;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class PersonFragment extends BaseFragment {
    /**
     * 2添加常量
     */
    private final int MY_FAVORITE = 1;
    private final int MY_ORDER = 2;
    private final int MY_ADDRESS = 3;
    private final int MY_ACCOUNT_BEFORE = 4;
    private final int MY_ACCOUNT_AFTER = 5;
    /**
     * 1初始化控件与按键监听
     */
    //用户头像
    @BindView(R.id.user_img_view)
    ImageView userImgView;
    //用户名
    @BindView(R.id.user_name)
    TextView userName;
    //用户级别
    @BindView(R.id.user_level)
    TextView userLevel;
    //登陆时的布局
    @BindView(R.id.personal_for_login)
    RelativeLayout personalForLogin;
    @BindView(R.id.personal_for_welcome)
    TextView personalForWelcome;
    @BindView(R.id.personal_login)
    Button personalLogin;
    @BindView(R.id.personal_click_to_login)
    LinearLayout personalClickToLogin;
    @BindView(R.id.personal_for_not_login)
    RelativeLayout personalForNotLogin;
    @BindView(R.id.personal_head)
    RelativeLayout personalHeader;
    @BindView(R.id.my_order_image)
    ImageView myOrderImage;
    @BindView(R.id.my_order_text)
    TextView myOrderText;
    @BindView(R.id.my_order_arrow)
    ImageView myOrderArrow;
    @BindView(R.id.person_my_order)
    RelativeLayout personMyOrder;
    @BindView(R.id.my_collect_image)
    ImageView myCollectImage;
    @BindView(R.id.my_collect_text)
    TextView myCollectText;
    @BindView(R.id.my_collect_arrow)
    ImageView myCollectArrow;
    @BindView(R.id.my_collect)
    RelativeLayout myCollect;
    @BindView(R.id.my_address_image)
    ImageView myAddressImage;
    @BindView(R.id.my_address_text)
    TextView myAddressText;
    @BindView(R.id.my_address_arrow)
    ImageView myAddressArrow;
    @BindView(R.id.my_address)
    RelativeLayout myAddress;
    @BindView(R.id.my_account_image)
    ImageView myAccountImage;
    @BindView(R.id.my_account_text)
    TextView myAccountText;
    @BindView(R.id.my_account_arrow)
    ImageView myAccountArrow;
    @BindView(R.id.my_account)
    RelativeLayout myAccount;
    @BindView(R.id.my_order_layout)
    LinearLayout myOrderLayout;
    @BindView(R.id.person_main)
    RelativeLayout relativeLayout;

    Unbinder unbinder;
    private MainActivity mainActivity;
    private ProgressDialog progressDialog;
    public Integer person_main = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_person, null);
        unbinder = ButterKnife.bind(this, view);
        mainActivity = (MainActivity) this.getActivity();
        init();
        return view;
    }

    @Override
    public void onResume() {
        init();
        super.onResume();
    }

    /*@Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }*/

    @OnClick({R.id.personal_login, R.id.person_my_order, R.id.my_collect, R.id.my_address, R.id.my_account, R.id.person_logout_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_login:
                //登录
                startActivity(new Intent(mainActivity, LoginActivity.class));
                break;
            case R.id.person_my_order://我的订单
                Toast.makeText(mainActivity,"我的订单",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_collect://我的收藏
                Toast.makeText(mainActivity,"我的收藏",Toast.LENGTH_SHORT).show();
                relativeLayout.setVisibility(View.INVISIBLE);
                break;
            case R.id.my_address://我的地址
                Toast.makeText(mainActivity,"我的地址",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_account: //修改密码
                if (mainActivity.isLogin()) {
                    startActivityForResult(new Intent(mainActivity, ChangePWDActivity.class), MY_ACCOUNT_AFTER);
                    return;
                }
                startActivityForResult(new Intent(mainActivity, LoginActivity.class), MY_ACCOUNT_BEFORE);
                break;
            case R.id.person_logout_layout://退出登录
                /**
                 * 后期会提供更好的自定义Dialog
                 */
                new AlertDialog.Builder(mainActivity)
                        .setTitle("退出登录")
                        .setMessage("您确认要退出登录吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                logout();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create().show();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != Activity.RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case MY_ORDER:
                break;
            case MY_FAVORITE:
                break;
            case MY_ACCOUNT_BEFORE:
                //没有登陆时候修改密码，修改密码后进行登陆
                if (resultCode == Activity.RESULT_OK && data.getBooleanExtra("logined", false)) {
                    Intent intent = new Intent(mainActivity, ChangePWDActivity.class);
                    startActivityForResult(intent, MY_ACCOUNT_AFTER);
                }
                break;
            case MY_ACCOUNT_AFTER:
                //登陆时修改密码，修改完毕后进行登陆
                if (resultCode == Activity.RESULT_OK) {
                    startActivity(new Intent(mainActivity, LoginActivity.class));
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void init() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", 0);
        String username = sharedPreferences.getString("uname", "");
        if (TextUtils.isEmpty(username)) {//没登录
            personalForLogin.setVisibility(View.GONE);
            personalForNotLogin.setVisibility(View.VISIBLE);
            myOrderLayout.setVisibility(View.GONE);
        } else {
            personalForLogin.setVisibility(View.VISIBLE);
            personalForNotLogin.setVisibility(View.GONE);
            myOrderLayout.setVisibility(View.VISIBLE);
            userName.setText(username);
            String image = sharedPreferences.getString("image", "");
            if (!TextUtils.isEmpty(image)) {
                ImageLoader.getInstance().displayImage(image, userImgView, ImageLoaderManager.product_options);
            }
        }
    }

    //退出登录
    private void logout() {
        SharedPreferences.Editor localEditpr = mainActivity.getSharedPreferences("user", 0).edit();
        localEditpr.remove("member_id");
        localEditpr.remove("uname");
        localEditpr.remove("email");
        localEditpr.remove("image");
        localEditpr.commit();//
        init();
        Toast.makeText(mainActivity, "退出登录成功", Toast.LENGTH_SHORT).show();
    }
}
