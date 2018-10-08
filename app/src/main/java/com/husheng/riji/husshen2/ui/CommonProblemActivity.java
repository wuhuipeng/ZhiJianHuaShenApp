package com.husheng.riji.husshen2.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.utils.SuitScreen;

public class CommonProblemActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_problem);//常见问题界面

        SuitScreen ss=new SuitScreen();
        ss.setWindows(getWindow());

        WebView webview=findViewById(R.id.problem_webview);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("http://www.11012345.com/html/5236783359.html");
        webview.setWebViewClient(new WebViewClient(){
            //网页加载开始时调用，显示加载提示旋转进度条


        });
  /*      ImageView return_button_common_problem=findViewById(R.id.common_problem_view);
        return_button_common_problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/
    }
}