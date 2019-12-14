package com.example.bustracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.bustracker.R;
import com.example.bustracker.adapters.NewsAdapter;
import com.example.bustracker.impl.NewsImpl;
import com.example.bustracker.models.NewsModel;
import com.example.bustracker.response.NewsResponse;
import com.example.bustracker.utils.Helper;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {
    private NewsImpl newsImpl;
    private Context context;
    private List<NewsModel> newsModelsList;
    private RecyclerView newsrecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        newsImpl=new NewsImpl();
        newsModelsList= new ArrayList<>();

        newsrecycler=findViewById(R.id.news_recycler);
        newsrecycler.setLayoutManager(new LinearLayoutManager(this));
        getNewsdetials();
    }
    private  void getNewsdetials(){
        Helper.StrictMode();
        newsModelsList= newsImpl.getNews();
        NewsAdapter newsAdapter=new NewsAdapter(this,newsModelsList);
        newsrecycler.setAdapter(newsAdapter);
    }
}
