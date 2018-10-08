package com.husheng.riji.husshen2.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.utils.SuitScreen;

public class ReviseNicknameActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.revise_nickname);//接受消息界面

        SuitScreen ss=new SuitScreen();
        ss.setWindows(getWindow());



    }
}