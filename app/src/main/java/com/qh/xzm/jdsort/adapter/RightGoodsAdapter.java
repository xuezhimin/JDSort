package com.qh.xzm.jdsort.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qh.xzm.jdsort.R;
import com.qh.xzm.jdsort.bean.RightBeanInner;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RightGoodsAdapter extends RecyclerView.Adapter<RightGoodsAdapter.MyGoodsViewHolder> {

    private Context mContext;
    private List<RightBeanInner> mListBeans = new ArrayList<>();

    public RightGoodsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void addAll(List<RightBeanInner> dataBeans) {
        if (dataBeans != null) {
            mListBeans.addAll(dataBeans);
            notifyDataSetChanged();
        }
    }




    @NonNull
    @Override
    public MyGoodsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //布局
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_right_goods_view, viewGroup, false);
        return new MyGoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyGoodsViewHolder myGoodsViewHolder, int i) {
        Glide.with(mContext).load(mListBeans.get(i).getIcon()).into(myGoodsViewHolder.mCircleImageViewImg);
        myGoodsViewHolder.mTextViewName.setText(mListBeans.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return mListBeans == null ? 0 : mListBeans.size();
    }

    //自定义viewholder
    class MyGoodsViewHolder extends RecyclerView.ViewHolder{
        CircleImageView mCircleImageViewImg;
        TextView mTextViewName;
        public MyGoodsViewHolder(@NonNull View itemView) {
            super(itemView);
            mCircleImageViewImg = itemView.findViewById(R.id.goods_c_imgicon);
            mTextViewName = itemView.findViewById(R.id.goods_right_txt_name);
        }
    }
}
