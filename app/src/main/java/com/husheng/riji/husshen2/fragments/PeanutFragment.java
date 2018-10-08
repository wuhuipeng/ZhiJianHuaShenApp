package com.husheng.riji.husshen2.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.husheng.riji.husshen2.ui.PeanutVipActivity;
import com.husheng.riji.husshen2.R;


public class PeanutFragment extends  Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_peanut, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        WebView webview_peanut=getView().findViewById(R.id.webviewPeanut);
        ProgressBar progressBar=getView().findViewById(R.id.progressBar);
        webview_peanut.getSettings().setJavaScriptEnabled(true);
        webview_peanut.loadUrl("https://bag.tmall.com/?spm=875.7931836/B.category2016012.3.24934265R6opoB&acm=lb-zebra-148799-667863.1003.4.708026&scm=1003.4.lb-zebra-148799-667863.OTHER_14561689118972_708026");
        webview_peanut.setWebViewClient(new WebViewClient(){
            //网页加载开始时调用，显示加载提示旋转进度条




        });
    }



}
