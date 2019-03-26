package com.Desert.helloworld.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Desert.helloworld.R;
import com.Desert.helloworld.dto.Job;

import java.util.ArrayList;

public class JobsListAdapter extends RecyclerView.Adapter<JobsListAdapter.MyHolder>{
    private ArrayList<Job> jobs;

    public JobsListAdapter(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.job_item_layout,viewGroup,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        Job job = jobs.get(i);
        myHolder.companyImg.setImageResource(job.getCompany().getImage());
        myHolder.companyName.setText(job.getCompany().getName());
        myHolder.jobName.setText(job.getName());
        myHolder.salary.setText(job.getSalary());
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        public TextView jobName, companyName, salary;
        public ImageView companyImg;

        public MyHolder(View itemView) {
            super(itemView);
            jobName = itemView.findViewById(R.id.txtJobName);
            companyName = itemView.findViewById(R.id.txtCompanyName);
            salary = itemView.findViewById(R.id.txtSalary);
            companyImg = itemView.findViewById(R.id.companyImg);
        }
    }
}