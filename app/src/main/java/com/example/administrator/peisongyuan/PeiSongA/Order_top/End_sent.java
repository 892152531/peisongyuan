package com.example.administrator.peisongyuan.PeiSongA.Order_top;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.peisongyuan.R;



public class End_sent extends Fragment {
    // 缓存Fragment view
    private RadioGroup fragement_end_relativelayout;
    private FragmentTransaction mTransaction;
    RadioButton Deliver_button;
    RadioButton Finish_button;
    RadioButton END;
    Fragment deliver, finish;
    private RadioGroup fragement_end;



    private View rootView;
    private static End_sent end_sent;

    public End_sent() {
    }

    public static End_sent getNewInstance() {
        if (end_sent == null) {
            end_sent = new End_sent();
        }
        return end_sent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_end_sent, container, false);
        }
        // 缓存的rootView需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }
}