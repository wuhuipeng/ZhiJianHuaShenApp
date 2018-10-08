package com.husheng.riji.husshen2.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.utils.SuitScreen;

public class RegisterOrLoginActivity extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_or_login);//激活搜索页面


        SuitScreen ss=new SuitScreen();
        ss.setWindows(getWindow());



        Button login_button=findViewById(R.id.login_button);
        login_button.setOnClickListener(this);

        Button register_button=findViewById(R.id.register_button);
        register_button.setOnClickListener(this);

        ImageView login_register_finish_view=findViewById(R.id.login_or_register_finish_view);
        login_register_finish_view.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_or_register_finish_view:
                finish();

                break;
            case R.id.register_button:
                Intent intent =new Intent(RegisterOrLoginActivity.this, RegisterInivateActivity.class);
                startActivity(intent);

                break;
            case R.id.login_button:
                Intent intent2 =new Intent(RegisterOrLoginActivity.this, LoginActivity.class);
            startActivity(intent2);
            break;


        }
    }




}
