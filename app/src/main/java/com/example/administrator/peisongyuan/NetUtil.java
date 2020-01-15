package com.example.administrator.peisongyuan;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Administrator on 2020/1/15 0015.
 */

public class NetUtil {
    private static final int NETWORK_NONE = 1;

    private static final int NETWORK_MOBILE = 0;

    private static final int NETWORW_WIFI = 2;

    public static int getNetWorkStart(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_WIFI)) {
                Toast.makeText(context, "当前处于无线网络", Toast.LENGTH_SHORT).show();
                return NETWORW_WIFI;
            } else if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_MOBILE)) {
                Toast.makeText(context, "当前处于移动网络", Toast.LENGTH_SHORT).show();
                return NETWORK_MOBILE;
            } else {
                Toast.makeText(context, "当前没有网络", Toast.LENGTH_SHORT).show();
                return NETWORK_NONE;
            }
        }
        return NETWORK_NONE;
    }
}
