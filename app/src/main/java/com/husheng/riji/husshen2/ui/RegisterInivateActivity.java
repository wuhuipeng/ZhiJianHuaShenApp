

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

        import com.husheng.riji.husshen2.R;
        import com.husheng.riji.husshen2.utils.SuitScreen;

public class RegisterInivateActivity extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_inviate);//激活搜索页面


        SuitScreen ss=new SuitScreen();
        ss.setWindows(getWindow());



        ImageView register_inviate_finish_view=findViewById(R.id.register_inviate_return_view);
        register_inviate_finish_view.setOnClickListener(this);
        ImageView scan_image_view=findViewById(R.id.scan_image);
        scan_image_view.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_inviate_return_view:
                finish();

                break;
            case  R.id.scan_image:
                Intent intent =new Intent(RegisterInivateActivity.this, TwoDimensionScanActivity.class);
                startActivity(intent);




        }
    }




}
