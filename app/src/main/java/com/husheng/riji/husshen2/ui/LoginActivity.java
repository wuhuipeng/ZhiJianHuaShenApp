package com.husheng.riji.husshen2.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.utils.EditTextUtils;
import com.husheng.riji.husshen2.utils.SuitScreen;

import Tools.CustomVideoView;

import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

        private CustomVideoView videoview;
        private Button btn_enter;
        private boolean ischeckpassword_status=true;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                // requestWindowFeature(Window.FEATURE_NO_TITLE);
                setContentView(R.layout.login);

                //冗余代码适配屏幕
                SuitScreen ss=new SuitScreen();
                ss.setWindows(getWindow());

                initView();
        }


        /**
         * 初始化
         */
        private void initView() {
                btn_enter = findViewById(R.id.btn_enter);
                btn_enter.setOnClickListener(this);

                videoview = findViewById(R.id.videoview);
                videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sport));

                //播放
                videoview.start();
                //循环播放
                videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                                videoview.start();
                        }
                });


                final EditText user_number_edit = findViewById(R.id.et_phone);
                final EditText user_passwd_edit = findViewById(R.id.et_pwd);
                user_passwd_edit.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

                View bt = findViewById(R.id.bt);
                View iv = findViewById(R.id.iv);

                EditTextUtils.clearButtonListener(user_number_edit, bt);
                EditTextUtils.clearButtonListener(user_passwd_edit, iv);

                ImageView loginreturn_view = findViewById(R.id.login_return_view);

                final ImageView pass_eye = findViewById(R.id.passwd_image_eye);
                pass_eye.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {

                                if (ischeckpassword_status) {
                                        user_passwd_edit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                                        pass_eye.setBackgroundResource(R.drawable.eye_open);
                                } else {
                                        user_passwd_edit.setTransformationMethod(PasswordTransformationMethod.getInstance());
                                        pass_eye.setBackgroundResource(R.drawable.eye_close);

                                }
                                ischeckpassword_status = !ischeckpassword_status;

                        }
                });

             TextWatcher password_change = new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                                if (user_passwd_edit.length() >=3
                                        ) {
                                        btn_enter.setBackgroundColor(WHITE);
                                    Toast.makeText( LoginActivity.this,"登录成功了", Toast.LENGTH_SHORT).show();

                                }

                        }
                };

               btn_enter.addTextChangedListener(password_change);

        }


        @Override
        public void onClick(View view) {
                switch (view.getId()) {
                        case R.id.btn_enter:
                                Intent intent =new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);

                                break;
                        case R.id.login_return_view:
                                finish();
                                break;

                }
        }

//

        @Override
        protected void onRestart() {
                super.onRestart();
                initView();
         }
//
//    //防止锁屏或者切出的时候，音乐在播放
//    @Override
//    protected void onStop() {
//        super.onStop();
//        videoview.stopPlayback();
//    }



}