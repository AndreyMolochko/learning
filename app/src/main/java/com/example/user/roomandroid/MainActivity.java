package com.example.user.roomandroid;

import android.app.Activity;
import android.app.PendingIntent;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.roomandroid.room.AppDatabase;
import com.example.user.roomandroid.room.Person;
import com.example.user.roomandroid.workWithServices.MyService;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    public final static String PARAM_TIME = "time";
    public final static String PARAM_PINTENT = "pendingIntent";
    public final static String PARAM_RESULT = "result";
    final String LOG_TAG = "myLogs";
    private FloatingActionButton fab;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init(){
        initView();
        initOnClickFloatingButton();
    }

    private void initView(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    private void initOnClickFloatingButton(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @OnClick(R.id.buttonStart)
    public void onClickButtonStart(){
        PendingIntent pendingIntent;
        Intent intent;
        pendingIntent=createPendingResult(1,null,0);
        intent = new Intent(this,MyService.class).putExtra(PARAM_TIME,7).putExtra(PARAM_PINTENT,pendingIntent);
        startService(intent);
        pendingIntent=createPendingResult(2,null,0);
        intent = new Intent(this,MyService.class).putExtra(PARAM_TIME,4).putExtra(PARAM_PINTENT,pendingIntent);
        startService(intent);
        pendingIntent=createPendingResult(3,null,0);
        intent = new Intent(this,MyService.class).putExtra(PARAM_TIME,6).putExtra(PARAM_PINTENT,pendingIntent);
        startService(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(LOG_TAG, "requestCode = " + requestCode + ", resultCode = "
                + resultCode);
    }

    @OnClick(R.id.buttonStop)
    public void onClickButtonStop(){
        stopService(new Intent(this, MyService.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
