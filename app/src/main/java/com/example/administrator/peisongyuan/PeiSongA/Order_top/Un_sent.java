package com.example.administrator.peisongyuan.PeiSongA.Order_top;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.peisongyuan.PeiSongA.Card.Goods;
import com.example.administrator.peisongyuan.PeiSongA.Card.GoodsAdapt;
import com.example.administrator.peisongyuan.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Un_sent extends Fragment{
    // 缓存Fragment view
    private SwipeRefreshLayout swipeRefresh;   //下拉刷新组件
    private View rootView;
    private static Un_sent un_sent;
    public Un_sent(){}
    public static Un_sent getNewInstance(){
        if (un_sent ==null){
            un_sent =new Un_sent();
        }
        return un_sent;
    }

    private List<Goods> goodsList=new ArrayList<>();
    private GoodsAdapt adapter;

    //Card 定义
    private Goods[] goods={new Goods("雅之味","2-7-201","炒河粉","18588974945",0,15,R.drawable.mango),
    new Goods("爱时尚","3-5-401","煮河粉","14684861235",1,22, R.drawable.banana)
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_un_sent, container, false);
        }
        // 缓存的rootView需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initgoods();
        RecyclerView recyclerView=(RecyclerView)getActivity().findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new GoodsAdapt(goodsList);
        recyclerView.setAdapter(adapter);

        //下拉刷新功能
        swipeRefresh=(SwipeRefreshLayout) getActivity().findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.
                OnRefreshListener(){
            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });
    }


  //将数据导入到数组中
    private void initgoods(){
        goodsList.clear();
        for(int i=0;i<10;i++){
            Random random=new Random();
            int index=random.nextInt(goods.length);
            goodsList.add(goods[index]);
        }
    }

    //下拉刷新函数
    private void refreshFruits() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable(){
                    @Override
                    public void run(){
                        initgoods();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
}

