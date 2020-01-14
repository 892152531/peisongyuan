package com.example.administrator.peisongyuan.PeiSongA.Order_top;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.peisongyuan.PeiSongA.Card.Goods;
import com.example.administrator.peisongyuan.PeiSongA.Card.GoodsAdapt;
import com.example.administrator.peisongyuan.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Un_sent extends Fragment{
    // 缓存Fragment view
    private SwipeRefreshLayout swipeRefresh;   //下拉刷新组件
    private View rootView;
    private static Un_sent un_sent;
    String phone="1008611";
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
//    private Goods[] goods={new Goods("雅之味","2-7-201","炒河粉","18588974945",0,15,R.drawable.mango),
//    new Goods("爱时尚","3-5-401","煮河粉","14684861235",1,22, R.drawable.banana)
//    };


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

    //显示数据
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView recyclerView=(RecyclerView)getActivity().findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new GoodsAdapt(goodsList);
        recyclerView.setAdapter(adapter);
        sendRequestWithOkHttp();
//        initgoods();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
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

    //链接后台
    private void sendRequestWithOkHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("phone", "1008611")
                            .build();
                    Request request = new Request.Builder()
                            .url("https://www.vlxinxiaoyuan.top/xxytestapp/LAndR/test.php")
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    parseJSONWithGSON(responseData);
//                    showResponse(responseData);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private Goods[] goods={new Goods("雅之味","2-7-201","炒河粉","18588974945",0,15,R.drawable.mango),
            new Goods("爱时尚","3-5-401","煮河粉","14684861235",1,22, R.drawable.banana)
            };
//    };

    private Goods[] tests;
    //取数据
    private void parseJSONWithGSON(String jsonData) {
        Log.d("MainActivity", "wellin");
        Gson gson = new Gson();
        Goods app = gson.fromJson(jsonData, Goods.class);
        Log.d("MainActivity", "name is" + app.getShop());
        Log.d("MainActivity", "goods is" + app.getgood_name());
        Log.d("MainActivity", "address is" + app.getaddress());
        Log.d("MainActivity", "Price is" + app.getPrice());
        Log.d("MainActivity", "Status is" + app.getStatus());
//        goodsList.clear();
//        tests= new Goods[]{new Goods(app.getShop(), app.getaddress(), app.getgood_name(), "1008611",
//                Integer.parseInt(String.valueOf(app.getStatus())),
//                10, R.drawable.cherry)};
        Goods[] test={new Goods(app.getShop(), app.getaddress(), app.getgood_name(), "1008611",
                Integer.parseInt(String.valueOf(app.getStatus())),
                10, R.drawable.cherry)
        };
        goodsList.add(test[0]);
//        goodsList.add(tests);
        Log.d("MainActivity", "test is" +goods[3]);
//        goods= new Goods[]{new Goods(app.getShop(), app.getaddress(), app.getgood_name(), "18588974945",
//                Integer.parseInt(String.valueOf(app.getStatus())),
//                Integer.parseInt(String.valueOf(app.getPrice())), R.drawable.cherry)};



//        goodsList.add(app.getShop(),app.getaddress(),app.getgood_name(),"1008611",
//                Integer.parseInt(String.valueOf(app.getStatus())),
//                Integer.parseInt(String.valueOf(app.getPrice())),
//                R.drawable.cherry);
    }



  //将数据导入到数组中
    private void initgoods(){
        goodsList.clear();
        for(int i=0;i<2;i++){
            goodsList.add(goods[i]);
        }
//        int index=tests.length;
//        goodsList.add(tests[index]);
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
//                        initgoods();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
}

