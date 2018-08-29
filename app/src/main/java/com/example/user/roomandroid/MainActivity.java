package com.example.user.roomandroid;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.user.roomandroid.model.Person;
import com.example.user.roomandroid.model.WallItem;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.methods.VKApiFriends;
import com.vk.sdk.api.methods.VKApiMessages;
import com.vk.sdk.api.methods.VKApiWall;
import com.vk.sdk.api.model.VKApiGetMessagesResponse;
import com.vk.sdk.api.model.VKApiMessage;
import com.vk.sdk.api.model.VKApiPost;
import com.vk.sdk.api.model.VKApiUser;
import com.vk.sdk.api.model.VKApiUserFull;
import com.vk.sdk.api.model.VKList;
import com.vk.sdk.util.VKUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements ImageLoadingListener {

    public static ImageLoader imageLoader = ImageLoader.getInstance();
    public static android.app.FragmentTransaction fragmentTransaction;
    Map<String,View> viewImages;
    private String URL = "https://pp.userapi.com/c834203/v834203553/13c2a5/l6-ukZ4HJd0.jpg";
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private List<Person> persons;
    private List<String> dataVK;
    private String[] scope = new String[]{VKScope.MESSAGES,VKScope.WALL};

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing_imaging);
        ButterKnife.bind(this);
        imageLoader.init(ImageLoaderConfiguration.createDefault(MainActivity.this));
        VKSdk.login(this,scope);
        dataVK = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleView);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        //RVAdapter adapter = new RVAdapter(persons);
        //recyclerView.setAdapter(adapter);
        /*
        persons = new ArrayList<>();
        fragmentTransaction = getFragmentManager().beginTransaction();
        initData();
        RVAdapter adapter = new RVAdapter(persons);
        recyclerView.setAdapter(adapter);
        viewImages = new HashMap<>();

        String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        Log.i("dadadada", String.valueOf(Arrays.asList(fingerprints)));*/

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

    @Override
    public void onLoadingStarted(String s, View view) {

    }

    @Override
    public void onLoadingFailed(String s, View view, FailReason failReason) {
        Log.e("dadadada", "fail" + s);
    }

    @Override
    public void onLoadingComplete(String s, View view, Bitmap bitmap) {

    }

    @Override
    public void onLoadingCancelled(String s, View view) {
    }

    private void initData(){
        persons.add(new Person("Nikolai Prokunin","22 year","https://sun9-6.userapi.com/c830308/v830308350/245b2/uX2eXMMUEzc.jpg"));
        persons.add(new Person("Mari Apanovich","19 year","https://sun9-6.userapi.com/c830109/v830109949/1720a1/ioni-EEkMxY.jpg"));
        persons.add(new Person("Evgenii Porochon'ko","24 year","https://pp.userapi.com/c628821/v628821770/15e36/2qinYcMNS78.jpg"));
        persons.add(new Person("Andrey Molochko","19 year","https://pp.userapi.com/c840333/v840333619/6e168/ul2LV7YWrpA.jpg"));
    }

    private void initTestData(){
        dataVK.add("private");
        dataVK.add("fsafsafsa");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
            Log.i("dadada","succesful");
                //VKRequest request = VKApi.friends().get(VKParameters.from(VKApiConst.FIELDS,"first_name"));
                final VKRequest request = VKApi.wall().get(VKParameters.from(
                        VKApiConst.EXTENDED,1,VKApiConst.COUNT,10,VKApiConst.FIELDS,"text"));
                final VKRequest requestUser = VKApi.users().get(VKParameters.from(VKApiConst.OWNER_ID,161243682));
                requestUser.executeWithListener(new VKRequest.VKRequestListener() {
                    @Override
                    public void onComplete(VKResponse response) {
                        super.onComplete(response);
                        Log.i("dadada","ocCompleUser");
                        VKApiUser user = (VKApiUser) response.parsedModel;
                        Log.i("dadadada","user_name = "+user.first_name);
                    }
                });
                request.executeWithListener(new VKRequest.VKRequestListener() {
                    @Override
                    public void onComplete(VKResponse response) {
                        Log.i("dadada","complete");
                        super.onComplete(response);
                        //List<VKApiUser> list = (List<VKApiUser>) response.parsedModel;
                        List<VKApiPost>list = (List<VKApiPost>) response.parsedModel;
                        List<WallItem>items = new ArrayList<>();
                        Log.i("dadada", "norm list"+list.size());
                        for(int i=0;i<list.size();i++){
                            WallItem wallItem = new WallItem();
                            wallItem.setName("Andrey");
                            wallItem.setSurname("Molochko");
                            wallItem.setURLPhoto("https://pp.userapi.com/c840333/v840333619/6e168/ul2LV7YWrpA.jpg");
                            wallItem.setCountComments(list.get(i).comments_count);
                            wallItem.setCountLikes(list.get(i).likes_count);
                            wallItem.setCountReposts(list.get(i).reposts_count);
                            wallItem.setText(list.get(i).text);
                            wallItem.setName(String.valueOf(list.get(i).from_id));

                            Log.i("dadadaItems", "comments = "+String.valueOf(wallItem.getCountComments()));
                            Log.i("dadadaItems", "likes = "+String.valueOf(wallItem.getCountLikes()));
                            Log.i("dadadaItems","reposts = " +String.valueOf(wallItem.getCountReposts()));
                            Log.i("dadadaItems","text = " +String.valueOf(wallItem.getText()));
                            Log.i("dadadaItems","owner_id = " +String.valueOf(wallItem.getName()));


                        }
                        RVAdapter rvAdapter = new RVAdapter(persons);
                        recyclerView.setAdapter(rvAdapter);
                    }

                    @Override
                    public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
                        Log.i("dadada","attempt");
                        super.attemptFailed(request, attemptNumber, totalAttempts);
                    }

                    @Override
                    public void onError(VKError error) {
                        Log.i("dadada","error"+error.errorReason);
                        super.onError(error);
                    }

                    @Override
                    public void onProgress(VKRequest.VKProgressType progressType, long bytesLoaded, long bytesTotal) {
                        Log.i("dadada","onProgress");
                        super.onProgress(progressType, bytesLoaded, bytesTotal);
                    }
                });

            }
            @Override
            public void onError(VKError error) {
            Log.i("dadadada","error");
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
