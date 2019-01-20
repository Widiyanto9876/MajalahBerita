package com.widiyanto.user.majalahberita.api;

import com.widiyanto.user.majalahberita.Entity.BeritaEntity;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("everything")
    Call<BeritaEntity> beritaEntity(@Query("q") String q,
                                    @Query("from") String from,
                                    @Query("sortBy") String sortBy,
                                    @Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<BeritaEntity> beritaEntity2(@Query("country") String country,
                                    @Query("category") String catagory,
                                    @Query("apiKey") String apiKey);

    @GET ("everything ")
    Call<BeritaEntity>beritaEntity3(@Query("q") String q,
                                    @Query("from") String from,
                                    @Query("sortBy") String sortBy,
                                    @Query("apiKey") String apiKey);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("")
            .build();


}
