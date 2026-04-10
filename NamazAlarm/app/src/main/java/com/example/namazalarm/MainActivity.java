package com.example.namazalarm;

import android.app.Activity;
import android.os.Bundle;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.os.Build;

public class MainActivity extends Activity {

    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // code here
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        String nextMinuteTime = getNextMinuteTime();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 1);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, VibrationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        } else {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        }
        // ...

    }

    @Override
    protected void onStop() {
        super.onStop();
        String nextMinuteTime = getNextMinuteTime();
        // You can use nextMinuteTime as needed (e.g., save it, display it, etc.)
    }

    private String getNextMinuteTime() {
        // Get current time
        Calendar calendar = Calendar.getInstance();

        // Add one minute
        calendar.add(Calendar.MINUTE, 1);

        // Set seconds and milliseconds to zero
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // Format the time
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a", Locale.getDefault());
        return sdf.format(calendar.getTime());
    }
}