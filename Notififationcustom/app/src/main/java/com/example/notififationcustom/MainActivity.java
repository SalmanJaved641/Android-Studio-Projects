package com.example.notififationcustom;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "Massage";
    private static final int NOTIFICTION_ID = 100;
    private static final int REQ_CODE = 100;
    Button btnNotification;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Notification notification;
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.large_icon,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap large_icon = bitmapDrawable.getBitmap();

        Intent iNotify = new Intent(MainActivity.this, MainActivity.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);/*to clear stack*/
        PendingIntent pendingIntent = PendingIntent.getActivity(this,REQ_CODE,iNotify,PendingIntent.FLAG_UPDATE_CURRENT/*TO UPDATE STACK*/);


//        Big Picture Style
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable) (ResourcesCompat.getDrawable(getResources(),R.drawable.large_icon,null))).getBitmap())/*jo kaam uper 3 lines ma kia ha wo yaha 1 line ma kar dia ha */
                .bigLargeIcon(large_icon)
                .setBigContentTitle("big large picture title")
                .setSummaryText("Picture Summery");


//       Inbox Massage Style

        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("Massage line 1")
                .addLine("Massage line 2")
                .addLine("Massage line 3")
                .addLine("Massage line 4")
                .addLine("Massage line 5")
                .addLine("Massage line 6")
                .addLine("Last Massage line 7")
                .addLine("Last Massage line 8")
                .setBigContentTitle("Inbox Style title")
                .setSummaryText("Inbox Style summary");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification= new Notification.Builder(this)
                    .setLargeIcon(large_icon)
                    .setSmallIcon(R.drawable.small_icon)
                    .setSubText("MY APP")
                    .setContentTitle("New massage")
                    .setContentText("APPS: Hello")
                    .setChannelId(CHANNEL_ID)
                    .setContentIntent(pendingIntent)
                    .setStyle(inboxStyle)
                    .setOngoing(true)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"Massages",NotificationManager.IMPORTANCE_HIGH));

        }else {
            notification= new Notification.Builder(this)
                    .setLargeIcon(large_icon)
                    .setSmallIcon(R.drawable.small_icon)
                    .setContentText("new massage")
                    .setSubText("APPS: Hello")
                    .build();
        }

        btnNotification = findViewById(R.id.btnNotification);

        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nm.notify(NOTIFICTION_ID,notification);

            }
        });

    }
}