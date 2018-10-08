package com.husheng.riji.husshen2.fragments;


import  adapter.FragmentAdapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.husheng.riji.husshen2.R;

import java.util.ArrayList;


public class CircleFragment extends  Fragment{
    private String[] mTitle = new String[4];
    private String[] mData = new String[4];

    {
        for(int i=0;i<4;i++) {
            mTitle[i] = "title" + i;
            mData[i] = "data" + i;
        }
    }
    TabLayout mTabLayout;
    ViewPager mViewPager ;
    FragmentPagerAdapter mAdapter;
    Fragment everyday_boot;
    Fragment share;
    Fragment material;
    ArrayList<Fragment> flist;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_circle,null);
        mTabLayout = view.findViewById(R.id.t1);
        mViewPager = view.findViewById(R.id.viewpager);
        FragmentManager man = getActivity().getSupportFragmentManager();
        initFragment();
        flist=new ArrayList<Fragment>();
        flist.add(everyday_boot);
        flist.add(share);
        flist.add(material);
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        final TabLayout.TabLayoutOnPageChangeListener listener =
                new TabLayout.TabLayoutOnPageChangeListener(mTabLayout);
        mViewPager.addOnPageChangeListener(listener);
        mAdapter= new FragmentAdapter(man,flist);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
        return view;
    }

    private void initFragment() {
        everyday_boot=new CircleEveryFragment();
        share=new CircleShareActivityFragment();
        material=new CircleMaterialActivityFragment();

    }
}