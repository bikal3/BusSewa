package com.example.bustracker.response;

import com.example.bustracker.models.NewsModel;

import java.util.List;

public class NewsResponse {
    private List<NewsModel> newslist;
    private NewsModel newsDetails;
    private String message;

    public List<NewsModel> getNewslist() {
        return newslist;
    }

    public NewsModel getModel() {
        return newsDetails;
    }

    public String getMessage() {
        return message;
    }
}
