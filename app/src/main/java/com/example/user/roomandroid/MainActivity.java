package com.example.user.roomandroid;

import android.app.Activity;
import android.app.PendingIntent;
import android.arch.persistence.room.Room;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


import com.example.user.roomandroid.room.AppDatabase;
import com.example.user.roomandroid.room.bd.Bio;
import com.example.user.roomandroid.room.bd.Company;
import com.example.user.roomandroid.room.bd.Location;
import com.example.user.roomandroid.room.bd.Person;
import com.example.user.roomandroid.room.bd.Work;
import com.example.user.roomandroid.service.foreground.MyForegroundService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    /*@BindView(R.id.editTextFirstSkill)
    EditText editTextFirstSkill;
    @BindView(R.id.editTextSecondSkill)
    EditText editTextSecondSkill;
    @BindView(R.id.editTextPosition)
    EditText editTextPosition;
    @BindView(R.id.editTextExperience)
    EditText editTextExperience;
    @BindView(R.id.editTextTechno)
    EditText editTextTechno;
    @BindView(R.id.editTextAge)
    EditText editTextAge;
    @BindView(R.id.editTextSex)
    EditText editTextSex;
    @BindView(R.id.editTextName)
    EditText editTextName;
    @BindView(R.id.editTextSurname)
    EditText editTextSurname;
    @BindView(R.id.editTextCity)
    EditText editTextCity;
    @BindView(R.id.editTextCountry)
    EditText editTextCountry;
    @BindView(R.id.editTextStreet)
    EditText editTextStreet;*/
    //AppDatabase db;
    private FloatingActionButton fab;
    /*private String firstSkill;
    private String secondSkill;
    private String position;
    private String experience;
    private String technology;
    private String age;
    private String sex;
    private String name;
    private String surname;
    private String city;
    private String street;
    private String country;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_foreground_service);
        ButterKnife.bind(this);
        setTitle("dev2qa.com - Android Foreground Service Example.");
        Log.i(LOG_TAG,"after init");
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
                /*Person person = new Person();
                Work work = new Work();
                Company company = new Company();
                Bio bio = new Bio();
                Location location = new Location();
                List<String> skills = new ArrayList<>();
                firstSkill = editTextFirstSkill.getText().toString();
                secondSkill = editTextSecondSkill.getText().toString();
                position = editTextPosition.getText().toString();
                experience = editTextExperience.getText().toString();
                technology = editTextTechno.getText().toString();
                age = editTextAge.getText().toString();
                sex = editTextSex.getText().toString();
                name = editTextName.getText().toString();
                surname = editTextSurname.getText().toString();
                city = editTextCity.getText().toString();
                street = editTextStreet.getText().toString();
                country = editTextCountry.getText().toString();
                skills.add(firstSkill);
                skills.add(secondSkill);
                company.setPosition(position);
                company.setPosition(experience);
                company.setPosition(technology);
                work.setCompany(company);
                work.setSkills(skills);
                location.setCity(city);
                location.setStreet(street);
                location.setCountry(country);
                bio.setDateOfBirthday(Integer.parseInt(age));
                bio.setName(name);
                bio.setSex(sex);
                bio.setSurname(surname);
                person.setWork(work);
                person.setBio(bio);
                person.setLocation(location);
                Log.i(LOG_TAG,"before insert, size = "+db.getPersonDao().getAllPerson().size());
                db.getPersonDao().insertPersons(person);
                Log.i(LOG_TAG,"after insert, size = "+db.getPersonDao().getAllPerson().size());
                List<Person>men = db.getPersonDao().getAllPerson();
                for(int i=0;i<men.size();i++){
                    Log.i(LOG_TAG,men.get(i).getWork().getSkills().get(0));
                }*/
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

    @OnClick(R.id.start_foreground_service_button)
    public void clickOnStart(){
        Log.i(LOG_TAG,"clickonStart");
        Intent intent = new Intent(MainActivity.this, MyForegroundService.class);
        intent.setAction(MyForegroundService.ACTION_START_FOREGROUND_SERVICE);
        startService(intent);
    }

    @OnClick(R.id.stop_foreground_service_button)
    public void clickOnStop(){
        Intent intent = new Intent(MainActivity.this,MyForegroundService.class);
        intent.setAction(MyForegroundService.ACTION_STOP_FOREGROUND_SERVICE);
        startService(intent);
    }
}
