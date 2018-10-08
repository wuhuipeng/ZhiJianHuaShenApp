package com.husheng.riji.husshen2.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.husheng.riji.husshen2.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.LinkedList;
import java.util.List;

import adapter.CircleMaterialAdapter;

public class CircleMaterialActivityFragment extends Fragment {


    private List<String> mDatas;

    private RecyclerView rvList;
    private CircleMaterialAdapter circleMaterialAdapter;
    private Handler mHandler;
    private SmartRefreshLayout srfresh;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_circle_material, container, false);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        mHandler=new Handler();

        initData();
         aboutAapter();

    }
    private void aboutAapter() {
        circleMaterialAdapter = new CircleMaterialAdapter(getContext(), mDatas);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        //设置布局管理器


   //  StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
     //   GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        // 设置布局管理一条数据占用几行，如果是头布局则头布局自己占用一行

        rvList.setLayoutManager( layoutManager);



        //  rvList.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        //layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置Adapter
        rvList.setAdapter( circleMaterialAdapter);
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
                        initData();
                        circleMaterialAdapter.refresh(mDatas);
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
                        initData();
                        circleMaterialAdapter.refresh(mDatas);
                        refreshlayout.finishLoadMore();
                    }
                },500);

            }
        });
        srfresh.setEnableLoadMore(true);
        srfresh.autoRefresh();
    }

    private void initData() {
        mDatas=new LinkedList<>();
        for (int i=0;i<4;i++){
            mDatas.add(i+"");
        }

    }

    private void initView() {

      //  ImageView messageiv = getView().findViewById(R.id.MessageView);
        rvList = getView().findViewById(R.id.circle_recycler);
        srfresh = getView().findViewById(R.id.circle_refresh);

    }

}
