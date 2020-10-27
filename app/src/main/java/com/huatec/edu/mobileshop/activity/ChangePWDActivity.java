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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePWDActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.common_title)
    RelativeLayout commonTitle;
    @BindView(R.id.login_page_input_name)
    TextView loginPageInputName;
    @BindView(R.id.password_old_input_name)
    EditText passwordOldInputName;
    @BindView(R.id.login_page_input_name_layout)
    RelativeLayout loginPageInputNameLayout;
    @BindView(R.id.login_driver_line0)
    View loginDriverLine0;
    @BindView(R.id.login_page_input_email)
    TextView loginPageInputEmail;
    @BindView(R.id.password_new_input_name)
    EditText passwordNewInputName;
    @BindView(R.id.login_page_input_email_layout)
    RelativeLayout loginPageInputEmailLayout;
    @BindView(R.id.login_driver_line)
    View loginDriverLine;
    @BindView(R.id.login_page_input_password)
    TextView loginPageInputPassword;
    @BindView(R.id.repassword_new_input_name)
    EditText repasswordNewInputName;
    @BindView(R.id.login_page_input_password_layout)
    RelativeLayout loginPageInputPasswordLayout;
    @BindView(R.id.login_driver_line1)
    View loginDriverLine1;
    @BindView(R.id.login_driver_verification_line)
    View loginDriverVerificationLine;
    @BindView(R.id.login_editor_layout)
    RelativeLayout loginEditorLayout;
    @BindView(R.id.register_button)
    Button registerButton;
    @BindView(R.id.login_relative)
    RelativeLayout loginRelative;
    @BindView(R.id.login_scroller)
    ScrollView loginScroller;
    @BindView(R.id.login_layout)
    LinearLayout loginLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changge_password);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.title_back, R.id.register_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.register_button:
                changePassword();
                break;
        }
    }

    private void changePassword() {
        String old_password = passwordOldInputName.getText().toString().trim();
        String new_password = passwordNewInputName.getText().toString().trim();
        String re_new_password = repasswordNewInputName.getText().toString().trim();
        if (TextUtils.isEmpty(old_password)) {
            Toast.makeText(this,"旧密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(new_password)) {
            Toast.makeText(this,"新密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(re_new_password)) {
            Toast.makeText(this,"确认密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if (!new_password.equals(re_new_password)) {
            Toast.makeText(this,"两次输入的密码不一致",Toast.LENGTH_SHORT).show();
            return;
        }
        //联网请求
        MemberPresenter.changePassword(new ProgressDialogSub<HttpResult>(this) {
            @Override
            public void onNext(HttpResult httpResult) {
                if (httpResult.getStatus() == 0) {
                    Toast.makeText(ChangePWDActivity.this, "操作成功，请使用新的密码进行登录", Toast.LENGTH_LONG).show();
                    //重新登录
                    startActivity(new Intent(ChangePWDActivity.this, LoginActivity.class));
                    finish();
                } else {
                    Toast.makeText(ChangePWDActivity.this, httpResult.getMsg(), Toast.LENGTH_SHORT).show();
                }

            }

        }, "",old_password,new_password);
    }
}
