package com.example.user.roomandroid.service.foreground;

import java.util.concurrent.TimeUnit;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.example.user.roomandroid.MainActivity;
import com.example.user.roomandroid.R;

/**
 * Created by User on 24.08.2018.
 */

public class MyService extends Service {
    NotificationManager nm;
    LocationManager locationManager;
    //LocationListener locationListener;
    Boolean flag = true;
    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {
            Log.i("dadadada", "on statuschanged");
        }

        @Override
        public void onProviderEnabled(String s) {
            flag=true;
           sendNotif();
        }

        @Override
        public void onProviderDisabled(String s) {
            flag=false;
            sendNotif();
        }
    };

    @Override
    public void onCreate() {
        Log.i("dadadadada", "onCreate");
        super.onCreate();
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    @SuppressLint("MissingPermission")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("dadadadada", "onStartCommand");
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                1000 * 10, 10, locationListener);
        sendNotif();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    void sendNotif() {
        Log.i("dadadadada","sendNotif");
        // 1-я часть
        Notification notif;
        if(flag) {
            notif = new Notification(R.drawable.ic_gps_fix, "Text in status bar",
                    System.currentTimeMillis());
        }
        else {
            notif = new Notification(R.drawable.ic_gps_unfix, "Text in status bar",
                    System.currentTimeMillis());
        }

        // 3-я часть
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra(MainActivity.FILE_NAME, "somefile");
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // 2-я часть
       //notif.setLatestEventInfo(this, "Notification's title", "Notification's text", pIntent)

        // ставим флаг, чтобы уведомление пропало после нажатия
        notif.flags |= Notification.FLAG_AUTO_CANCEL;

        // отправляем
        nm.notify(1, notif);
    }

    private void checkEnabled(){
        //if(locationManager.isProviderEnabled())
    }

}
