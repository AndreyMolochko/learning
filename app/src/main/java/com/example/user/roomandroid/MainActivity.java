package com.example.user.roomandroid;

import android.app.Activity;
import android.arch.persistence.room.Room;
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

import com.example.user.roomandroid.room.AppDatabase;
import com.example.user.roomandroid.room.Person;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private FloatingActionButton fab;
    private EditText editTextName;
    private EditText editTextSalary;
    private EditText editTextColor;
    private ListView listView;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"populus-databaсe").
                allowMainThreadQueries().
                build();
        init();
        updateAdapter(this);
    }

    private void init(){
        initView();
        initOnClickFloatingButton();
    }

    private void initView(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editTextColor = findViewById(R.id.editTextColor);
        editTextSalary = findViewById(R.id.editTextSalary);
        editTextName = findViewById(R.id.editTextName);
        listView = (ListView) findViewById(R.id.listView);
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    private void updateAdapter(View view){
        adapter = new ArrayAdapter<String>(
                view.getContext(),
                android.R.layout.simple_list_item_1,
                db.getPersonDao().getAllNames());
        listView.setAdapter(adapter);
    }

    private void updateAdapter(Activity activity){
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                db.getPersonDao().getAllNames());
        listView.setAdapter(adapter);
    }

    private void initOnClickFloatingButton(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ROOM_LEARN3", String.valueOf(db.getPersonDao().getAllPeople().size()));
                int salary = Integer.parseInt(editTextSalary.getText().toString());
                String name = editTextName.getText().toString();
                String color = editTextColor.getText().toString();
                db.getPersonDao().insertAll(new Person(name,salary,color));
                Log.i("ROOM_LEARN4", String.valueOf(db.getPersonDao().getAllPeople().size()));
                updateAdapter(view);
            }
        });
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
