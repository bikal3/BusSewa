package com.example.bustracker.api;

import com.example.bustracker.response.JobVacancyResponse;
import com.example.bustracker.response.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIs {

    @GET("news")
    Call<NewsResponse> fetchnews();
    @GET("news/{id}")
    Call<NewsResponse> fetchsingnews(@Path("id")String id);
    @GET("jobvacancy")
    Call<JobVacancyResponse> fetchjobVacancy();
    @GET("jobvacancy/{id}")
    Call<JobVacancyResponse> fetchsingjobvacancy(@Path("id")String id);
}
