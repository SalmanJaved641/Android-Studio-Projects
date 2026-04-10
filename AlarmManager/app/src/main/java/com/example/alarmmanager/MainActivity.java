package com.example.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    static final int ALARM_REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtsec = findViewById(R.id.edtsec);
        AlarmManager alarmManager =(AlarmManager) getSystemService(ALARM_SERVICE);


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int time = Integer.parseInt(((EditText)(findViewById(R.id.edtsec))).getText().toString());
                long trigger = System.currentTimeMillis()+(time*1000);
                Intent ibroadcast = new Intent(MainActivity.this, MyReciver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,ALARM_REQ_CODE,ibroadcast,PendingIntent.FLAG_UPDATE_CURRENT);


                alarmManager.set(AlarmManager.RTC_WAKEUP,trigger,pendingIntent);

            }
        });

    }
}