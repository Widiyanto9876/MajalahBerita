package com.widiyanto.user.majalahberita;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.widiyanto.user.majalahberita.Adapter.CardViewBerita;
import com.widiyanto.user.majalahberita.Entity.BeritaArtikelData;
import com.widiyanto.user.majalahberita.Entity.BeritaEntity;
import com.widiyanto.user.majalahberita.api.API;
import com.widiyanto.user.majalahberita.api.Koneksi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Search extends AppCompatActivity {
    private RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;

    private CardViewBerita cardViewBerita;
    private List<BeritaArtikelData> beritaArtikelData;
    private API apiservise;

    private SearchView sv_pencarian;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.beranda:
                    Intent intent = new Intent(Search.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.search:
                    finish();
                    overridePendingTransition(2,1);
                    startActivity(getIntent());
                    return true;
                case R.id.user:
                    Intent intent1 = new Intent(Search.this,user.class);
                    startActivity(intent1);

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation1);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
//        View view = navigation.findViewById(R.id.search);
//        view.performClick();
//        navigation.setSelectedItemId(R.id.search);


        apiservise = Koneksi.createService(this);

        recyclerView = (RecyclerView) findViewById(R.id.rv_data);
        layoutManager = new LinearLayoutManager(this);

        sv_pencarian = (SearchView) findViewById(R.id.sv1);

        sv_pencarian.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Data();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        Data();

    }

    private void Data(){
        beritaArtikelData = new ArrayList<>();
        cardViewBerita = new CardViewBerita(beritaArtikelData,Search.this);
        cardViewBerita.setHasStableIds(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cardViewBerita);
        apiservise.beritaEntity3( sv_pencarian.getQuery().toString(),"2018-12-25", "popularity ", Koneksi.API_KEY).enqueue(new Callback<BeritaEntity>() {
            @Override
            public void onResponse(Call<BeritaEntity> call, Response<BeritaEntity> response) {
                if (response.isSuccessful()){
                    for (BeritaArtikelData data : response.body().getArtikelData()){
                        beritaArtikelData.add(data);
                        cardViewBerita.addItem(0);
                    }
                    Log.i("xxxx","data" + beritaArtikelData.size());
                }
            }

            @Override
            public void onFailure(Call<BeritaEntity> call, Throwable t) {

            }

        });
    }





}
