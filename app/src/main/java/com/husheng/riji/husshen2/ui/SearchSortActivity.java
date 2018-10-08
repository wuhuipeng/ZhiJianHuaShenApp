package com.husheng.riji.husshen2.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.bean.Goods;
import com.husheng.riji.husshen2.bean.Goodses;
import com.husheng.riji.husshen2.utils.SpecialDialog;
import com.husheng.riji.husshen2.utils.SuitScreen;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.IOException;

import adapter.GoodsListSortAdapter;
import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchSortActivity extends  AppCompatActivity {
    Intent intent1 = getIntent();

     @BindView(R.id.one)
     TextView one;
    private String initurl="http://api.vephp.com/super?vekey=V00000129Y78348127";

    private RecyclerView rvList;
    private GoodsListSortAdapter sortadapter;
    private Handler mHandler,nHandler;
    private SmartRefreshLayout srfresh;
    private int page=2;
    private int maxPage;
    private String name;
    private String keyword;






    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                String js = (String) msg.obj;
                js = js.replaceAll("\"coupon_info\":\\[\\],", "");

              try {
                  Gson gson = new Gson();
                  Goodses bean = gson.fromJson(js, Goodses.class);
                  sortadapter.setData(bean);
              }catch(JsonSyntaxException e){
                 Log.i("异常",e.getMessage());
              }



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

                try {
                    Gson gson = new Gson();
                    Goodses bean = gson.fromJson(js, Goodses.class);
                    sortadapter.loadmore(bean);
                }catch(JsonSyntaxException e){
                    Log.i("异常",e.getMessage());
                }

            }
        }
    };


    protected void onNewIntent(Intent intent) {

        super.onNewIntent(intent);

        setIntent(intent);//must store the new intent unless getIntent() will return the old one

        processExtraData();

    }

    private void processExtraData(){


        Intent intent = getIntent();
        keyword = intent.getStringExtra("name");
        Log.i("da", "###"+keyword);


//use the data received here

    }


    protected void onCreate(Bundle savedInstanceState) {
     //   String endurl=initurl+keyword;
        super.onCreate(savedInstanceState);
        processExtraData();

        setContentView(R.layout.activity_search_sort);//接受消息界面
        SuitScreen ss=new SuitScreen();
        ss.setWindows(getWindow());
   //     Intent intent = getIntent();
     //   String tem= getIntent().getStringExtra("string_data");
       // Toast.makeText(SearchSortActivity.this,data,Toast.LENGTH_SHORT).show();
     //   one.setText(name);

//        Bundle bundle=getIntent().getExtras();
//
//        String name=bundle.getString("name");
//           if(name==null){
//               one.setText("数据为空");
//           }else{
//               one.setText("数据不为空");
//           }
//

        initView();

        Log.i("two", "###"+keyword);
       // Toast.makeText(this,"dsdssd"+keyword2,Toast.LENGTH_LONG);
        initData(1,initurl,keyword);
        aboutAapter();

    }
    private void aboutAapter() {
        sortadapter = new GoodsListSortAdapter(this);
//        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        // 设置布局管理一条数据占用几行，如果是头布局则头布局自己占用一行
        rvList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        rvList.setLayoutManager(gridLayoutManager);

        //  rvList.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        //layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置Adapter
        rvList.setAdapter(sortadapter);
        //设置 Header 为 贝塞尔雷达 样式
        srfresh.setRefreshHeader(new ClassicsHeader(this));
        //设置 Footer 为 球脉冲 样式
        srfresh.setRefreshFooter(new ClassicsFooter(this));
        srfresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                //延时展示，延时2秒
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initData(1,initurl,keyword);
                        //  recycleAdapter.refresh(mDatas);
                        refreshlayout.finishRefresh();
                    }
                },100);

            }
        });
        srfresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(final RefreshLayout refreshlayout) {

                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        refresbData(page, initurl,keyword);
                        page++;
                        refreshlayout.finishLoadMore();
                    }

                },100);
            }
        });


        srfresh.setEnableLoadMore(true);
        srfresh.autoRefresh();
    }

    private void initData(int page,String url,String keyword) {


        mHandler=new Handler();  OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(url+"&page="+page+"&para="+keyword).build();
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

    private void refresbData(int page,String url,String keyword) {

        nHandler=new Handler();  OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(url+"&page="+page+"&para="+keyword).build();
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
        rvList = findViewById(R.id.sort_recycler);
        srfresh = findViewById(R.id.sort_refresh);

    }
}
