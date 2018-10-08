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

public class MessageNoticeActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SuitScreen ss=new SuitScreen();
        ss.setWindows(getWindow());

        setContentView(R.layout.message_notice);
        com.suke.widget.SwitchButton switchButton = findViewById(R.id.switch_button);

        switchButton.setChecked(true);
        switchButton.isChecked();
        switchButton.toggle();     //switch state
        switchButton.toggle(false);//switch without animation
        switchButton.setShadowEffect(true);//disable shadow effect
        switchButton.setEnabled(true);//disable button
        switchButton.setEnableEffect(false);//disable the switch animation
        switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                //TODO do your job


            }
        });
    }
}
