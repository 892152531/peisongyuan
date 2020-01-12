package com.example.administrator.peisongyuan.PeiSongA;

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

import com.example.administrator.peisongyuan.PeiSongA.Order_top.End_sent;
import com.example.administrator.peisongyuan.PeiSongA.Order_top.Sent_in;
import com.example.administrator.peisongyuan.PeiSongA.Order_top.Un_sent;
import com.example.administrator.peisongyuan.R;

import java.util.ArrayList;
import java.util.List;


public class Order extends Fragment implements ViewPager.OnPageChangeListener {

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
    private com.example.administrator.peisongyuan.PeiSongA.Order_top.Sent_in sent_in;
    private com.example.administrator.peisongyuan.PeiSongA.Order_top.Un_sent un_sent;
    private com.example.administrator.peisongyuan.PeiSongA.Order_top.End_sent end_sent;
    private LayoutInflater inflater;
    private RadioGroup group;
    private OrderViewAdapt madapter;




    // 缓存Fragment view
    private View rootView;
    private static Order order;
    private List<TextView> textViewList;
    private int mDefaultColor= Color.BLACK;
    private int mActiveColor=Color.RED;
    private List<Fragment> fragmentList;
    BottomNavigationView bottomNavView;
    OrderViewAdapt Adapter;

    //test
    private List<Fragment> list;
    private ViewPager myViewPager;
    private OrderViewAdapt adapter;



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
        End_sent = com.example.administrator.peisongyuan.PeiSongA.Order_top.End_sent.getNewInstance();
        Un_sent = com.example.administrator.peisongyuan.PeiSongA.Order_top.Un_sent.getNewInstance();
        Sent_in = com.example.administrator.peisongyuan.PeiSongA.Order_top.Sent_in.getNewInstance();
        setDefaultFragment();
        Button NO_SONG = (Button) getActivity().findViewById(R.id.id_un_sent_BUTTON);
        Button ZAI_SONG = (Button) getActivity().findViewById(R.id.id_sent_in_BUTTON);
        Button END = (Button) getActivity().findViewById(R.id.id_end_sent_BUTTON);
        mTransaction.replace(R.id.Order_reltivelayout, un_sent);
//        initView();

        NO_SONG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                un_sent = new Un_sent();
//                mViewPager.setCurrentItem(0);
                mTransaction = getChildFragmentManager().beginTransaction();
                mTransaction.replace(R.id.Order_reltivelayout,Un_sent);
                mTransaction.commit();
            }
        });

        ZAI_SONG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sent_in = new Sent_in();
//                mViewPager.setCurrentItem(1);
                mTransaction = getChildFragmentManager().beginTransaction();
                mTransaction.replace(R.id.Order_reltivelayout,Sent_in);
                mTransaction.commit();
            }
        });

        END.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                end_sent= new End_sent();
//                mViewPager.setCurrentItem(2);
//                Un_sent=new Un_sent();
                mTransaction = getChildFragmentManager().beginTransaction();
                mTransaction.replace(R.id.Order_reltivelayout,End_sent);
                mTransaction.commit();
            }
        });

    }






private void initView()
{
    myViewPager = (ViewPager) getActivity().findViewById(R.id.myViewPager);
    //绑定点击事件
//        myViewPager.setOnPageChangeListener(new MyPagerChangeListener()) ;
    //把Fragment添加到List集合里面
    list = new ArrayList<>();
    list.add(new Un_sent() );
    list.add(new End_sent() );
    list.add(new Un_sent());
    adapter = new OrderViewAdapt(getChildFragmentManager(), list);
    myViewPager.setAdapter(adapter);
    myViewPager.setCurrentItem(1);  //初始化显示第一个页面

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

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}