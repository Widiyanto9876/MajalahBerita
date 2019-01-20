package com.widiyanto.user.majalahberita;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.widiyanto.user.majalahberita.Adapter.CardViewBerita;
import com.widiyanto.user.majalahberita.Entity.BeritaArtikelData;
import com.widiyanto.user.majalahberita.Entity.BeritaEntity;
import com.widiyanto.user.majalahberita.api.API;
import com.widiyanto.user.majalahberita.api.Koneksi;

import java.util.ArrayList;
import java.util.List;

import io.supercharge.shimmerlayout.ShimmerLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;

    private CardViewBerita cardViewBerita;
    private List<BeritaArtikelData> beritaArtikelData;
    private API apiservise;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.beranda:

                    finish();
                    overridePendingTransition(0,0);
                    startActivity(getIntent());
                    return true;
                case R.id.search:
                    Intent intent  = new Intent(MainActivity.this, Search.class);
                    startActivity(intent);
                    return true;
                case R.id.user:
                    Intent intent2  = new Intent(MainActivity.this, user.class);
                    startActivity(intent2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiservise = Koneksi.createService(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        navigation.setSelectedItemId(R.id.search);
        //ah botom navigation
        ShimmerLayout shimmerText = (ShimmerLayout) findViewById(R.id.container);
        shimmerText.startShimmerAnimation();


        recyclerView = (RecyclerView) findViewById(R.id.rv_data);
        layoutManager = new LinearLayoutManager(this);

        Data();

    }

    private void Data() {
        beritaArtikelData = new ArrayList<>();
        cardViewBerita = new CardViewBerita(beritaArtikelData, MainActivity.this);
        cardViewBerita.setHasStableIds(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cardViewBerita);
        apiservise.beritaEntity("bitcoin", "2018-12-25", "publishedAt", Koneksi.API_KEY).enqueue(new Callback<BeritaEntity>() {
            @Override
            public void onResponse(Call<BeritaEntity> call, Response<BeritaEntity> response) {
                if (response.isSuccessful()) {
                    for (BeritaArtikelData data : response.body().getArtikelData()) {
                        beritaArtikelData.add(data);
                        cardViewBerita.addItem(0);
                    }
                    Log.i("xxxx", "data " + beritaArtikelData.size());
                }
            }

            @Override
            public void onFailure(Call<BeritaEntity> call, Throwable t) {

            }
        });

        apiservise.beritaEntity3("Apple ","2018-12-20","popularity", Koneksi.API_KEY).enqueue(new Callback<BeritaEntity>() {
            @Override
            public void onResponse(Call<BeritaEntity> call, Response<BeritaEntity> response) {
                if (response.isSuccessful()){
                    for (BeritaArtikelData data : response.body().getArtikelData()){
                        beritaArtikelData.add(data);
                        cardViewBerita.addItem(0);
                    }
                }
            }

            @Override
            public void onFailure(Call<BeritaEntity> call, Throwable t) {

            }
        });


    }

//
//    String result = new String(responseBody);
//    Log.d(TAG, result);
//    try {
//        JSONObject responseObject = new JSONObject(result);
//        String currentWeather = responseObject.getJSONArray("weather").getJSONObject(0).getString("main");
//        String description = responseObject.getJSONArray("weather").getJSONObject(0).getString("description");
//        double tempInKelvin = responseObject.getJSONObject("main").getDouble("temp");
//        double tempInCelcius = tempInKelvin - 273;
//        String temprature = new DecimalFormat("##.##").format(tempInCelcius);
//        String title = "Current Weather";
//        String message = currentWeather +", "+description+" with "+temprature+" celcius";
//        int notifId = 100;
//        showNotification(getApplicationContext(), title, message, notifId);
//        ...
//    }catch (Exception e){
//        ...
//        e.printStackTrace();
//    }
//


}
