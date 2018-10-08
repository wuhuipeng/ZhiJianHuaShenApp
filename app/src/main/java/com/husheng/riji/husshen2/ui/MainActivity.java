package com.husheng.riji.husshen2.ui;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.fragments.BrandFragment;
import com.husheng.riji.husshen2.fragments.CircleFragment;
import com.husheng.riji.husshen2.fragments.HomeFragment;
import com.husheng.riji.husshen2.fragments.MineFragment;
import com.husheng.riji.husshen2.fragments.PeanutFragment;
import com.husheng.riji.husshen2.utils.SuitScreen;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SuitScreen ss=new SuitScreen();
        ss.setWindows(getWindow());


        BottomBar bottomBar = findViewById(R.id.bottom_bar);
        bottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#999999", "#ff5d5e")
                .setIconHeight(25)
                .setIconWidth(25)
                .addItem(HomeFragment.class,
                        "首页",
                        R.drawable.tab_home_unselect,
                        R.drawable.tab_home_select)
                .addItem(BrandFragment.class,
                        "品牌",
                        R.drawable.tab_brand_unselect,
                        R.drawable.tab_brand_select)
                .addItem(PeanutFragment.class,
                        "会员",
                        R.drawable.tab_peanut_select,
                        R.drawable.tab_peanut_select)
                .addItem(CircleFragment.class,
                        "糖果圈",
                        R.drawable.tab_circle_unselect,
                        R.drawable.tab_circle_select)
                .addItem(MineFragment.class,
                        "我的",
                        R.drawable.tab_mine_unselect,
                        R.drawable.tab_mine_select)
                .build();





    }







}

