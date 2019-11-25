package com.example.bustracker.response;

import com.example.bustracker.models.NewsModel;

import java.util.List;

public class NewsResponse {
    private List<NewsModel> newslist;
    private NewsModel model;
    private String message;

    public List<NewsModel> getNewslist() {
        return newslist;
    }

    public NewsModel getModel() {
        return model;
    }

    public String getMessage() {
        return message;
    }
}
