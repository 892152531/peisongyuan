package com.example.administrator.peisongyuan.PeiSongA.Card;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.peisongyuan.R;

import java.util.List;


public class GoodsAdapt extends RecyclerView.Adapter<GoodsAdapt.ViewHolder> {
    private Context mContext;
    private List<Goods> mGoodsList;
    public GoodsAdapt(List<Goods>goodsList){mGoodsList=goodsList;}

    static  class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView goodsImage;
        TextView goodsName,goodsShop,goodshostel,goodstrade,goodsphone_name,goodsprice;

        public ViewHolder(View view){
            super(view);
            cardView=(CardView) view;
            goodsImage=(ImageView) view.findViewById(R.id.id_goods_image);
            goodsName=(TextView) view.findViewById(R.id.id_goods_shop);
            goodstrade=(TextView) view.findViewById(R.id.id_trade);
            goodshostel=(TextView)view.findViewById(R.id.id_hostel);
            goodsprice=(TextView)view.findViewById(R.id.id_price);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.goods_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
//        点击后触发事件
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position=holder.getAdapterPosition();
                Goods goods=mGoodsList.get(position);
                Intent intent=new Intent(mContext,Goods_detailed.class);
                intent.putExtra(Goods_detailed.GOODS_SHOP,goods.getShop());
                intent.putExtra(Goods_detailed.GOODS_NAME,goods.getgood_name());
                intent.putExtra(Goods_detailed.GOODS_PRICE,"10");
//                intent.putExtra(Goods_detailed.GOODS_NAME,goods.getgood_name());
                Log.d("MainActivity","OUT:"+goods.getPrice());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Goods goods=mGoodsList.get(position);
        holder.goodsName.setText(goods.getShop());
        holder.goodstrade.setText(goods.getgood_name());
        holder.goodshostel.setText(goods.getaddress());
        holder.goodsprice.setText(goods.getPrice()+" ");  //int型转String型
        Glide.with(mContext).load(goods.getImageId()).into(holder.goodsImage);
    }

    @Override
    public int getItemCount(){
        return mGoodsList.size();
    }
}