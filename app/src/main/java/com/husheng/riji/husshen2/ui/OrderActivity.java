package com.husheng.riji.husshen2.ui;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.fragments.AllOrderFragment;
import com.husheng.riji.husshen2.fragments.CalOrderFragment;
import com.husheng.riji.husshen2.fragments.FailureOrderFragment;
import com.husheng.riji.husshen2.fragments.PayOrderFragment;
import com.husheng.riji.husshen2.utils.SuitScreen;

import java.util.ArrayList;
import java.util.List;

import adapter.FansFragmentPagerAdapter;

public class OrderActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
private TabLayout tabLayout;
private ViewPager viewPager;
private FansFragmentPagerAdapter viewPagerAdapter;
//TabLayout标签
private String[] titles=new String[]{"全部","已付款","已结算","已失效"};
private List<Fragment> fragments=new ArrayList<>();

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_view);



    SuitScreen ss=new SuitScreen();
    ss.setWindows(getWindow());

    init();
        }

private void init(){

       ImageView sub_return=findViewById(R.id.subreturn);
       sub_return.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });

        tabLayout= findViewById(R.id.taborder);
        viewPager= findViewById(R.id.viewpagerorder);
        //设置TabLayout标签的显示方式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //循环注入标签
        for (String tab:titles){
        tabLayout.addTab(tabLayout.newTab().setText(tab));
        }
        //设置TabLayout点击事件
        tabLayout.setOnTabSelectedListener(this);

        fragments.add(new AllOrderFragment());

        fragments.add(new FailureOrderFragment());
        fragments.add(new CalOrderFragment());
        fragments.add(new PayOrderFragment());

        viewPagerAdapter=new FansFragmentPagerAdapter(getSupportFragmentManager(),titles,fragments);
        viewPager.setAdapter(viewPagerAdapter);
    tabLayout.setupWithViewPager(viewPager);
        }

@Override
public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        }

@Override
public void onTabUnselected(TabLayout.Tab tab) {

        }

@Override
public void onTabReselected(TabLayout.Tab tab) {

        }
        }

