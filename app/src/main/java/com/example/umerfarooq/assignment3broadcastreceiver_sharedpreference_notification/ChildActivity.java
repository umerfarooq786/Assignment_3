package com.example.umerfarooq.assignment3broadcastreceiver_sharedpreference_notification;

import android.app.usage.UsageEvents;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

public class ChildActivity extends AppCompatActivity {
    //EditText messageText;
    //Button triggerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        /*messageText= (EditText) findViewById(R.id.MessageText);
        triggerBtn= (Button) findViewById(R.id.triggerBtn);
        triggerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userText=messageText.getText().toString();
                CustomMessageEvent event=new CustomMessageEvent();
                event.setCustomMessage(userText);
                EventBus.getDefault().post(event);
                finish();
            }
        });*/
    }
}
