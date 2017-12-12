package com.example.umerfarooq.assignment3broadcastreceiver_sharedpreference_notification;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {
    WifiManager wifiManager;
    public Switch sWifi;

    TextView tv;

    Context context = this;
    //TextView result;
    //Button launchbtn;

    SharedPreferences preferences;
    InternetConnectionReceiver in = new InternetConnectionReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        EventBus.getDefault().register(this);
        /*result = (TextView) findViewById(R.id.result);
        launchbtn = (Button) findViewById(R.id.launchbtn);
        launchbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChildActivity.class);
                startActivity(intent);

            }
        });*/

        tv = (TextView) findViewById(R.id.myText);
        preferences = getSharedPreferences("MYPREF",MODE_PRIVATE);
        int value = preferences.getInt("STATE",0);

        changeSwtich(value);
        wifiManager = (WifiManager) this.getApplicationContext().getSystemService(WIFI_SERVICE);
        sWifi = (Switch) findViewById(R.id.switchWifi);
        sWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    wifiManager.setWifiEnabled(true);
                    Toast.makeText(MainActivity.this, "Wifi On", Toast.LENGTH_SHORT).show();
                } else {
                    wifiManager.setWifiEnabled(false);
                    Toast.makeText(MainActivity.this, "Wifi Off", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(new InternetConnectionReceiver(),new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION));
    }


    public void changeSwtich(int v){

        if(v == 2){
            tv.setText("Checked");
//            sWifi.setChecked(true);
        }else{
            tv.setText("Not Checked");
//            sWifi.setChecked(false);
        }
    }
}
