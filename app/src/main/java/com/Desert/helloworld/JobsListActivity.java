package com.Desert.helloworld;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.Desert.helloworld.adapter.JobsListAdapter;
import com.Desert.helloworld.dto.Company;
import com.Desert.helloworld.dto.Job;

import java.util.ArrayList;

public class JobsListActivity extends AppCompatActivity {
    private RecyclerView lvJobs;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_jobs_activity);

        setTitle(R.string.jos_list);

        lvJobs = findViewById(R.id.jobsListView);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        lvJobs.setLayoutManager(layoutManager);

        ArrayList<Job> jobs = new ArrayList<>();
        Job job1 = new Job("Engineer","2000",new Company("Wisky",R.drawable.logo));
        Job job2 = new Job("Engineer","2000",new Company("Wisky",R.drawable.logo));
        Job job3 = new Job("Engineer","2000",new Company("Wisky",R.drawable.logo));
        Job job4 = new Job("Engineer","2000",new Company("Wisky",R.drawable.logo));
        Job job5 = new Job("Engineer","2000",new Company("Wisky",R.drawable.logo));
        Job job6 = new Job("Engineer","2000",new Company("Wisky",R.drawable.logo));
        Job job7 = new Job("Engineer","2000",new Company("Wisky",R.drawable.logo));
        Job job8 = new Job("Engineer","2000",new Company("Wisky",R.drawable.logo));

        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);
        jobs.add(job4);
        jobs.add(job5);
        jobs.add(job6);
        jobs.add(job7);
        jobs.add(job8);

        JobsListAdapter customAdapter = new JobsListAdapter(jobs);
        lvJobs.setAdapter(customAdapter);
    }
}
