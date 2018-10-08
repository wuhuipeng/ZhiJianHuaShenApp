package adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.bean.Goods;
import com.husheng.riji.husshen2.bean.Goodses;
import com.husheng.riji.husshen2.ui.GoodsDetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GoodsListSortAdapter extends   RecyclerView.Adapter<GoodsListSortAdapter .ViewHolder> {
    private ArrayList<Goods> list;

    private Context mContext;
    private LayoutInflater inflater;
    public GoodsListSortAdapter(Context mContext) {
        this.mContext=mContext;

        inflater= LayoutInflater.from(mContext);
    }
    public int getItemViewType(int position) {


        return position;

    }

    /**
     * 加载更多数据
     * @param bean
     */
    public void loadmore(Goodses bean){
        //增加数据
        if(this.list == null){
            this.list = new ArrayList<Goods>();
        }
        int position=list.size();
        list.addAll(position,bean.getResult_list());
        notifyDataSetChanged();

    }
    @Override
    public GoodsListSortAdapter .ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.good_sort_list_item, parent, false);
        GoodsListSortAdapter .ViewHolder viewHolder = new GoodsListSortAdapter .ViewHolder(view);
        return viewHolder;

    }
    public void setData(Goodses bean){
        if(this.list == null){
            this.list = new ArrayList<Goods>();
        }
        this.list= (ArrayList<Goods>) bean.getResult_list();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(GoodsListSortAdapter .ViewHolder holder,final int position) {
        //holder.mText.setText(list.get(position));
        holder.predictPrice.setText("预计佣金：￥"+list.get(position).getCommission_rate());
       holder.salePrice.setText("￥"+String.valueOf(list.get(position).getReserve_price()));
       holder.taoPrice.setText("淘宝价￥"+String.valueOf(list.get(position).getZk_final_price()));
       holder.title.setText(list.get(position).getTitle());
       holder.montheSale.setText("月销"+list.get(position).getTk_total_sales()+"笔");
       Picasso.get().load(list.get(position).getPict_url()).into(holder.goodsImage);

       holder.item.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(mContext,GoodsDetailsActivity.class);
               Bundle bundle=new Bundle();
               bundle.putSerializable("data", list.get(position));//序列化

               intent.putExtras(bundle);

               //      intent.putExtra("data",list.get(position-4));
               mContext.startActivity(intent);
           }
       });


    }

    @Override
    public int getItemCount() {
        return list == null ? 0 :list.size();
    }
    //下面两个方法提供给页面刷新和加载时调用
//    public void refresh(List<String> addList) {
//        //增加数据
//        int position = list.size();
//        list.addAll(position, addList);
//        notifyDataSetChanged();
//    }
//


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,montheSale,taoPrice,salePrice,predictPrice;
        ImageView  goodsImage;
        LinearLayout item;
        ViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.sort_title);
            goodsImage=itemView.findViewById(R.id.sort_image);
            montheSale=itemView.findViewById(R.id.month_sale_text);
            taoPrice=itemView.findViewById(R.id.taobaoprice_text);
            salePrice=itemView.findViewById(R.id.sort_price_text);
            predictPrice=itemView.findViewById(R.id.predict_money_text);
            item=itemView.findViewById(R.id.goods_sort_list);

        }
    }
}