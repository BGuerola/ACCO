package com.example.acco;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.collection.ArrayMap;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
        ArrayMap<String, String> campsMissatge;  // To get the fields of the sent message
        @Override
        public void onMessageReceived(RemoteMessage remoteMessage) {
            // Check if message contains a notification payload.
            if (remoteMessage.getNotification() != null) {
                Log.d("msg", "Notification Body: "+ remoteMessage.getNotification().getBody());
                campsMissatge = new ArrayMap<>();
                campsMissatge = (ArrayMap<String, String>) remoteMessage.getData();
                createNotification(remoteMessage.getNotification().getBody());
            }
        }
        private void createNotification(String message) {
            Intent intent = new Intent(this, MyNotificationsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // The content of the message (payload)
            for (String key : campsMissatge.keySet()) {  // Adding the information to the intent
                intent.putExtra(key, campsMissatge.get(key));
            }
            // The title of the message
            intent.putExtra("msg", message);
            // The pending intent to be runned after receiving the message
            PendingIntent resultIntent =
                    PendingIntent.getActivity(this,0, intent, PendingIntent.FLAG_ONE_SHOT);
            Uri notificationSoundURI = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            // Only show notificactions from the News channel?
            NotificationCompat.Builder mNotificationBuilder =
                    new NotificationCompat.Builder(this, MyNotificationsActivity.CHANNEL_NEWS)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("Notifications from 2nDAM IES Jaume II el Just")
                            .setContentText(message)
                            .setAutoCancel(true)
                            .setSound(notificationSoundURI)
                            .setContentIntent(resultIntent)
                    ;
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, mNotificationBuilder.build());
        }
    }

