package com.husheng.riji.husshen2.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.utils.SuitScreen;

public class AlipayBindActivity   extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alipay_bind);//接受消息界面


        SuitScreen ss=new SuitScreen();
        ss.setWindows(getWindow());


        ImageView return_button=findViewById(R.id.alipay_return);
        return_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}