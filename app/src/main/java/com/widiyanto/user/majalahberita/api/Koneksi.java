package com.widiyanto.user.majalahberita.api;

import android.content.Context;

import dimitrovskif.smartcache.BasicCaching;
import dimitrovskif.smartcache.SmartCallFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Koneksi {

    public static final String API_BASE_URL = "https://newsapi.org/v2/";

    public static final String API_KEY = "fb74ae3983d447aa97d219af19a9a766";



    static OkHttpClient okHttpClient;
    static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static API createService(Context context) {
        SmartCallFactory smartCallFactory = new SmartCallFactory(BasicCaching.fromCtx(context));
        okHttpClient = new OkHttpClient();
        Retrofit retrofit = builder
                .client(okHttpClient)
                .addCallAdapterFactory(smartCallFactory)
                .build();

        return retrofit.create(API.class);
    }

}
