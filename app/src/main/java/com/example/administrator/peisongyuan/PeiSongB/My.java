package com.example.administrator.peisongyuan.PeiSongB;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.peisongyuan.PeiSongA.My_menu.Historical_Order;
import com.example.administrator.peisongyuan.PeiSongA.My_menu.Set_Up;
import com.example.administrator.peisongyuan.R;


public class My extends Fragment{
    // 缓存Fragment view
    private View rootView;
    private static My my;
    public My(){}
    public static My getNewInstance(){
        if (my ==null){
            my =new My();
        }
        return my;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_my, container, false);
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
        TextView FeedBack = (TextView) getActivity().findViewById(R.id.id_my_feedback);
        TextView Set_up=(TextView) getActivity().findViewById(R.id.id_my_SetUp);
        TextView historical_order=(TextView) getActivity().findViewById(R.id.id_historical_order);

        FeedBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), com.example.administrator.peisongyuan.PeiSongA.My_menu.FeedBack.class) ;
                startActivity(intent);
            }
        });


        Set_up.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), Set_Up.class) ;
                startActivity(intent);
            }
        });

        historical_order.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), Historical_Order.class) ;
                startActivity(intent);
            }
        });
    }
    public void onReceive(Context context, Intent intent) {
        //通过getSystemService()方法得到connectionManager这个系统服务类，专门用于管理网络连接
        ConnectivityManager connectionManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            Toast.makeText(context, "网络可用", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "网络不可用", Toast.LENGTH_SHORT).show();
        }
    }
}
