package com.husheng.riji.husshen2.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.utils.SpecialDialog;
import com.husheng.riji.husshen2.utils.SuitScreen;

public class SettingActivity extends AppCompatActivity  implements View.OnClickListener{

     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_main);//激活搜索页面


         SuitScreen ss=new SuitScreen();
         ss.setWindows(getWindow());


         final LinearLayout alipay_view=findViewById(R.id.alipay_bind_view);
         alipay_view.setOnClickListener(this);
         LinearLayout wechat_view=findViewById(R.id.wechat_bind_view);
         wechat_view.setOnClickListener(this);
         LinearLayout revise_phone_view=findViewById(R.id.revise_phone_view);
         revise_phone_view.setOnClickListener(this);
         LinearLayout revise_password_view=findViewById(R.id.revise_view_password);
         revise_password_view.setOnClickListener(this);
         LinearLayout message_notive_view=findViewById(R.id.message_notice_view);
         message_notive_view.setOnClickListener(this);
       //  ImageView return_button=findViewById(R.id.message_notice_return);
         //return_button.setOnClickListener(this);
         TextView exit_login_button=findViewById(R.id.exit_login_button);
         exit_login_button.setOnClickListener(this);
        /* return_buton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 finish();
             }
         });

*/       ImageView setting_return_view=findViewById(R.id.setting_return);
         setting_return_view.setOnClickListener(this);


         Button clear_cache_button=findViewById(R.id.clear_cache_button);
         clear_cache_button.setOnClickListener(this);

         LinearLayout nickname_revise=findViewById(R.id.nick_name_view);
         nickname_revise.setOnClickListener(this);







     }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.exit_login_button:


               final SpecialDialog myDialog=new SpecialDialog(SettingActivity.this);
                myDialog.getWindow().setLayout(800,450); //对话框大小应根据屏幕大小调整
                myDialog.setContent("自定义对话框");
                myDialog.setOnPositiveListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(SettingActivity.this,"YES", Toast.LENGTH_SHORT).show();
                        myDialog.dismiss();
                    }
                });
                myDialog.setOnNegativeListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(SettingActivity.this,"NO",Toast.LENGTH_SHORT).show();
                        myDialog.dismiss();
                    }
                });
                myDialog.show();


                break;
            case R.id.alipay_bind_view:

                Intent intent =new Intent(SettingActivity.this,AlipayBindActivity.class);
                startActivity(intent);

                break;
            case R.id.wechat_bind_view:
                Intent intent2 =new Intent(SettingActivity.this,WechatBindActivity.class);
                startActivity(intent2);
                break;
            case R.id.revise_view_password:
                Intent intent3 =new Intent(SettingActivity.this,RevisePasswdActivity.class);
                startActivity(intent3);

                break;
            case R.id.revise_phone_view:
                Intent intent4 =new Intent(SettingActivity.this,RevisePhoneActivity.class);
                startActivity(intent4);

                break;
            case R.id.message_notice_view:
                Intent intent5 =new Intent(SettingActivity.this,MessageNoticeActivity.class);
                startActivity(intent5);
            case R.id.setting_return:
                finish();

            case R.id.clear_cache_button:
                Toast.makeText(SettingActivity.this,"恭喜你清除了缓存",Toast.LENGTH_SHORT).show();


            case R.id.nick_name_view:
                Intent intent6 =new Intent(SettingActivity.this,ReviseNicknameActivity.class);
                startActivity(intent6);





        }
    }


}