package com.huatec.edu.mobileshop.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
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
import com.huatec.edu.mobileshop.entity.MemberEntity;
import com.huatec.edu.mobileshop.http.presenter.MemberPresenter;
import com.huatec.edu.mobileshop.util.ProgressDialogSub;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.common_title)
    RelativeLayout commonTitle;
    @BindView(R.id.login_page_input_name)
    TextView loginPageInputName;
    @BindView(R.id.login_input_name)
    EditText loginInputName;
    @BindView(R.id.login_page_input_name_layout)
    RelativeLayout loginPageInputNameLayout;
    @BindView(R.id.login_driver_line0)
    View loginDriverLine0;
    @BindView(R.id.login_page_input_email)
    TextView loginPageInputEmail;
    @BindView(R.id.login_input_email)
    EditText loginInputEmail;
    @BindView(R.id.login_page_input_email_layout)
    RelativeLayout loginPageInputEmailLayout;
    @BindView(R.id.login_driver_line)
    View loginDriverLine;
    @BindView(R.id.login_page_input_password)
    TextView loginPageInputPassword;
    @BindView(R.id.login_input_password)
    EditText loginInputPassword;
    @BindView(R.id.login_page_input_password_layout)
    RelativeLayout loginPageInputPasswordLayout;
    @BindView(R.id.login_driver_line1)
    View loginDriverLine1;
    @BindView(R.id.login_page_input_repassword)
    TextView loginPageInputRepassword;
    @BindView(R.id.login_input_repassword)
    EditText loginInputRepassword;
    @BindView(R.id.login_page_input_repassword_layout)
    RelativeLayout loginPageInputRepasswordLayout;
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
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.title_back, R.id.register_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.register_button:
                register();
                break;
        }
    }

    private void register() {
        String username = loginInputName.getText().toString().trim();
        String email = loginInputEmail.getText().toString().trim();
        String password = loginInputPassword.getText().toString().trim();
        String rePassword = loginInputRepassword.getText().toString().trim();
        Boolean s1 = checkUsername(username);
        Boolean s2 = false;
        Boolean s3 = false;
        if (s1 == true) {
             s2 = checkEmail(email);
            if (s2 == true) {
                 s3 = checkPWD(password, rePassword);
            }
        }
        if (s1 == true && s2 == true && s3 == true) {
            MemberPresenter.register(new ProgressDialogSub<MemberEntity>(this) {
                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    Log.e("xxx",e.getMessage());
                }

                @Override
                public void onNext(MemberEntity memberEntity) {
                    SharedPreferences.Editor spEditor = getSharedPreferences("user", 0).edit();
                    spEditor.putInt("member_id", memberEntity.getMemberId());
                    spEditor.putString("uname", memberEntity.getUname());
                    spEditor.putString("email", memberEntity.getEmail());
                    spEditor.putString("image", memberEntity.getImage());
                    spEditor.commit();
                    Intent intent = new Intent();
                    intent.putExtra("logined", true);
                    setResult(AdActivity.RESULT_OK, intent);
                    finish();
                }
            }, username, password, email);
        }

    }

    /**
     * 验证邮箱
     *
     * @param password
     * @param rePassword
     */
    private Boolean checkPWD(String password, String rePassword) {
        if (TextUtils.isEmpty(password) || TextUtils.isEmpty(rePassword)) {
            Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!password.equals(rePassword)) {
            Toast.makeText(RegisterActivity.this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * 邮箱验证
     *
     * @param email
     */
    private Boolean checkEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(RegisterActivity.this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        //通过正则表达式来验证邮箱格式
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            Toast.makeText(RegisterActivity.this, "邮箱格式不正确！", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * 用户名验证
     *
     * @param username
     */
    private Boolean checkUsername(String username) {
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(RegisterActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (username.length() < 4 || username.length() > 20) {
            Toast.makeText(RegisterActivity.this, "用户名长度为4-20位", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (username.contains("@")) {
            Toast.makeText(RegisterActivity.this, "用户名不能包含特殊字符！", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
