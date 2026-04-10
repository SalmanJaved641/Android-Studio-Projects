package com.example.salmanfirebase;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMsgService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);

        if (message.getNotification() != null) {
            pushNotification(
                    message.getNotification().getTitle(),
                    message.getNotification().getBody());
        }
    }

    private void pushNotification(String title,  String body) {

        final String CHANNEL_ID = "Massage";
        final int NOTIFICTION_ID = 100;
        final int REQ_CODE = 100;

        Notification notification;
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.large_icon, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap large_icon = bitmapDrawable.getBitmap();

        Intent iNotify = new Intent(this, MainActivity.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);/*to clear stack*/
        PendingIntent pendingIntent = PendingIntent.getActivity(this, REQ_CODE, iNotify, PendingIntent.FLAG_UPDATE_CURRENT/*TO UPDATE STACK*/);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {


            if (nm != null) {
                nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"Massages",NotificationManager.IMPORTANCE_HIGH));
            }

            notification= new Notification.Builder(this)
                    .setLargeIcon(large_icon)
                    .setSmallIcon(R.drawable.small_icon)
                    .setContentIntent(pendingIntent)
                    .setContentTitle(title)
                    .setSubText(body)
                    .setChannelId(CHANNEL_ID)
                    .setAutoCancel(true)
                    .build();

        }else {
            notification= new Notification.Builder(this)
                    .setLargeIcon(large_icon)
                    .setSmallIcon(R.drawable.small_icon)
                    .setContentIntent(pendingIntent)
                    .setContentTitle(title)
                    .setSubText(body)
                    .setAutoCancel(true)
                    .build();
        }

        if (nm != null)
            nm.notify(NOTIFICTION_ID, notification);
    }

    @Override
    public void onNewToken(@NonNull String token) { /*only used if we manage both firebase and server samultaniusly*/
        super.onNewToken(token);
        Log.d("onTokenRefresh", token);
    }
}
