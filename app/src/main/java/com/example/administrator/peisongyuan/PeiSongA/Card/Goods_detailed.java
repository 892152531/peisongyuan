package com.example.administrator.peisongyuan.PeiSongA.Card;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.peisongyuan.R;

import java.util.List;

public class Goods_detailed extends AppCompatActivity implements View.OnClickListener{

    public static final String GOODS_SHOP="fruit_name";
    public static final String GOODS_IMAGE="fruit_image_id";
    private Context mContext;
    private List<Goods> mGoodsList;
    CardView cardView;
    ImageView goodsImage;
    TextView goodsName,goodsShop,goodshostel,goodstrade,goodsphone_name,goodsprice;
    String Shoper_phone,Sent_B_phone,Customer_phone;      //声明商家，送货员B，客户电话


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_goods_detailed);
        Intent intent=getIntent();
        String fruitName=intent.getStringExtra(GOODS_SHOP);
        int fruitImageId=intent.getIntExtra(GOODS_IMAGE,0);
        goodsName=(TextView)findViewById(R.id.id_goods_shop);
        goodstrade=(TextView)findViewById(R.id.id_trade);
        goodshostel=(TextView)findViewById(R.id.id_hostel);
        goodsprice=(TextView)findViewById(R.id.id_price);
        Shoper_phone="18588974945";       //录入商家，送货员，用户电话号码
        Sent_B_phone="13539911439";
        Customer_phone="12345678910";
        Button call_shoper_phone=(Button) findViewById(R.id.detailed_shoper_phone);    //注册商家，送货员B，用户拨号按钮
        Button call_sentB_phone=(Button) findViewById(R.id.detailed_sent_B_phone);
        Button call_customer_phone=(Button) findViewById(R.id.detailed_customer_phone);
        call_shoper_phone.setOnClickListener((View.OnClickListener) this);
        call_sentB_phone.setOnClickListener((View.OnClickListener) this);
        call_customer_phone.setOnClickListener((View.OnClickListener) this);
//        CollapsingToolbarLayout collapsingToolbar=(CollapsingToolbarLayout)findViewById(R.id.id_deliver_shop);
//        ImageView fruitImageView=(ImageView) findViewById(R.id.id_goods_image);
        TextView fruitContentText=(TextView) findViewById(R.id.detailed_shop);
        fruitContentText.setText(fruitName);
//        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
//        collapsingToolbar.setTitle(fruitName);
//        Glide.with(this).load(fruitImageId).into(fruitImageView);
//        String fruitContent=generateFruitContent(fruitName);
//        fruitContentText.setText(fruitContent);
    }



    private String generateFruitContent(String fruitName)
    {
        StringBuilder fruitContent=new StringBuilder();
        for(int i=0;i<10;i++){
            fruitContent.append("yes");
        }
        return  fruitContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    private class CollapsingToolbarLayout {
    }

    //拨号功能
    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    //设置打电话按钮的点击事件

    public void onClick(View v){
        switch(v.getId()){
            case R.id.detailed_sent_B_phone:{
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+Sent_B_phone));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
            break;
            case R.id.detailed_customer_phone:{
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+Customer_phone));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
            break;
            case R.id.detailed_shoper_phone:{
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+Shoper_phone));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
            break;
            default:
                break;
        }
    }

}
