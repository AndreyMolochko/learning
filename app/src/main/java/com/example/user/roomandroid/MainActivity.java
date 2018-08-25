package com.example.user.roomandroid;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.arch.persistence.room.Room;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;



import com.example.user.roomandroid.service.foreground.MyService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    public final static String FILE_NAME = "filename";
    private static LocationManager locationManager;

    public static boolean checkGPS(){
        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))return true;
        else return false;
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_foreground_service);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        TextView tv = (TextView) findViewById(R.id.tv);

        Intent intent = getIntent();

        String fileName = intent.getStringExtra(FILE_NAME);
        if (!TextUtils.isEmpty(fileName))
            tv.setText(fileName);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

    }

    public void onClickStart(View v) {
        Log.i("dadadadada","onClickStart");
        startService(new Intent(this, MyService.class));
    }

    public void onClickStop(View v) {
        Log.i("dadadadada","onStop");
        stopService(new Intent(this, MyService.class));
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}
