package com.example.retrofit_recyclerview.Screens.MainScreen;

import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;



import com.example.retrofit_recyclerview.JsonResponse;
import com.example.retrofit_recyclerview.Model.WorldPopulation;
import com.example.retrofit_recyclerview.MyAdapter;
import com.example.retrofit_recyclerview.R;
import com.example.retrofit_recyclerview.RetrofitInterface;

import java.io.File;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<WorldPopulation> myList;
    RecyclerView recyclerView;
    MyAdapter adapter;
    int cacheSize;
    DrawerLayout drawer;

    Animation fabAnimation;
    ObjectAnimator fabBtnAnimation;
    Bundle bundle;
    FloatingActionButton fab;

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbarID);
        setSupportActionBar(toolbar);

        drawer=findViewById(R.id.drawer_layoutID);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        recyclerView = findViewById(R.id.listID);

        fabAnimation= AnimationUtils.loadAnimation(this,R.anim.button_raised);
        bundle= ActivityOptions.makeSceneTransitionAnimation(this).toBundle();

        fab=findViewById(R.id.fab);

        fabBtnAnimation = ObjectAnimator.ofFloat(fab,"x",800);
        fabBtnAnimation.setRepeatCount(1);
        fabBtnAnimation.setRepeatMode(ObjectAnimator.REVERSE);
        fabBtnAnimation.setDuration(2000);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabBtnAnimation.start();
                fab.startAnimation(fabAnimation);
            }
        });


        File httpCacheDirectory = new File(getCacheDir(), "offlineCache");
        cacheSize=10*1024*1024;
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .cache(new okhttp3.Cache(httpCacheDirectory,cacheSize))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.androidbegin.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
        Call<JsonResponse> getCountries = retrofitInterface.getCountries();

        getCountries.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                myList = response.body().getWorldPopulations();

                Log.i("list",myList.get(0).getCountry());

                adapter = new MyAdapter(MainActivity.this, R.id.listID, myList);
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
