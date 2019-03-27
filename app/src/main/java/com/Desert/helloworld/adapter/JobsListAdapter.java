package com.Desert.helloworld.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.Desert.helloworld.JobDetailActivity;
import com.Desert.helloworld.R;
import com.Desert.helloworld.dto.Job;
import com.Desert.helloworld.interfaces.ItemClickListener;

import java.util.ArrayList;
import java.util.Collection;

public class JobsListAdapter extends RecyclerView.Adapter<JobsListAdapter.MyHolder> implements Filterable {
    private ArrayList<Job> jobs;
    private ArrayList<Job> jobsListFull;
    private Context context;

    public JobsListAdapter(Context context, ArrayList<Job> jobs) {
        this.context = context;
        this.jobs = jobs;
        jobsListFull = new ArrayList<>(jobs);
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
        myHolder.setItemClickListener((view, pos, isLongClick) -> {
            if (isLongClick)
                Toast.makeText(context,"Long click " + jobs.get(pos).getName(),Toast.LENGTH_LONG).show();
            else {
                Toast.makeText(context, "" + jobs.get(pos).getName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, JobDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("JOB",jobs.get(pos));
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        public TextView jobName, companyName, salary;
        public ImageView companyImg;

        private ItemClickListener itemClickListener;

        public MyHolder(View itemView) {
            super(itemView);
            jobName = itemView.findViewById(R.id.txtJobName);
            companyName = itemView.findViewById(R.id.txtCompanyName);
            salary = itemView.findViewById(R.id.txtSalary);
            companyImg = itemView.findViewById(R.id.companyImg);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListener(ItemClickListener item){
            itemClickListener = item;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),true);
            return true;
        }
    }

    @Override
    public Filter getFilter() {
        return jobsFilter;
    }

    private Filter jobsFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Job> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(jobsListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Job item: jobsListFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            jobs.clear();
            jobs.addAll((Collection<? extends Job>) results.values);
            notifyDataSetChanged();
        }
    };

}