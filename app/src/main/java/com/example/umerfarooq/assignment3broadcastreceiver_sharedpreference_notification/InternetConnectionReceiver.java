package com.example.umerfarooq.assignment3broadcastreceiver_sharedpreference_notification;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;


public class InternetConnectionReceiver extends BroadcastReceiver {

    SharedPreferences preferences;

    public InternetConnectionReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
//        int state= intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN);
//
        preferences = context.getSharedPreferences("MYPREF",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
//
//
//        if(WifiManager.WIFI_STATE_ENABLED == state){
//            Log.i("TTTTTTTT", "onReceive: "+1122);
//            editor.putInt("STATE",1);
//            editor.commit();
//        }
//        if(WifiManager.WIFI_STATE_DISABLED == state){
//            Log.i("TTTTTTTT", "onReceive: "+1122);
//            editor.putInt("STATE",2);
//            editor.commit();
//        }

        ConnectivityManager cmanager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cmanager.getActiveNetworkInfo();

        if(nInfo!= null && nInfo.isConnected()){
            Log.i("AAAAAA", "onReceive: TEST");
            new MainActivity().tv.setText("Check");
//            editor.putInt("STATE",2);
        }else{
            Log.i("AAAAAAAAA", "onReceive: ABC");
            new MainActivity().tv.setText("Not");
//            editor.putInt("STATE",1);
//            new MainActivity().switchWifi.setChecked(false);
        }
//        editor.commit();
    }
}
