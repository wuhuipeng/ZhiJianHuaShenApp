package com.husheng.riji.husshen2.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.husheng.riji.husshen2.R;

public class SpecialDialog extends Dialog {
    private Button positiveButton, negativeButton;
    private TextView contenttv;

    public SpecialDialog(Context context) {
        super(context,R.style.specialdialog);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.specialdialoglayout, null);  //通过LayoutInflater获取布局
        contenttv = view.findViewById(R.id.title);
        positiveButton = view.findViewById(R.id.acceptbtn);
        negativeButton = view.findViewById(R.id.refusebtn);
        setContentView(view);  //设置view
    }
    //设置内容
    public void setContent(String content) {
        contenttv.setText(content);
    }
    //确定按钮监听
    public void setOnPositiveListener(View.OnClickListener listener){
        positiveButton.setOnClickListener(listener);
    }

    //否定按钮监听
    public void setOnNegativeListener(View.OnClickListener listener){
        negativeButton.setOnClickListener(listener);
    }
}
