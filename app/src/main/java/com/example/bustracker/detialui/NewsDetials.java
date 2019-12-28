package com.example.bustracker.detialui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bustracker.R;
import com.example.bustracker.impl.NewsImpl;
import com.example.bustracker.models.NewsModel;
import com.example.bustracker.response.NewsResponse;
import com.example.bustracker.utils.Helper;

public class NewsDetials extends AppCompatActivity {
    TextView title, date, publication, desc1, desc2;
    ImageView newsimage;
    private String id = "";
    private NewsImpl newsImpl;
    private NewsModel newsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_main);
        title = findViewById(R.id.txt_title_news_main);
        date = findViewById(R.id.txt_date_news_main);
        publication = findViewById(R.id.txt_publish_news_main);
        desc1 = findViewById(R.id.txt_des_news_main);
        desc2 = findViewById(R.id.txt_dess_news_main);
        newsimage = findViewById(R.id.img_news_main);

        id = getIntent().getStringExtra("id");
        newsImpl = new NewsImpl();
        getNewsDetail();
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.trans_det_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("News Details");

    }

    private void getNewsDetail() {
        Helper.StrictMode();
        if (!id.equals("")) {
            NewsResponse newsResponse = newsImpl.getSingleNews(id);
            if (newsResponse != null) {
                newsModel = newsResponse.getModel();
                Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
                populateDetails(newsModel);
            }
        }

    }

    private void populateDetails(NewsModel newsModel) {
        title.setText(newsModel.getTitle());
        date.setText(Helper.formatDate("yyyy-MM-dd HH:mm:ss", "dd-MMM", newsModel.getNdate()));
        publication.setText(newsModel.getPublication());
        desc1.setText(newsModel.getDescription1());
        desc2.setText(newsModel.getDescription2());
        Helper.setImage(newsModel.getImage(), newsimage);
    }
}
