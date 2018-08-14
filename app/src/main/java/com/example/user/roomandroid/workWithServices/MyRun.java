package com.example.user.roomandroid.workWithServices;

import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by User on 14.08.2018.
 */

public class MyRun implements Runnable {
    String log = "MyRun";
    int time;
    int startId;

    public MyRun(int time,int startId){
        this.time=time;
        this.startId=startId;
        Log.i(log,"time = "+ time + " ; startid = "+startId);
    }
    @Override
    public void run() {
        Log.i(log,"begin method run with start id = "+startId);
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
