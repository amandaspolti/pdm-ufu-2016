package com.example.vinciusresende.testenotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Vinícius Resende on 06/12/2016.
 */

public class NotificationService extends Service {
    private Timer mTimer;
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            Log.e("Log", "Running");
            notifiy();
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mTimer.cancel();
        timerTask.cancel();

        Intent intent = new Intent("com.example.sample");
        intent.putExtra("yourvalue", "torestore");
        sendBroadcast(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mTimer = new Timer();
        System.out.println("vai dar pau");
        mTimer.schedule(timerTask, 2000, 5 * 1000);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public void notifiy(){

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("RSSPullService");
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
        PendingIntent pendingIntent = PendingIntent.getActivity(getBaseContext(), 0, myIntent, Intent.FLAG_ACTIVITY_NEW_TASK);

        Context context = getApplicationContext();
        Notification.Builder builder;
        builder = new Notification.Builder(context)
                .setContentTitle("Titulo")
                .setContentText("Notificacao")
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.images); // TODO colocar imagem

        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);
    }

}
