package com.example.bustracker.detialui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bustracker.R;
import com.example.bustracker.api.APIs;
import com.example.bustracker.impl.JobVacancyImpl;
import com.example.bustracker.models.JobVacancyModel;
import com.example.bustracker.response.JobVacancyResponse;
import com.example.bustracker.utils.Helper;
import com.google.gson.Gson;

import org.jetbrains.annotations.TestOnly;

public class JobvacancyDetials extends AppCompatActivity {
 private  TextView title,requirement,experience,salary,time,desc;
 private String id;
 private JobVacancyImpl jobVacancyImpl;
 private JobVacancyModel jobVacancyModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vacancy_main);
        title=findViewById(R.id.txt_title_vm);
        requirement=findViewById(R.id.txt_req_vm);
        experience=findViewById(R.id.txt_exp_vm);
        salary=findViewById(R.id.txt_salary_vm);
        time=findViewById(R.id.txt_hours_vm);
        desc=findViewById(R.id.txt_desc_vm);

        id=getIntent().getStringExtra("id");
        jobVacancyImpl=new JobVacancyImpl();
        getJobVacancyDetail();


    }

    private void getJobVacancyDetail() {
        Helper.StrictMode();
        if(!id.equals("")){
            JobVacancyResponse jobVacancyResponse=jobVacancyImpl.getSingleJobVacancy(id);
            if(jobVacancyResponse!=null){
                jobVacancyModel =jobVacancyResponse.getJobvacancy();
                populateDetails(jobVacancyModel);

            };
        }
    }

    private void populateDetails(JobVacancyModel jobVacancyModel) {

        title.setText(jobVacancyModel.getTitle());
        requirement.setText(jobVacancyModel.getRequirednumber());
        experience.setText(jobVacancyModel.getExperience());
        desc.setText(jobVacancyModel.getDescription());
        time.setText(jobVacancyModel.getEmploye_type());
        salary.setText(jobVacancyModel.getSalary());
    }
}
