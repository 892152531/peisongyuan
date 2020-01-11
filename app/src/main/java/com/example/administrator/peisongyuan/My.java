package com.example.administrator.peisongyuan;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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
        TextView Data_order=(TextView) getActivity().findViewById(R.id.id_my_DataOrder) ;
        TextView historical_order=(TextView) getActivity().findViewById(R.id.id_historical_order);

        FeedBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), com.example.administrator.peisongyuan.My_menu.FeedBack.class) ;
                startActivity(intent);
            }
        });

        Data_order.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), com.example.administrator.peisongyuan.My_menu.Data_Order.class) ;
                startActivity(intent);
            }
        });

        Set_up.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), com.example.administrator.peisongyuan.My_menu.Set_Up.class) ;
                startActivity(intent);
            }
        });

        historical_order.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), com.example.administrator.peisongyuan.My_menu.Historical_Order.class) ;
                startActivity(intent);
            }
        });
    }
}
