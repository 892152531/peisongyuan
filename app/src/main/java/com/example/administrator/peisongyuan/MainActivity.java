package com.example.administrator.peisongyuan;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    /**
     * 底部导航栏的widdget
     */
    private RadioGroup mNavGroup;
    private FragmentTransaction mTransaction;
    /**
     * 五个Fragments
     */
    Fragment MyFragemnt, OrderFragment;
    public static final int VIEW_SHOUYE_INDEX = 0;
    public static final int VIEW_GOUWU_INDEX = 1;
    private int temp_position_index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mNavGroup = (RadioGroup) findViewById(R.id.id_navcontent);
        MyFragemnt=My.getNewInstance();
        OrderFragment = Order.getNewInstance();
        //显示
        mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.replace(R.id.id_fragment_content, OrderFragment);
        mTransaction.commit();
    }
    public void switchView(View view) {
        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        android.app.FragmentTransaction transaction = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.id_nav_btshouye:
                if (temp_position_index != VIEW_SHOUYE_INDEX) {
                    //显示
                    mTransaction = getSupportFragmentManager().beginTransaction();
                    mTransaction.replace(R.id.id_fragment_content, OrderFragment);
                    mTransaction.commit();
                }
                temp_position_index = VIEW_SHOUYE_INDEX;
                break;
            case R.id.id_nav_btgouwu:
                if (temp_position_index != VIEW_GOUWU_INDEX) {
                    //显示
                    mTransaction = getSupportFragmentManager().beginTransaction();
                    mTransaction.replace(R.id.id_fragment_content,MyFragemnt);
                    mTransaction.commit();
                }
                temp_position_index = VIEW_GOUWU_INDEX;
                break;
        }
    }
}

