package com.example.bustracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bustracker.R;
import com.example.bustracker.models.NewsModel;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private Context context;
    private List<NewsModel> newsList;

    public NewsAdapter(Context context, List<NewsModel> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View newsView= LayoutInflater.from(context).inflate(R.layout.news_recyclerview_layout,parent,false);
        return new NewsViewHolder(newsView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        private ImageView newsImage;
        private TextView newsTitle,newsDate,newsPublication;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle=itemView.findViewById(R.id.txt_title_news);
            newsDate=itemView.findViewById(R.id.txt_date_news);
            newsPublication=itemView.findViewById(R.id.txt_publish_news);
            newsImage=itemView.findViewById(R.id.img_news);

        }
    }
}
