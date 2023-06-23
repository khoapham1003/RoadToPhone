package com.example.a21521003_callapi;

import com.squareup.moshi.Moshi;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceHolderAPI {
    Moshi moshi = new Moshi.Builder().build();
    PlaceHolderAPI placeHolderApi = new Retrofit.Builder()
            .baseUrl("https://3bro.hoanghy.tech/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(PlaceHolderAPI.class);
    @GET("weather")
    Call<Forecast> getForecast(@Query("q") String query);
}
