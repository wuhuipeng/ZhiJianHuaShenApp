package com.husheng.riji.husshen2.fragments;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import adapter.HomeGoodsRecycleAdapter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import com.google.gson.Gson;
import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.bean.Goodses;
import com.husheng.riji.husshen2.ui.MessageActivity;
import com.husheng.riji.husshen2.ui.SearchWordsActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class HomeFragment extends Fragment {
    private String initurl="http://api.vephp.com/super?vekey=V00000129Y78348127&para=%E7%AC%94%E8%AE%B0%E6%9C%AC";
    private List<String> mDatas;
    private List<String> bannerPictures,smallBannerPicture;
    private RecyclerView rvList;
    private HomeGoodsRecycleAdapter recycleAdapter;
    private Handler mHandler,nHandler;
    private SmartRefreshLayout srfresh;
    private ImageView i;
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

               // maxPage=bean.getTotal_results()/10+1;
            //    maxPage=3;
                recycleAdapter.setData(bean);
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
                //   recycleAdapter.setData(bean);
                recycleAdapter.loadmore(bean);
            }
        }
    };
    //获取状态栏高度
    public static int getStatusBarHeight(Context context) {

        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        ImageView messageiv = getView().findViewById(R.id.MessageView);

        messageiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //在按钮响应//MainActivity.this 为当前窗体，LoginActivity.class 为跳到的第二个窗体
                Intent intent = new Intent(getActivity(), MessageActivity.class);
                startActivity(intent);
                //   Toast.makeText(getActivity(), "success2", 0).show();
            }
        });
        RecyclerView totalview=getView().findViewById(R.id.rv_list);
        final com.youth.banner.Banner  banner=getView().findViewById(R.id.banner);
        final LinearLayout search_view=getView().findViewById(R.id.search_view);
//        totalview.setOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                //防止item乱跳
//                //staggeredGridLayoutManager.invalidateSpanAssignments();
//            }

//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                //滑动的距离
//                mDistanceY += dy;
//                //toolbar的高度
//                int toolbarHeight = search_view.getBottom();
//
//                //当滑动的距离 <= toolbar高度的时候，改变Toolbar背景色的透明度，达到渐变的效果
//                if (mDistanceY <= toolbarHeight) {
//                    float scale = (float) mDistanceY / toolbarHeight;
//                    float alpha = scale * 255;
//                    search_view.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
//                } else {
//                    //将标题栏的颜色设置为完全不透明状态
//                    search_view.setBackgroundResource(R.color.white);
//                }
//            }
//        });


        TextView searchView = getView().findViewById(R.id.textViewSearch);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //在按钮响应//MainActivity.this 为当前窗体，LoginActivity.class 为跳到的第二个窗体
                Intent intent = new Intent(getActivity(), SearchWordsActivity.class);
                startActivity(intent);

            }
        });





        initData(1,initurl);

        aboutAapter();

        //注册滚动图


    }

    private void aboutAapter() {
        recycleAdapter = new HomeGoodsRecycleAdapter(getContext() ,bannerPictures,smallBannerPicture);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        //设置布局管理器


//        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        // 设置布局管理一条数据占用几行，如果是头布局则头布局自己占用一行
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int postion) {
                if (postion == 0) {
                    return 2;
                }
                else if(postion==1){
                    return 2;
                }
                else if(postion==2){
                    return 2;
                }
                else if(postion==3){
                    return 2;
                }
                else {
                    return 1;
                }
            }
        });
        rvList.setLayoutManager(gridLayoutManager);



        //  rvList.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        //layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置Adapter
        rvList.setAdapter(recycleAdapter);
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

        bannerPictures=new LinkedList<>();
        for (int i=0;i<5;i++){
            bannerPictures.add("https://img.alicdn.com//i3//1607379596//TB2jipmXy6guuRkSnb4XXbu4XXa_!!1607379596.jpg");
        }
        smallBannerPicture=new LinkedList<>();
        smallBannerPicture.add("http://thyrsi.com/t6/362/1535203696x-1404750094.png");
        smallBannerPicture.add("http://pic.caigoubao.cc/606673/1%20(2).png");
        smallBannerPicture.add("http://pic.caigoubao.cc/606673/1%20(3).png");



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
        bannerPictures=new LinkedList<>();
        for (int i=0;i<5;i++){
            bannerPictures.add("https://img.alicdn.com//i3//1607379596//TB2jipmXy6guuRkSnb4XXbu4XXa_!!1607379596.jpg");
        }
        smallBannerPicture=new LinkedList<>();
            smallBannerPicture.add("http://thyrsi.com/t6/362/1535203696x-1404750094.png");
        smallBannerPicture.add("http://pic.caigoubao.cc/606673/1%20(2).png");
        smallBannerPicture.add("http://pic.caigoubao.cc/606673/1%20(3).png");


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

        ImageView messageiv = getView().findViewById(R.id.MessageView);
        rvList = getView().findViewById(R.id.rv_list);
        srfresh = getView().findViewById(R.id.srl_fresh);

    }
}


