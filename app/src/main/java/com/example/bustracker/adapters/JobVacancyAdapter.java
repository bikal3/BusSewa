package com.example.bustracker.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bustracker.R;
import com.example.bustracker.detialui.JobvacancyDetials;
import com.example.bustracker.detialui.NewsDetials;
import com.example.bustracker.models.JobVacancyModel;
import com.example.bustracker.ui.JobVacancyActivity;
import com.example.bustracker.utils.Helper;

import java.util.List;

public class JobVacancyAdapter extends RecyclerView.Adapter<JobVacancyAdapter.VacancyViewHolder> {
    private Context context;
    private List<JobVacancyModel> jobVacancyList;

    public JobVacancyAdapter(Context context, List<JobVacancyModel> jobVacancyList) {
        this.context = context;
        this.jobVacancyList = jobVacancyList;
    }

    @NonNull
    @Override
    public VacancyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vacancyView = LayoutInflater.from(context).inflate(R.layout.vacancy_recyclerview, parent, false);
        return new VacancyViewHolder(vacancyView);
    }

    @Override
    public void onBindViewHolder(@NonNull VacancyViewHolder holder, int position) {
        JobVacancyModel jobVacancyModel = jobVacancyList.get(position);
        holder.bindData(jobVacancyModel);
    }

    @Override
    public int getItemCount() {
        return jobVacancyList.size();
    }

    public class VacancyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, department, experience, location, requirement, date;

        public VacancyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_title_vr);
            department = itemView.findViewById(R.id.txt_dep_vr);
            experience = itemView.findViewById(R.id.txt_exp_vr);
            location = itemView.findViewById(R.id.txt_location_vr);
            requirement = itemView.findViewById(R.id.txt_req_vr);
            date = itemView.findViewById(R.id.txt_date_vr);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent jobVacancyDetails = new Intent(context, JobvacancyDetials.class);
                    jobVacancyDetails.putExtra("id", jobVacancyList.get(getAdapterPosition()).getId());
                    context.startActivity(jobVacancyDetails);
                }
            });
        }

        public void bindData(JobVacancyModel jobVacancyModel) {
            title.setText(jobVacancyModel.getTitle());
            department.setText(jobVacancyModel.getEmploye_type());
            experience.setText(jobVacancyModel.getExperience());
            location.setText(jobVacancyModel.getLocation());
            requirement.setText(jobVacancyModel.getRequirednumber());
            date.setText(Helper.formatDate("yyyy-MM-dd HH:mm:ss", "dd-MMM", jobVacancyModel.getVdate()));
        }

    }
}
