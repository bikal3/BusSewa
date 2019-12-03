package com.example.bustracker.impl;

import com.example.bustracker.api.APIs;
import com.example.bustracker.models.NewsModel;
import com.example.bustracker.response.NewsResponse;
import com.example.bustracker.utils.APIError;
import com.example.bustracker.utils.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class NewsImpl {
    private Gson gson;
    private APIs newsApi;
//    private APIError apiError;

    public NewsImpl(){
        newsApi= RetrofitClient.getInstance().create(APIs.class);
        gson =new GsonBuilder().create();
//       apiError=new APIError();
    }
    public List<NewsModel> getNews(){
        List<NewsModel> news=new ArrayList<>();
        Call<NewsResponse> newscall=newsApi.fetchnews();
        try{
            Response<NewsResponse> newsResponse=newscall.execute();
            if(!newsResponse.isSuccessful()){
                return news;
            }
            else if (newsResponse.body().getNewslist()!=null){
                news=newsResponse.body().getNewslist();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return news;
    }
    public NewsResponse getSingleNews(String id){
        NewsResponse newsResponse=null;
        Call<NewsResponse> singlenewscall=newsApi.fetchsingnews(id);
        try{
            Response<NewsResponse> singleNewsResponse=singlenewscall.execute();
            if (!singleNewsResponse.isSuccessful()){
                return newsResponse;
            }
            newsResponse=singleNewsResponse.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newsResponse;
    }
}
