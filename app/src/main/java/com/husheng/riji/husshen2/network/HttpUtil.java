package com.husheng.riji.husshen2.network;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import com.google.gson.Gson;
import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.bean.Goods;
import com.husheng.riji.husshen2.bean.Goodses;
import com.husheng.riji.husshen2.utils.SuitScreen;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

public class HttpUtil{





    public static void getHttp(String goodName, String key, Goodses b) {

        OkHttpClient mOkHttpClient = new OkHttpClient();
        Request.Builder requestBuilder = new Request.Builder().url("http://api.vephp.com/super?vekey=" + key + "&para=" + goodName);
        //可以省略，默认是GET请求
        requestBuilder.method("GET", null);
        Request request = requestBuilder.build();
       Call mcall = mOkHttpClient.newCall(request);//
        mcall.enqueue(new Callback() {
           @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }



            @Override
            public void onResponse(Call call, Response response) throws IOException {


                String json1 = response.body().string();
                json1 =  json1.replaceAll("\"coupon_info\":\\[\\],", "");
                Gson gson = new Gson();
                Goodses b =gson.fromJson(json1, Goodses.class);
                System.out.println("size: "+b.getResult_list().size());

                for(Goods gs : b.getResult_list())
                {
                    System.out.println("title: "+gs.getTitle());

                }
           }
});


//        //4.同步调用会阻塞主线程,这边在子线程进行
//        new Thread(new Runnable() {
//            public void run() {
//                try {
//                    //同步调用,返回Response,会抛出IO异常
//
//                    Response response = call.execute();
//
//                    String json1 = response.body().string();
//                    json1 = json1.replaceAll("\"coupon_info\":\\[\\],", "");
//                    Gson gson = new Gson();
//                    a = gson.fromJson(json1, Goodses.class);
//                    System.out.println("size: " + a.getResult_list().size());
//                    for (Goods gs : a.getResult_list()) {
//                        System.out.println("title: " + gs.getTitle());
//                    }
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();





    }





    public static void main(String args[]) {
        HttpUtil bb=new HttpUtil();



    }




}














//        mcall.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.d(TAG, "onFailure: ");
//            }
//
//
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//
//                String json1 = response.body().string();
//                json1 =  json1.replaceAll("\"coupon_info\":\\[\\],", "");
//                Gson gson = new Gson();
//                a =gson.fromJson(json1, Goodses.class);
//                System.out.println("size: "+a.getResult_list().size());
//                for(Goods gs : a.getResult_list())
//                  {
//                       System.out.println("title: "+gs.getTitle());
//                  }
//           }
//
//
//        });