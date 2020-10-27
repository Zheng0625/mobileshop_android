package com.huatec.edu.mobileshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.entity.HttpResult;
import com.huatec.edu.mobileshop.http.presenter.MemberPresenter;
import com.huatec.edu.mobileshop.util.ProgressDialogSub;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FindPWDActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.common_title)
    RelativeLayout commonTitle;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.login_editor_layout)
    RelativeLayout loginEditorLayout;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.login_relative)
    RelativeLayout loginRelative;
    @BindView(R.id.login_scroller)
    ScrollView loginScroller;
    @BindView(R.id.login_layout)
    LinearLayout loginLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pwd);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.title_back, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.btn_submit:
                changePassword();
                break;
        }
    }

    //找回密码
    private void changePassword() {
        String email = etEmail.getText().toString().trim();
        if ("".equals(email)||TextUtils.isEmpty(email)) {
            Toast.makeText(FindPWDActivity.this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        //通过正则表达式来验证邮箱格式
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            Toast.makeText(FindPWDActivity.this, "邮箱格式不正确！", Toast.LENGTH_SHORT).show();
            return;
        }
        //联网请求
        MemberPresenter.findPassword(new ProgressDialogSub<HttpResult>(this) {
            @Override
            public void onNext(HttpResult httpResult) {
                if (httpResult.getStatus() == 0) {
                    Toast.makeText(FindPWDActivity.this, "操作成功，请登录注册邮箱使用新的密码进行登录", Toast.LENGTH_LONG).show();
                    //重新登录
                    startActivity(new Intent(FindPWDActivity.this, LoginActivity.class));
                    finish();
                } else {
                    Toast.makeText(FindPWDActivity.this, httpResult.getMsg(), Toast.LENGTH_SHORT).show();
                }

            }

        }, email);
    }
}
