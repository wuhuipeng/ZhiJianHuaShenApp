package adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.bean.Goods;
import com.husheng.riji.husshen2.bean.Goodses;
import com.husheng.riji.husshen2.ui.GoodsDetailsActivity;
import com.husheng.riji.husshen2.ui.MainActivity;
import com.husheng.riji.husshen2.ui.MessageActivity;
import com.husheng.riji.husshen2.ui.SearchSortActivity;
import com.husheng.riji.husshen2.ui.SearchWordsActivity;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Tools.XCRoundImageView;

public class HomeGoodsRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    private List<String> picList,smallbanner;
    private final int BANNER_VIEW_TYPE = 0;//轮播图


    private final int GOODS_LIST=1;
    private  final int ADVER_ITEM=2;//广告布局
    private final int FIVE_ITEM=3;//错乱布局
    private final int NORMAL_VIEW_TYPE = 4;//正常布局
    private ArrayList<Goods> list;

    public int getItemViewType(int position) {
        /*
        区分item类型,返回不同的int类型的值
        在onCreateViewHolder方法中用viewType来创建不同的ViewHolder
         */
        if (position == 0) {//第0个位置是轮播图
            return BANNER_VIEW_TYPE;
        }else if(position==1){
            return GOODS_LIST;

        }
        else  if(position==2){
            return  ADVER_ITEM;
        }
        else  if(position==3){
            return  FIVE_ITEM;
        }
        else {//其他位置返回正常的布局
            return NORMAL_VIEW_TYPE;
        }
    }


    public HomeGoodsRecycleAdapter(Context mContext, List<String> picList , List<String> smallbanner) {
        this.mContext=mContext;
        this.smallbanner=smallbanner;
        this.picList=picList;
        inflater= LayoutInflater.from(mContext);
    }

    public void setData(Goodses bean){
        if(this.list == null){
            this.list = new ArrayList<Goods>();
        }
        this.list= (ArrayList<Goods>) bean.getResult_list();
        notifyDataSetChanged();
    }


