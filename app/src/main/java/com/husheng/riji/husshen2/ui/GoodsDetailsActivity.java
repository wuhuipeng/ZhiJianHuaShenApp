package com.husheng.riji.husshen2.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.bean.Goods;
import com.husheng.riji.husshen2.utils.SuitScreen;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.LinkedList;
import java.util.List;

public class GoodsDetailsActivity extends AppCompatActivity implements  View.OnClickListener {

    private  boolean flag,pulllFlag;
    private ImageView colletion_image,detailsPullImg;
    private TextView colletion_text,gooddetailsTitle;
    private LinearLayout colletion_view,details_layout,goToTaoBaoButton;
    private  Goods thisItem;



    protected void onCreate(Bundle savedInstanceState) throws NullPointerException{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_details);//接受消息界面
        SuitScreen ss = new SuitScreen();
        ss.setWindows(getWindow());


        initView();
    }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.colletion_img:
                  if(flag){
                        colletion_image.setBackgroundResource(R.drawable.collect_gray);
                      colletion_text.setText("收藏");
                      colletion_text.setTextColor(Color.parseColor("#666666") );
                          }else{
                    colletion_image.setBackgroundResource(R.drawable.collect_red);
                    colletion_text.setText("已收藏");
                    colletion_text.setTextColor(Color.parseColor("#8f1b0f") );
                    }
                   flag = !flag;
                    break;
                case  R.id.details_pull_img:
                    if(pulllFlag){
                        details_layout.setVisibility(View.VISIBLE);
                        detailsPullImg.setBackgroundResource(R.drawable.shotdown);


                    }else{
                            details_layout.setVisibility(View.GONE);
                        detailsPullImg.setBackgroundColor(R.drawable.shotright);
                }
                pulllFlag=!pulllFlag;
                    break;
                case R.id.go_to_taobao_app_button:
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    Uri uri = Uri.parse(thisItem.getItem_url()); // 商品地址
                  intent.setData(uri);
                    intent.setClassName("com.taobao.taobao", "com.taobao.tao.detail.activity.DetailActivity");
                    startActivity(intent);

            }
        }
        public  void initView() throws NullPointerException{
            thisItem= (Goods) getIntent().getSerializableExtra("data");
            List<String>   bannerPictures=new LinkedList<>();
        //    Intent intent=getIntent();




            //      String goodsTitle=intent.getStringExtra("title");
          //   gotoTaobaoUrl=intent.getStringExtra("url");

            colletion_image= findViewById(R.id.colletion_img);
            colletion_view= findViewById(R.id.collection_view);
            colletion_text= findViewById(R.id.collection_text);
            details_layout= findViewById(R.id.details_view);
            detailsPullImg= findViewById(R.id.details_pull_img);
            goToTaoBaoButton= findViewById(R.id.go_to_taobao_app_button);
            gooddetailsTitle= findViewById(R.id.goods_details_text);


           //传递商品列表的详细参数
          //  System.out.print("2342"+goodsTitle);
            gooddetailsTitle.setText(thisItem.getTitle());

            details_layout.setOnClickListener(this);
            detailsPullImg.setOnClickListener(this);
            colletion_view.setOnClickListener(this);
            colletion_text.setOnClickListener(this);
            colletion_image.setOnClickListener(this);
            goToTaoBaoButton.setOnClickListener(this);


            final ImageView goodsLongImg=findViewById(R.id.goods_long_image);    Transformation transformation = new Transformation() {


                @Override
                public Bitmap transform(Bitmap source) {

                    int targetWidth = goodsLongImg.getWidth();
                    if (source.getWidth() == 0) {
                        return source;
                    }
                    //如果图片大小大于等于设置的宽度，则按照设置的宽度比例来缩放
                    double aspectRatio = (double) source.getHeight() / (double) source.getWidth();
                    int targetHeight = (int) (targetWidth * aspectRatio);
                    if (targetHeight != 0 && targetWidth != 0) {
                        Bitmap result = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, false);
                        if (result != source) {
                            // Same bitmap is returned if sizes are the same
                            source.recycle();
                        }
                        return result;
                    } else {
                        return source;
                    }

                }

                @Override
                public String key() {
                    return "transformation" + " desiredWidth";
                }
            };

            Picasso.get().load("https://img.zcool.cn/community/01247f5991c8d40000002129fce48c.jpg@1280w_1l_2o_100sh.jpg").transform(transformation).into(goodsLongImg);

            Bundle b=this.getIntent().getExtras();
           String[] small_piture=thisItem.getSmall_images();

           for (int i=0;i<small_piture.length;i++){
              bannerPictures.add(small_piture[i]);

            }

            Banner banner = findViewById(R.id.banner);
            //设置banner样式
            banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
            //设置图片加载器
            banner.setImageLoader(new GoodsImageLoader());
            //设置图片集合
            banner.setImages(bannerPictures);

            //设置banner动画效果
            banner.setBannerAnimation(Transformer.DepthPage);

            //设置自动轮播，默认为true
            banner.isAutoPlay(true);
            //设置轮播时间
            banner.setDelayTime(1500);
            //设置指示器位置（当banner模式中有指示器时）
            banner.setIndicatorGravity(BannerConfig.CENTER);
            //banner设置方法全部调用完毕时最后调用
            banner.start();






        }


}
class GoodsImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        Glide.with(context).load(path).into(imageView);
    }
}
