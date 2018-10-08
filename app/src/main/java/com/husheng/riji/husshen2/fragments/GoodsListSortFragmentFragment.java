package com.husheng.riji.husshen2.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.bean.Goodses;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.IOException;

import adapter.GoodsListSortAdapter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GoodsListSortFragmentFragment  extends Fragment {
    private String initurl="http://api.vephp.com/super?vekey=V00000129Y78348127&para=%E7%AC%94%E8%AE%B0%E6%9C%AC";
    private RecyclerView rvList;
    private GoodsListSortAdapter sortadapter;
    private Handler mHandler,nHandler;
    private SmartRefreshLayout srfresh;
    private int page=2;
    private int maxPage;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                String js = (String) msg.obj;
                js = js.replaceAll("\"coupon_info\":\\[\\],", "");


                Gson gson=new Gson();
                Goodses bean=gson.fromJson(js,Goodses.class);


                sortadapter.setData(bean);
            }
        }
    };

    Handler handler2=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                String js = (String) msg.obj;
                js = js.replaceAll("\"coupon_info\":\\[\\],", "");


                Gson gson=new Gson();
                Goodses bean=gson.fromJson(js,Goodses.class);

                sortadapter.loadmore(bean);
            }
        }
    };




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.goods_sort_list, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData(1,initurl);
        aboutAapter();

        //注册滚动图


    }

    private void aboutAapter() {
        sortadapter = new GoodsListSortAdapter(getContext());
//        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        // 设置布局管理一条数据占用几行，如果是头布局则头布局自己占用一行
        rvList.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        rvList.setLayoutManager(gridLayoutManager);


        //  rvList.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        //layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置Adapter
        rvList.setAdapter(sortadapter);
        //设置 Header 为 贝塞尔雷达 样式
        srfresh.setRefreshHeader(new ClassicsHeader(getContext()));
        //设置 Footer 为 球脉冲 样式
        srfresh.setRefreshFooter(new ClassicsFooter(getContext()));
        srfresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                //延时展示，延时2秒
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initData(1,initurl);
                        //  recycleAdapter.refresh(mDatas);
                        refreshlayout.finishRefresh();
                    }
                },500);

            }
        });
        srfresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(final RefreshLayout refreshlayout) {

                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        refresbData(page, initurl);
                        page++;
                        refreshlayout.finishLoadMore();
                    }

                },500);
            }
        });


        srfresh.setEnableLoadMore(true);
        srfresh.autoRefresh();
    }

    private void initData(int page,String url) {


        mHandler=new Handler();  OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(url+"&page="+page).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("onFailure", "请求失败");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.body() != null && response.isSuccessful()){
                    String str=response.body().string();
                    Message message=new Message();
                    message.what=1;
                    message.obj=str;
                    handler.sendMessage(message);
                }
            }
        });



    }

    private void refresbData(int page,String url) {

        nHandler=new Handler();  OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(url+"&page="+page).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("onFailure", "请求失败");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.body() != null && response.isSuccessful()){
                    String str=response.body().string();
                    Message message=new Message();
                    message.what=1;
                    message.obj=str;
                    handler2.sendMessage(message);
                }
            }
        });
    }
    private void initView() {
        rvList = getView().findViewById(R.id.sort_recycler);
        srfresh = getView().findViewById(R.id.sort_refresh);

    }
}

