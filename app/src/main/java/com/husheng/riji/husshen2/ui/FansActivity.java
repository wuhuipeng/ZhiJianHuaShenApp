package com.husheng.riji.husshen2.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.fragments.AllFansFragment;
import com.husheng.riji.husshen2.fragments.DirectFansFragment;
import com.husheng.riji.husshen2.fragments.RecommendFansFragment;
import com.husheng.riji.husshen2.utils.SuitScreen;

import java.util.ArrayList;
import java.util.List;

import adapter.FansFragmentPagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FansActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

@BindView(R.id.tabfans) TabLayout tabLayout;
@BindView(R.id.fans_return) ImageView fans_return;
private ViewPager viewPager;
private FansFragmentPagerAdapter viewPagerAdapter;
//TabLayout标签
private String[] titles=new String[]{"全部粉丝","直属粉丝","推荐粉丝"};
private List<Fragment> fragments=new ArrayList<>();

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fans_view);

        SuitScreen ss=new SuitScreen();
        ss.setWindows(getWindow());

        ButterKnife.bind(this);
        init();
        }

private void init(){

        fans_return.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        finish();
                }
        });

        viewPager= findViewById(R.id.viewpagerfans);
        //设置TabLayout标签的显示方式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //循环注入标签
        for (String tab:titles){
        tabLayout.addTab(tabLayout.newTab().setText(tab));
        }
        //设置TabLayout点击事件
        tabLayout.setOnTabSelectedListener(this);

        fragments.add(new AllFansFragment());

        fragments.add(new DirectFansFragment());
        fragments.add(new RecommendFansFragment());

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

