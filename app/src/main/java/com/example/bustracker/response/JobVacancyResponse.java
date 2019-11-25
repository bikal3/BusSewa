package com.example.bustracker.response;

import com.example.bustracker.models.JobVacancyModel;

import java.util.List;

public class JobVacancyResponse {
    private List<JobVacancyModel> jobvacancies;
    private JobVacancyModel jobvacancy;
    private String message;

    public List<JobVacancyModel> getJobvacancies() {
        return jobvacancies;
    }

    public JobVacancyModel getJobvacancy() {
        return jobvacancy;
    }

    public String getMessage() {
        return message;
    }
}
