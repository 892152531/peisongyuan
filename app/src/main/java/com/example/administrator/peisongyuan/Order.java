package com.example.administrator.peisongyuan;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.peisongyuan.Order_top.End_sent;
import com.example.administrator.peisongyuan.Order_top.Sent_in;
import com.example.administrator.peisongyuan.Order_top.Un_sent;

import java.util.List;


public class Order extends Fragment{

    private RadioGroup mNavGroup;
    private FragmentTransaction mTransaction;
    RadioButton NO_SONG;
    RadioButton ZAI_SONG;
    RadioButton END;
    Fragment End_sent,Sent_in,Un_sent;
    public static final int UN = 0;
    public static final int IN= 1;
    private int temp_position_index = -1;
    private Context MainActivity;
    private RadioGroup Order_top;
    private com.example.administrator.peisongyuan.Order_top.Sent_in sent_in;
    private com.example.administrator.peisongyuan.Order_top.Un_sent un_sent;
    private com.example.administrator.peisongyuan.Order_top.End_sent end_sent;
    private LayoutInflater inflater;
    private ViewPager ViewPager;
    private RadioGroup group;
    ViewPager OrderActivityViewPager;
    BottomNavigationView bottomNavView;
    OrderViewAdapt adapter;


    // 缓存Fragment view
    private View rootView;
    private static Order order;
    private List<TextView> textViewList;
    private int mDefaultColor= Color.BLACK;
    private int mActiveColor=Color.RED;



    public Order() {
    }

    public static Order getNewInstance() {
        if (order == null) {
            order = new Order();
        }
        return order;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        initView();
//        OrderActivityViewPager=(ViewPager) getActivity().findViewById(R.id.main_viewpager);
//        bottomNavView = (BottomNavigationView) getActivity().findViewById(R.id.main_bottom_nav_view);
//        adapter = new OrderViewAdapt(getActivity().getSupportFragmentManager());
////        为Adapter添加Fragment
//        adapter.addFragment(new Un_sent());
//        adapter.addFragment(new End_sent());
//        adapter.addFragment(new Sent_in());
//        OrderActivityViewPager.setAdapter(adapter);
//        OrderActivityViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            @Override
//            public void onPageSelected(int position) {
////                当 ViewPager 滑动后设置BottomNavigationView 选中相应选项
//                bottomNavView.getMenu().getItem(position).setChecked(true);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_order, container, false);
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
//        MainActivity = getActivity();
//        inflater = LayoutInflater.from(getActivity());
//        NO_SONG = (RadioButton) getActivity().findViewById(R.id.id_un_sent_BUTTON);
//        ZAI_SONG = (RadioButton) getActivity().findViewById(R.id.id_sent_in_BUTTON);
//        END=(RadioButton) getActivity().findViewById(R.id.id_end_sent_BUTTON);
//        ZAI_SONG.setOnClickListener(this);
//        NO_SONG.setOnClickListener(this);
//        END_SONG.setOnClickListener(this);
//        END_SONG.setOnClickListener(this);

//        mainActivityViewPager = (ViewPager) getActivity().findViewById(R.id.viewPager);

        End_sent = com.example.administrator.peisongyuan.Order_top.End_sent.getNewInstance();
        Un_sent = com.example.administrator.peisongyuan.Order_top.Un_sent.getNewInstance();
        Sent_in = com.example.administrator.peisongyuan.Order_top.Sent_in.getNewInstance();
        setDefaultFragment();
        Button NO_SONG = (Button) getActivity().findViewById(R.id.id_un_sent_BUTTON);
        Button ZAI_SONG = (Button) getActivity().findViewById(R.id.id_sent_in_BUTTON);
        Button END = (Button) getActivity().findViewById(R.id.id_end_sent_BUTTON);
        mTransaction.replace(R.id.Order_reltivelayout, un_sent);
//        initView();
   //     显示
        NO_SONG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                un_sent = new Un_sent();
                mTransaction = getChildFragmentManager().beginTransaction();
                mTransaction.replace(R.id.Order_reltivelayout,Un_sent);
                mTransaction.commit();
            }
        });

        ZAI_SONG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sent_in = new Sent_in();
                mTransaction = getChildFragmentManager().beginTransaction();
                mTransaction.replace(R.id.Order_reltivelayout,Sent_in);
                mTransaction.commit();
            }
        });

        END.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                end_sent= new End_sent();
//                Un_sent=new Un_sent();
                mTransaction = getChildFragmentManager().beginTransaction();
                mTransaction.replace(R.id.Order_reltivelayout,End_sent);
                mTransaction.commit();
            }
        });

        //        为Adapter添加Fragment
//        OrderActivityViewPager=(ViewPager) getActivity().findViewById(R.id.main_viewpager);
//        bottomNavView = (BottomNavigationView) getActivity().findViewById(R.id.main_bottom_nav_view);
//        adapter = new OrderViewAdapt(getActivity().getSupportFragmentManager());
//        adapter.addFragment(new Un_sent());
//        adapter.addFragment(new End_sent());
//        adapter.addFragment(new Sent_in());
//        OrderActivityViewPager.setAdapter(adapter);
//
//        //设立侧滑跳转页面功能
//        OrderActivityViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            @Override
//            public void onPageSelected(int position) {
////                当 ViewPager 滑动后设置BottomNavigationView 选中相应选项
//                bottomNavView.getMenu().getItem(position).setChecked(true);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
}






    private void initView() {
        Order_top = (RadioGroup) getActivity().findViewById(R.id.id_Order);
        //显示
//        un_sent=new Un_sent();
//        mTransaction = getChildFragmentManager().beginTransaction();
//        mTransaction.replace(R.id.id_Order,un_sent );
        sent_in = new Sent_in();
        mTransaction = getChildFragmentManager().beginTransaction();
        mTransaction.replace(R.id.Order_reltivelayout,Sent_in);
        mTransaction.commit();
        return;
    }







    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
//        sent_in= new Sent_in();
//        transaction.add(R.id.id_Order, sent_in).commit();
        Order_top = (RadioGroup) getActivity().findViewById(R.id.id_navcontent);
        //显示
        un_sent=new Un_sent();
        mTransaction = getChildFragmentManager().beginTransaction();
        mTransaction.replace(R.id.Order_reltivelayout,un_sent );
        mTransaction.commit();
        return;
    }

}
