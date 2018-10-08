package com.husheng.riji.husshen2.ui;

import android.app.Activity;
import android.os.Bundle;

import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.utils.SuitScreen;

public class NoviceIntroductionActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novice_introduction);//激活搜索页面
        SuitScreen ss=new SuitScreen();
        ss.setWindows(getWindow());

    }}