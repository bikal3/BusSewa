package com.example.bustracker.impl;

import com.example.bustracker.api.APIs;
import com.example.bustracker.models.JobVacancyModel;
import com.example.bustracker.response.JobVacancyResponse;
import com.example.bustracker.utils.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class JobVacancyImpl {
    private Gson gson;
    private APIs jobVacancyApi;

    public  JobVacancyImpl(){
        jobVacancyApi = RetrofitClient.getInstance().create(APIs.class);
        gson =new GsonBuilder().create();
    }
    public List<JobVacancyModel> getJob(){
        List<JobVacancyModel> jobVacancy=new ArrayList<>();
        Call<JobVacancyResponse> jobVacancycall=jobVacancyApi.fetchjobVacancy();

        try {
            Response<JobVacancyResponse> jobVacancyResponse=jobVacancycall.execute();
            if(!jobVacancyResponse.isSuccessful()){
                return jobVacancy;
            }
            else if (jobVacancyResponse.body().getJobvacancies()!=null){
                jobVacancy=jobVacancyResponse.body().getJobvacancies();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jobVacancy;
    }
    public JobVacancyResponse getSingleJobVacancy(String id){
        JobVacancyResponse jobVacancyResponse=null;
        Call<JobVacancyResponse> singlejobVacancy =jobVacancyApi.fetchsingjobvacancy(id);
        try {
            Response<JobVacancyResponse>   jobVacancyResponseResponse=singlejobVacancy.execute();
            if(!jobVacancyResponseResponse.isSuccessful()){
                return jobVacancyResponse;
            }
            jobVacancyResponse=jobVacancyResponseResponse.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  jobVacancyResponse;
    }
}
