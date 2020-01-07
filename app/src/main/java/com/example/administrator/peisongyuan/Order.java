package com.example.administrator.peisongyuan;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.peisongyuan.Order_top.End_sent;
import com.example.administrator.peisongyuan.Order_top.Sent_in;
import com.example.administrator.peisongyuan.Order_top.Un_sent;


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
//    private com.example.administrator.peisongyuan.Order_top.End_sent end_sent;
    private com.example.administrator.peisongyuan.Order_top.End_sent end_sent;
    private LayoutInflater inflater;


    // 缓存Fragment view
    private View rootView;
    private static Order order;




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
        MainActivity = getActivity();
        inflater = LayoutInflater.from(getActivity());
//        NO_SONG = (RadioButton) getActivity().findViewById(R.id.id_un_sent_BUTTON);
//        ZAI_SONG = (RadioButton) getActivity().findViewById(R.id.id_sent_in_BUTTON);
//        END=(RadioButton) getActivity().findViewById(R.id.id_end_sent_BUTTON);
//        ZAI_SONG.setOnClickListener(this);
//        NO_SONG.setOnClickListener(this);
//        END_SONG.setOnClickListener(this);
//        END_SONG.setOnClickListener(this);
        End_sent = com.example.administrator.peisongyuan.Order_top.End_sent.getNewInstance();
        Un_sent = com.example.administrator.peisongyuan.Order_top.Un_sent.getNewInstance();
        Sent_in = com.example.administrator.peisongyuan.Order_top.Sent_in.getNewInstance();

        setDefaultFragment();
        Button NO_SONG = (Button) getActivity().findViewById(R.id.id_un_sent_BUTTON);
        Button ZAI_SONG = (Button) getActivity().findViewById(R.id.id_sent_in_BUTTON);
        Button END = (Button) getActivity().findViewById(R.id.id_end_sent_BUTTON);
        mTransaction.replace(R.id.id_Order, un_sent);
//        initView();
   //     显示
        NO_SONG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                un_sent = new Un_sent();
                mTransaction = getChildFragmentManager().beginTransaction();
                mTransaction.replace(R.id.id_Order,Un_sent);
                mTransaction.commit();
            }
        });

        ZAI_SONG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sent_in = new Sent_in();
                mTransaction = getChildFragmentManager().beginTransaction();
                mTransaction.replace(R.id.id_Order,Sent_in);
                mTransaction.commit();
            }
        });

        END.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                end_sent= new End_sent();
//                Un_sent=new Un_sent();
                mTransaction = getChildFragmentManager().beginTransaction();
                mTransaction.replace(R.id.id_Order,End_sent);
                mTransaction.commit();
            }
        });

//        Order_top.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager fm = getFragmentManager();
//                // 开启Fragment事务
//                FragmentTransaction transaction = fm.beginTransaction();
////              Toast.makeText(getContext(), "in", Toast.LENGTH_SHORT).show();
//                //String username=user.getUsername().toString();
//                switch (v.getId()) {
//                    case R.id.id_un_sent_BUTTON:
//                        if (temp_position_index != UN) {
//                            //显示
//                            mTransaction = getChildFragmentManager().beginTransaction();
//                            mTransaction.replace(R.id.id_Order, un_sent);
//                            mTransaction.commit();
//                        }
//                        temp_position_index = IN;
//                        break;
//                    case R.id.id_sent_in_BUTTON:
//                        if (temp_position_index != IN) {
//                            //显示
//                            mTransaction = getChildFragmentManager().beginTransaction();
//                            mTransaction.replace(R.id.id_Order, sent_in);
//                            mTransaction.commit();
//                        }
//                        temp_position_index = IN;
//                        break;
//                    case R.id.id_end_sent_BUTTON:
//                        if (temp_position_index != END) {
//                            //显示
//                            mTransaction = getChildFragmentManager().beginTransaction();
//                            mTransaction.replace(R.id.id_Order, end_sent);
//                            mTransaction.commit();
//                        }
//                        temp_position_index = END;
//                        break;
//                }
//            }
//    });
}

    private void initView() {
        Order_top = (RadioGroup) getActivity().findViewById(R.id.id_Order);
        //显示
//        un_sent=new Un_sent();
//        mTransaction = getChildFragmentManager().beginTransaction();
//        mTransaction.replace(R.id.id_Order,un_sent );
        sent_in = new Sent_in();
        mTransaction = getChildFragmentManager().beginTransaction();
        mTransaction.replace(R.id.id_Order,Sent_in);
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
        mTransaction.replace(R.id.id_Order,un_sent );
        mTransaction.commit();
        return;
    }

//    @Override
//    public void onClick(View view) {
//        FragmentManager fm = getFragmentManager();
//        // 开启Fragment事务
//        FragmentTransaction transaction = fm.beginTransaction();
//
//        // 开启Fragment事务
////              Toast.makeText(getContext(), "in", Toast.LENGTH_SHORT).show();
//        //String username=user.getUsername().toString();
//        switch (view.getId()){
//        case R.id.id_un_sent_BUTTON:
//        if (temp_position_index != UN) {
//            //显示
//            mTransaction = getChildFragmentManager().beginTransaction();
//            mTransaction.replace(R.id.id_Order,un_sent);
//            mTransaction.commit();
//        }
//        temp_position_index = IN;
//        break;
//        case R.id.id_sent_in_BUTTON:
//        if (temp_position_index != IN) {
//            //显示
//            mTransaction = getChildFragmentManager().beginTransaction();
//            mTransaction.replace(R.id.id_Order, sent_in);
//            mTransaction.commit();
//        }
//        temp_position_index = IN;
//        break;
//        case R.id.id_end_sent_BUTTON:
//        if (temp_position_index != END) {
//            //显示
//            mTransaction = getChildFragmentManager().beginTransaction();
//            mTransaction.replace(R.id.id_Order, end_sent);
//            mTransaction.commit();
//        }
//        temp_position_index = END;
//        break;
//    }
//}
}
