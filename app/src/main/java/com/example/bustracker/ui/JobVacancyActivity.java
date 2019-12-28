package com.example.bustracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.bustracker.R;
import com.example.bustracker.adapters.JobVacancyAdapter;
import com.example.bustracker.impl.JobVacancyImpl;
import com.example.bustracker.models.JobVacancyModel;
import com.example.bustracker.utils.Helper;

import java.util.ArrayList;
import java.util.List;

public class JobVacancyActivity extends AppCompatActivity {
    
    private JobVacancyImpl jobVacancyImpl;
    private List<JobVacancyModel> jobVacancyList;
    private RecyclerView jobVacancyrecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_vacancy);
        jobVacancyImpl=new JobVacancyImpl();
        jobVacancyList=new ArrayList<>();

        jobVacancyrecycler=findViewById(R.id.job_vacancy_recycler);
        jobVacancyrecycler.setLayoutManager(new LinearLayoutManager(this));
        getJobVacancyList();
        initToolbar();
    }
    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.trans_det_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("JobVacancy");
    }

    private void getJobVacancyList() {
        Helper.StrictMode();
        jobVacancyList= jobVacancyImpl.getJob();
        JobVacancyAdapter jobVacancyAdapter=new JobVacancyAdapter(this,jobVacancyList);
        jobVacancyrecycler.setAdapter(jobVacancyAdapter);
    }
}