//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(mContext, "点击事件测试"+mDatas.get(position), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//    }



    /**
     * 创建ViewHolder,根据getItemViewType方法里面返回的几种类型来创建
     *
     * @param viewType 就是getItemViewType返回的type
     * @return 返回自己创建的ViewHolder
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == BANNER_VIEW_TYPE) {//如果viewType是轮播图就去创建轮播图的viewHolder
            view = getView(R.layout.youthbanner);
            BannerHolder bannerHolder = new BannerHolder(view);
            return bannerHolder;

        } else if(viewType == GOODS_LIST){
            view=getView(R.layout.goods_colletion_item);
            GoodsListHolder goodsListHolder=new GoodsListHolder(view);
            return  goodsListHolder;
        }
        else if(viewType == ADVER_ITEM){
            view=getView(R.layout.advertisement_item);
            AdvHolder  advListHolder=new  AdvHolder(view);
            return  advListHolder;
        }
        else if(viewType == FIVE_ITEM){
            view=getView(R.layout.five_grid_items);
            FiveItemHolder  fiveHolder=new FiveItemHolder(view);
            return  fiveHolder;
        }
        else {//正常
            view = getView(R.layout.item);
            RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(lp);
            return new GoodsViewHolder(view);
        }
    }
    /**
     * 用来引入布局的方法
     */
    private View getView(int view) {
        View view1 = View.inflate(mContext, view, null);
        return view1;
    }


    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
    //判断不同的ViewHolder做不同的处理
    if (holder instanceof BannerHolder) {//轮播图
        BannerHolder bannerHolder = (BannerHolder) holder;
        //调用设置轮播图相关方法
        setBanner(bannerHolder);

    }
    else if(holder instanceof  GoodsListHolder){//10个商品列表
         GoodsListHolder goodsListHolder=(GoodsListHolder) holder;

        goodsListHolder.goodOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mContext,SearchSortActivity.class);
                intent.putExtra("name","女装");
                mContext.startActivity(intent);

            }
        });
        goodsListHolder.goodTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mContext,SearchSortActivity.class);
                intent.putExtra("name","母婴");
                mContext.startActivity(intent);
            }
        });

        goodsListHolder.goodThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mContext,SearchSortActivity.class);
                intent.putExtra("name","化妆");
                mContext.startActivity(intent);
            }
        });

        goodsListHolder.goodFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mContext,SearchSortActivity.class);
                intent.putExtra("name","家具");
                mContext.startActivity(intent);
            }
        });
        goodsListHolder.goodFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mContext,SearchSortActivity.class);
                intent.putExtra("name","内衣");
                mContext.startActivity(intent);
            }
        });
        goodsListHolder.goodSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mContext,SearchSortActivity.class);
                intent.putExtra("name","男装");
                mContext.startActivity(intent);
            }
        });
        goodsListHolder.goodSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mContext,SearchSortActivity.class);
                intent.putExtra("name","美食");
                mContext.startActivity(intent);
            }
        });
        goodsListHolder.goodEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mContext,SearchSortActivity.class);
                intent.putExtra("name","数码");
                mContext.startActivity(intent);
            }
        });
        goodsListHolder.goodNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mContext,SearchSortActivity.class);
                intent.putExtra("name","鞋包");
                mContext.startActivity(intent);
            }
        });
        goodsListHolder.goodTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mContext,SearchSortActivity.class);
                intent.putExtra("name","其他");
                mContext.startActivity(intent);
            }
        });








    } else if(holder instanceof  AdvHolder) {//广告布局
        AdvHolder advHolder = (AdvHolder) holder;

        //调用设置轮播图相关方法
        setSmallBanner(advHolder);

    }

    else if(holder instanceof  FiveItemHolder) {//错乱布局
        FiveItemHolder  fiveItemHolder = (FiveItemHolder) holder;

    }
        else if(holder instanceof GoodsViewHolder) {//正常布局
        GoodsViewHolder goodsHolder = (GoodsViewHolder) holder;
        Picasso.get().load(list.get(position-4).getPict_url()).into(goodsHolder.goodsPicture);
        goodsHolder.goodPrice.setText(  String.valueOf(list.get(position-4).getReserve_price()));
        goodsHolder.goodTitle.setText(list.get(position-4).getTitle());
        //goodsHolder.juanPrice.setText(list.get(position-4).getCoupon_total_count());
        goodsHolder.juanPrice.setText("￥"+list.get(position-4).getCoupon_info());

        if(list.get(position-4).getVolume()<10000) {
            goodsHolder.monthSale.setText("月销" + String.valueOf(list.get(position - 4).getVolume()) + "笔");
        }
        else {
            int a=(int)list.get(position-4).getVolume()/10000;
            goodsHolder.monthSale.setText("月销" + a + "万多笔");

        }
        goodsHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,GoodsDetailsActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("data", list.get(position-4));//序列化

                intent.putExtras(bundle);

          //      intent.putExtra("data",list.get(position-4));
                mContext.startActivity(intent);

                //  Bundle b=new Bundle();
          //     b.putExtra("title",list.get(position-4).getTitle());
            //    intent.putExtra("url",list.get(position-4).getItem_url());
              //  intent.putExtra("monthsale",list.get(position-4).getVolume());
             //   intent.putExtra("juanprice",list.get(position-4).getCoupon_info());
        //      ArrayList small_picture =new ArrayList(Arrays.asList(list.get(position-4).getSmall_images()));
                 //Toast.makeText(mContext,"23"+list.get(position-4).getSmall_images()[0],Toast.LENGTH_LONG);
              //          intent.putExtra("goodes",list.get(position-4));
                //      intent.putExtra("i",list.get(position-4).getSmall_images()[0]);

//                b.putStringArrayList("w",small_picture);
       //        intent.putExtras(b);
             //   intent.setClass(mContext,GoodsDetailsActivity.class);
           //     mContext.startActivity(intent);

            }});


    }

}

    @Override
    public int getItemCount() {
        return list == null ? 0 :list.size()+4;
    }

    /**
     * 轮播图的ViewHolder
     */
    public static class BannerHolder extends RecyclerView.ViewHolder {
        Banner banner;

        public BannerHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);

        }
    }

    /**
     * 商品十行Viewholder
     */

    public static class GoodsListHolder extends RecyclerView.ViewHolder {
        XCRoundImageView goodOne,goodTwo,goodThree,goodFour, goodFive,goodSix,goodSeven,goodEight,goodNine,goodTen;
        List<XCRoundImageView> a=new ArrayList<XCRoundImageView>();
        TextView goodOneName,goodTwoName,goodThreeName,goodFourName, goodFiveName,goodSixName,goodSevenName,goodEightName,goodNineName,goodTenName;
        //在按钮响应//MainActivity.this 为当前窗体，LoginActivity.class 为跳到的第二个窗体


        public GoodsListHolder(View itemView) {
            super(itemView);

            goodOne= itemView.findViewById(R.id.goods_one);
            goodTwo= itemView.findViewById(R.id.goods_two);
            goodThree= itemView.findViewById(R.id.goods_three);
            goodFour= itemView.findViewById(R.id.goods_four);
            goodFive= itemView.findViewById(R.id.goods_five);
            goodSix= itemView.findViewById(R.id.goods_six);
            goodSeven= itemView.findViewById(R.id.goods_seven);
            goodEight= itemView.findViewById(R.id.goods_eight);
            goodNine= itemView.findViewById(R.id.goods_nine);
            goodTen= itemView.findViewById(R.id.goods_ten);


            goodOneName= itemView.findViewById(R.id.goods_one_name);
            goodTwoName= itemView.findViewById(R.id.goods_two_name);
            goodThreeName= itemView.findViewById(R.id.goods_three_name);
            goodFourName= itemView.findViewById(R.id.goods_four_name);
            goodFiveName= itemView.findViewById(R.id.goods_five_name);
            goodSixName= itemView.findViewById(R.id.goods_six_name);
            goodSevenName= itemView.findViewById(R.id.goods_seven_name);
            goodEightName= itemView.findViewById(R.id.goods_eight_name);
            goodNineName= itemView.findViewById(R.id.goods_nine_name);
            goodTenName= itemView.findViewById(R.id.goods_ten_name);





        }
    }

    /**
     * 广告的ViewHolder
     */
    public static class AdvHolder extends RecyclerView.ViewHolder {

        Banner smallbanner;
        public AdvHolder(View itemView) {

            super(itemView);
         //   advImage = (ImageView) itemView.findViewById(R.id.adv_image);
            smallbanner= itemView.findViewById(R.id.small_banner);

        }
    }

    /**
     * 错乱的布局ViewHolder
     */
    public static class FiveItemHolder extends RecyclerView.ViewHolder {


        public  FiveItemHolder(View itemView) {
            super(itemView);


        }
    }


    class GoodsViewHolder extends RecyclerView.ViewHolder {


        TextView goodPrice,juanPrice,goodsCharge,goodTitle,monthSale;
        ImageView goodsPicture;


        public GoodsViewHolder(View view) {
            super(view);

            goodPrice= view.findViewById(R.id.goods_price);
            goodPrice.setTextColor(Color.parseColor("#f43019") );
           juanPrice= view.findViewById(R.id.juan_price);
      //     juanPrice.setTextColor(Color.parseColor("#f43019") );

         goodsCharge= view.findViewById(R.id.good_charges);
        goodTitle= view.findViewById(R.id.good_title);
           monthSale= view.findViewById(R.id.month_sale);
         goodsPicture= view.findViewById(R.id.goods_picture);




        }

    }



    public void loadmore(Goodses bean){
        //增加数据
        if(this.list == null){
            this.list = new ArrayList<Goods>();
        }
        int position=list.size();
        list.addAll(position,bean.getResult_list());
        notifyDataSetChanged();

    }
    /**
     * 设置轮播图
     *
     * @param bannerHolder
     */

    private void setBanner(BannerHolder bannerHolder) {
        //设置banner样式
        bannerHolder.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        bannerHolder.banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        bannerHolder.banner.setImages(picList);
        //设置banner动画效果
        bannerHolder.banner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
//            bannerHolder.banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        bannerHolder.banner.isAutoPlay(true);

        //设置轮播时间
//            bannerHolder.banner.setDelayTime(3500);
        //设置指示器位置（当banner模式中有指示器时）
        bannerHolder.banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        bannerHolder.banner.start();
        bannerHolder.banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

                Intent intent = new Intent(mContext,GoodsDetailsActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("data", list.get(5));//序列化

                intent.putExtras(bundle);

                //      intent.putExtra("data",list.get(position-4));
                mContext.startActivity(intent);
            }
        });
    }
    private void setSmallBanner(AdvHolder bannerHolder) {
        //设置banner样式
        bannerHolder.smallbanner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //设置图片加载器
        bannerHolder.smallbanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        bannerHolder.smallbanner.setImages(smallbanner);
        //设置banner动画效果
        bannerHolder.smallbanner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
//            bannerHolder.banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        bannerHolder.smallbanner.isAutoPlay(false);

        //设置轮播时间
//            bannerHolder.banner.setDelayTime(3500);
        //设置指示器位置（当banner模式中有指示器时）
   // bannerHolder.smallbanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        bannerHolder.smallbanner.start();
        bannerHolder.smallbanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

                Intent intent = new Intent(mContext,GoodsDetailsActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("data", list.get(5));//序列化

                intent.putExtras(bundle);

                //      intent.putExtra("data",list.get(position-4));
                mContext.startActivity(intent);
            }
        });
    }


    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //Glide 加载图片简单用法
            Glide.with(context).load(path).into(imageView);
        }
    }
}