package com.husheng.riji.husshen2.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.husheng.riji.husshen2.fragments.AllFansFragment;
import com.husheng.riji.husshen2.fragments.BrandFragment;
import com.husheng.riji.husshen2.fragments.CircleFragment;
import com.husheng.riji.husshen2.fragments.GoodsListSortFragmentFragment;
import com.husheng.riji.husshen2.utils.NoScrollViewPager;
import com.husheng.riji.husshen2.utils.SuitScreen;
import com.husheng.riji.husshen2.R;
import java.util.ArrayList;
import java.util.List;

import adapter.MyFragmentPagerAdapter;

public class SearchActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private NoScrollViewPager mViewPager;
    private boolean flag=true;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private String [] titles = {"综合","劵后价","销量"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_sorted);
        SuitScreen ss=new SuitScreen();
         ss.setWindows(getWindow());




        //初始化视图
        initViews();

    }

    private void initViews() {
        List<Fragment> fragments = new ArrayList<Fragment>();
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tabLayout);
       GoodsListSortFragmentFragment  fragment1 = new GoodsListSortFragmentFragment();
        AllFansFragment fragment2 = new AllFansFragment();
        BrandFragment fragment3 = new BrandFragment();

        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);

        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(myFragmentPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < myFragmentPagerAdapter.getCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);//获得每一个tab
            tab.setCustomView(R.layout.sort_tab_item);//给每一个tab设置view
            if (i == 0) {
                // 设置第一个tab的TextView是被选择的样式
                tab.getCustomView().findViewById(R.id.tab_text).setSelected(true);//第一个tab被选中
            }
            TextView textView = tab.getCustomView().findViewById(R.id.tab_text);
            textView.setText(titles[i]);//设置tab上的文字
            textView.setTextColor(Color.BLACK);
        }


        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(final TabLayout.Tab tab) {


                tab.getCustomView().findViewById(R.id.tab_text).setSelected(true);
                TextView textView = tab.getCustomView().findViewById(R.id.tab_text);
                textView.setTextColor(Color.RED);
                final ImageView imageView = tab.getCustomView().findViewById(R.id.tab_img);


                if (flag) {
                    LinearLayout tabItem = tab.getCustomView().findViewById(R.id.tab_item);
                    imageView.setImageResource(R.drawable.list_comp_bottom);

                    flag = !flag;
                } else {
                    imageView.setImageResource(R.drawable.list_comp_top);
                    flag = !flag;
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getCustomView().findViewById(R.id.tab_text).setSelected(false);
                TextView textView = tab.getCustomView().findViewById(R.id.tab_text);
                textView.setTextColor(Color.BLACK);
                ImageView imageView = tab.getCustomView().findViewById(R.id.tab_img);
                imageView.setImageResource(R.drawable.list_comp_bottom_gray);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                final ImageView imageView = tab.getCustomView().findViewById(R.id.tab_img);


                if (flag) {
                    LinearLayout tabItem = tab.getCustomView().findViewById(R.id.tab_item);
                    imageView.setImageResource(R.drawable.list_comp_bottom);
                    flag = !flag;
                } else {
                    imageView.setImageResource(R.drawable.list_comp_top);
                    flag = !flag;
                }

            }
        });

    }

    }

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.search_main);//激活搜索页面
//
//        SuitScreen ss=new SuitScreen();
//        ss.setWindows(getWindow());
//
//    }}