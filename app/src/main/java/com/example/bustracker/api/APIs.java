package com.example.bustracker.api;

import com.example.bustracker.response.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {

    @GET("get_news")
    Call<NewsResponse> fetchnews();
}
