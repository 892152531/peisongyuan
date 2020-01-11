package com.example.administrator.peisongyuan.Card;

/**
 * Created by Administrator on 2020/1/8 0008.
 */

public class Goods {
    private String shop;  //店铺名
    private String hostel;   //宿舍号
    private String good_name;    //商品名
    private String phone_name;  //电话号
    private int status;   //状态
    private double price;  //价格
    private int imageId;  //图片


    public Goods(String shop,String hostel,String good_name,String phone_name,int state,int price,int imageId){
        this.shop=shop;
        this.hostel=hostel;
        this.good_name=good_name;
        this.phone_name=phone_name;
        this.status=state;
        this.price=price;
        this.imageId=imageId;
    }

    public String getShop(){return shop;}
    public String getHostel(){return hostel;}
    public String getgood_name(){return good_name;}
    public String getPhone_name(){return phone_name;}
    public int getStatus(){return status;}
    public double getPrice(){return price;}
    public int getImageId(){return imageId;}
}
