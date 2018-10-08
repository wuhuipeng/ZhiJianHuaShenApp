package com.husheng.riji.husshen2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TestOkhttp3 {
    /**
     * 测试 okhttp get 方法
     */

    @Test
    public void testGet() {
        //创建Okttp对象
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://httpbin.org/get?id=id")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println("" + response.body().string());
        } catch (IOException e) {

            e.printStackTrace();
        }


    }

    /**
     * 测试ohttp的post请求方法
     */
    @Test
    public void testPost() {

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, "{\"name\"}: \"dalimao\"}");

        Request request = new Request.Builder()
                .url("http://httpbin.org/get?id=id")
                .post(body)//请求体
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println("" + response.body().string());
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    /**
     * 测试拦截器
     */
    @Test
    public void testinterceptor() {
           //定义拦截器
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                long start = System.currentTimeMillis();
                Request request = chain.request();
                Response response = chain.proceed(request);
                long end = System.currentTimeMillis();
                System.out.println("interceptor: coost time =" + (end - start));
                return response;
            }

        };

         //测试拦截器
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Request request = new Request.Builder()
                .url("http://httpbin.org/get?id=id")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println("" + response.body().string());
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
    /**
     *
     * 测试缓存
     */
    @Test
    public  void testCache(){
        Cache cache=new Cache(new File("cache.cache"), 1024*1024);
        OkHttpClient client = new OkHttpClient.Builder().cache(cache).build();
        Request request = new Request.Builder()
                .url("http://httpbin.org/get?id=id")
                .build();
        try {
            Response response = client.newCall(request).execute();
            Response responseseCache= response.cacheResponse();
            Response responseNet =response.networkResponse();
            if(responseseCache!=null){
                //从缓存中取出
                System.out.println("response for  cache");
            }
            if(responseNet != null){
                System.out.println("response for net");
            }
            System.out.println("" + response.body().string());
        } catch (IOException e) {

            e.printStackTrace();
        }




        }

}
