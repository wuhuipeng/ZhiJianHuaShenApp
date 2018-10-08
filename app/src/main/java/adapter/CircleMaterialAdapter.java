package adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


import com.husheng.riji.husshen2.R;


import java.util.List;



public class CircleMaterialAdapter extends RecyclerView.Adapter<CircleMaterialAdapter.ViewHolder> {
    private List<String> list;
    private Context mContext;
    private LayoutInflater inflater;
    public CircleMaterialAdapter(Context mContext, List<String> list) {
        this.list = list;
        this.mContext=mContext;

        inflater= LayoutInflater.from(mContext);
    }
    public int getItemViewType(int position) {


            return position;

    }
    @Override
    public CircleMaterialAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_circle_materialitem, parent, false);
        CircleMaterialAdapter.ViewHolder viewHolder = new CircleMaterialAdapter.ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(CircleMaterialAdapter.ViewHolder holder, int position) {
  //      holder.mText.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    //下面两个方法提供给页面刷新和加载时调用
    public void refresh(List<String> addList) {
        //增加数据
        int position = list.size();
        list.addAll(position, addList);
        notifyDataSetChanged();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mText;
        ViewHolder(View itemView) {
            super(itemView);
            mText = itemView.findViewById(R.id.write_content);
        }
    }
}