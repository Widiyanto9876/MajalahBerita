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

public class user extends AppCompatActivity {

    private TextView Username;
    private TextView Email;
    private TextView NamaPengguna;
    private TextView NomerHP;
    private TextView Alamat;

//
//    private RecyclerView recyclerView;
//
//    private LinearLayoutManager layoutManager;
//    private CardViewBerita cardViewBerita;
//    private List<BeritaArtikelData> beritaArtikelData;
//    private API apiservise;



    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.beranda:
                    Intent intent = new Intent(user.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.search:
                    Intent intent1 = new Intent(user.this, Search.class);
                    startActivity(intent1);
                    return true;
                case R.id.user:

                    finish();
                    overridePendingTransition(0,0);
                    startActivity(getIntent());

                    return true;
            }
            return false;
        }
    };

    SharedPref sharedPref;

    Boolean isLogin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Username = (TextView) findViewById(R.id.tv_nama);
        Email = (TextView) findViewById(R.id.tv_email);
        NamaPengguna = (TextView) findViewById(R.id.ed_nama1);
        NomerHP = (TextView) findViewById(R.id.ed_hp1);
        Alamat = (TextView) findViewById(R.id.ed_alamat1);


        sharedPref = new SharedPref(this);

        setData();

//        recyclerView = (RecyclerView) findViewById(R.id.rv_data);
//        layoutManager = new LinearLayoutManager(this);

//        Data();
    }

    private void setData() {
        NamaPengguna.setText(sharedPref.getNamaLengkap());
        Email.setText(sharedPref.getEmail());
        Username.setText(sharedPref.getUserName());
        NomerHP.setText(sharedPref.getNomerHP());
        Alamat.setText(sharedPref.getAlamat());
    }

//    private void Data(){
//        beritaArtikelData = new ArrayList<>();
//        cardViewBerita = new CardViewBerita(beritaArtikelData,user.this);
//        cardViewBerita.setHasStableIds(true);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(cardViewBerita);
//        apiservise.beritaEntity3("Apple ","2018-12-20", "popularity ", Koneksi.API_KEY).enqueue(new Callback<BeritaEntity>() {
//            @Override
//            public void onResponse(Call<BeritaEntity> call, Response<BeritaEntity> response) {
//                if (response.isSuccessful()){
//                    for (BeritaArtikelData data : response.body().getArtikelData()){
//                        beritaArtikelData.add(data);
//                        cardViewBerita.addItem(0);
//                    }
//                    Log.i("xxxx","data" + beritaArtikelData.size());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BeritaEntity> call, Throwable t) {
//
//            }
//
//        });
//    }

}
