package com.example.user.roomandroid.workWithServices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyService extends Service {
    private final String log = "MyServiceLog";
    ExecutorService es;
    public MyService() {
        Log.i(log,"constructor my service");
        super.onCreate();
        es = Executors.newFixedThreadPool(1);
    }

    @Override
    public void onDestroy() {
        Log.i(log,"on Destroy my service");
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        Log.i(log,"on Create my service");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(log,"on start command my service");
        int time = intent.getIntExtra("time",1);
        MyRun myRun = new MyRun(time,startId);
        es.execute(myRun);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(log,"on rebind my service");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(log,"on unbind my service");
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.i(log,"on Bind my service");
        return new Binder();
    }

    private void executeTask(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    Log.i(log,"i = "+i);
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf();
            }
        }).start();
    }
}
