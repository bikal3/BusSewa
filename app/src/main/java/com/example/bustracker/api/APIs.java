package com.example.bustracker.api;

import com.example.bustracker.response.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIs {

    @GET("news")
    Call<NewsResponse> fetchnews();
    @GET("news/{id}")
    Call<NewsResponse> fetchsingnews(@Path("id")String id);
}
