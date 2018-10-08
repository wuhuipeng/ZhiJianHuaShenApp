package com.husheng.riji.husshen2.ui;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.utils.SuitScreen;

public class PeanutVipActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_peanut);//接受消息界面

        SuitScreen ss=new SuitScreen();
        ss.setWindows(getWindow());


        WebView webview_peanut=findViewById(R.id.webviewPeanut);
        ProgressBar progressBar=findViewById(R.id.progressBar);
        webview_peanut.getSettings().setJavaScriptEnabled(true);
        webview_peanut.loadUrl("https://bag.tmall.com/?spm=875.7931836/B.category2016012.3.24934265R6opoB&acm=lb-zebra-148799-667863.1003.4.708026&scm=1003.4.lb-zebra-148799-667863.OTHER_14561689118972_708026");
        webview_peanut.setWebViewClient(new WebViewClient(){
            //网页加载开始时调用，显示加载提示旋转进度条

        });
    }
}
