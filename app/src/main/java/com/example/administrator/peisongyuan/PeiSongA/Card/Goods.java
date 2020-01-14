package com.example.administrator.peisongyuan.PeiSongA.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/1/8 0008.
 */

public class Goods {
    List<Integer> Goods=new ArrayList<Integer>();
    private String shop;             //店铺名
    private String address;          //宿舍号
    private String goods;      //商品名
    private String phone_name;    //电话号
    private int status;          //状态
    private double price;       //价格
    private int imageId;       //图片


    public Goods(String shop,String address,String good_name,String phone_name,int state,int price,int imageId){
        this.shop=shop;
        this.address=address;
        this.goods=good_name;
        this.phone_name=phone_name;
        this.status=state;
        this.price=price;
        this.imageId=imageId;
    }

    public String getShop(){return shop;}
    public String getaddress(){return address;}
    public String getgood_name(){return goods;}
    public String getPhone_name(){return phone_name;}
    public int getStatus(){return status;}
    public double getPrice(){return price;}
    public int getImageId(){return imageId;}
}
