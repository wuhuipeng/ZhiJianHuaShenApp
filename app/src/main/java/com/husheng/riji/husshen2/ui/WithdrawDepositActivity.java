package com.husheng.riji.husshen2.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.utils.SuitScreen;
import com.suke.widget.SwitchButton;

public class WithdrawDepositActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SuitScreen ss=new SuitScreen();
        ss.setWindows(getWindow());


        setContentView(R.layout.withdraw_deposit);

    }
}
