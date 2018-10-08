package com.husheng.riji.husshen2.ui;

import android.app.Activity;
import android.os.Bundle;

import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.utils.SuitScreen;

public class OfficialNoticeActivity extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.official_notice);//接受消息界面
        SuitScreen ss=new SuitScreen();
        ss.setWindows(getWindow());



    }
}
