package com.husheng.riji.husshen2.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.husheng.riji.husshen2.ui.AboutPeanutActivity;
import com.husheng.riji.husshen2.ui.CommonProblemActivity;
import com.husheng.riji.husshen2.ui.ContactCustomerServiceActivity;
import com.husheng.riji.husshen2.ui.FansActivity;
import com.husheng.riji.husshen2.ui.FeedbackActivity;
import com.husheng.riji.husshen2.ui.IncomeActivity;
import com.husheng.riji.husshen2.ui.InvitationActivity;
import com.husheng.riji.husshen2.ui.MessageActivity;
import com.husheng.riji.husshen2.ui.MyCollectionActivity;
import com.husheng.riji.husshen2.ui.NoviceIntroductionActivity;
import com.husheng.riji.husshen2.ui.OfficialNoticeActivity;
import com.husheng.riji.husshen2.ui.OrderActivity;
import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.ui.RegisterOrLoginActivity;
import com.husheng.riji.husshen2.ui.SettingActivity;


public class MineFragment extends  Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_mine, container, false);
    }





    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

/*
        ImageView  imagevipiv=getView().findViewById(R.id.imagevip);//为头像添加点击页面

        imagevipiv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),OfficialNoticeActivity.class);
                startActivity(intent);
            }
        });

*/

      /*      //未登录状态下部分组件不可见
        LinearLayout   logintop=getView().findViewById(R.id.logintopview);
        LinearLayout   profitlistview=getView().findViewById(R.id.profitlist);
        LinearLayout   orderlistview=getView().findViewById(R.id.orderlistview);

        LinearLayout   loginbottom=getView().findViewById(R.id.loginbottomview);
        Button  login_or_register_buttom=getView().findViewById(R.id.login_or_register_buttom);

        loginbottom.setVisibility(View.GONE);
        logintop.setVisibility(View.GONE);



        profitlistview.setVisibility(View.GONE);



        orderlistview.setVisibility(View.GONE);



        login_or_register_buttom.setVisibility(View.VISIBLE);*/

        Button login_or_register_button=getView().findViewById(R.id.login_or_register_buttom);

        login_or_register_button.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View view) {
                                                            Intent intent =new Intent(getActivity(), RegisterOrLoginActivity.class);
                                                            startActivity(intent);
                                                        }
                                                    }

        );

        ImageView  messageiv=getView().findViewById(R.id.imageMessage);//为设置添加点击页面

        messageiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),MessageActivity.class);
                startActivity(intent);
            }
        });





        ImageView  settingiv=getView().findViewById(R.id.imageSetting);//为设置添加点击页面

        settingiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),SettingActivity.class);
                startActivity(intent);
            }
        });


        LinearLayout notice_layout =getView().findViewById(R.id.notice_view);//为公告条添加点击事件
        notice_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),OfficialNoticeActivity.class);
                startActivity(intent);
            }
        });


        LinearLayout feedback_layout =getView().findViewById(R.id.feedback_view);//为意见反馈条添加点击事件
        feedback_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),FeedbackActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout aboutpeanut_layout =getView().findViewById(R.id.aboutpeanut_view);//为关于花生条添加点击事件
        aboutpeanut_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),AboutPeanutActivity.class);
                startActivity(intent);
            }
        });


        LinearLayout my_collect_layout =getView().findViewById(R.id.my_collection_view);//为我的收藏条添加点击事件
        my_collect_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),MyCollectionActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout commonproblem_layout =getView().findViewById(R.id.common_problem_view);//为常见问题添加点击事件
        commonproblem_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),CommonProblemActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout contactcustomerservice_layout =getView().findViewById(R.id.contact_customer__serive_view);//为联系客服添加点击事件
        contactcustomerservice_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),ContactCustomerServiceActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout noviceintroduction_layout =getView().findViewById(R.id.nocive_intrduction_view);//为关于花生条添加点击事件
       noviceintroduction_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),NoviceIntroductionActivity.class);
                startActivity(intent);
            }
        });


        LinearLayout income_layout =getView().findViewById(R.id.income_view);//为关于收益添加点击事件
        income_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),IncomeActivity.class);
                startActivity(intent);
            }
        });


        LinearLayout income_layout2 =getView().findViewById(R.id.today_income_view);//为关于今日收益添加点击事件
        income_layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),IncomeActivity.class);
                startActivity(intent);
            }
        });


        LinearLayout income_layout3 =getView().findViewById(R.id.month_income_view);//为次月收益添加点击事件
        income_layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),IncomeActivity.class);
                startActivity(intent);
            }
        });







        LinearLayout invitaion_layout =getView().findViewById(R.id.invitation_view);//为邀请添加点击事件
        invitaion_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(getActivity(),InvitationActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout order_layout =getView().findViewById(R.id.order_view);//为关于花生条添加点击事件
        order_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),OrderActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout fans_layout =getView().findViewById(R.id.fans_view);//为关于花生条添加点击事件
       fans_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),FansActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout fans_layout2 =getView().findViewById(R.id.mine_fans_view);//为关于我的粉丝添加点击事件
        fans_layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(getActivity(),FansActivity.class);
                startActivity(intent);
            }
        });


    }
}
