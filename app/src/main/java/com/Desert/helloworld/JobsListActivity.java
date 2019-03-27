package com.Desert.helloworld;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.Desert.helloworld.adapter.JobsListAdapter;
import com.Desert.helloworld.dto.Company;
import com.Desert.helloworld.dto.Job;

import java.util.ArrayList;

public class JobsListActivity extends AppCompatActivity {
    private RecyclerView lvJobs;
    private EditText filter;
    private JobsListAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Job> jobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_jobs_activity);

        setTitle(R.string.jos_list);

        lvJobs = findViewById(R.id.jobsListView);
        filter = findViewById(R.id.searchFilter);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        lvJobs.setLayoutManager(layoutManager);

        jobs = new ArrayList<>();

        Job job1 = new Job("Engineer","2000 - 6000 USD",new Company("Wisky",R.drawable.logo));
        Job job2 = new Job("Java Engineer","2000 - 3000 USD",new Company("Wisky",R.drawable.logo));
        Job job3 = new Job("C# Engineer","2000",new Company("Wisky",R.drawable.logo));
        Job job4 = new Job("C Engineer","2000",new Company("Wisky",R.drawable.logo));
        Job job5 = new Job(".NET Engineer","2000",new Company("Wisky",R.drawable.logo));
        Job job6 = new Job("C++ Engineer","2000",new Company("Wisky",R.drawable.logo));
        Job job7 = new Job("Python Engineer","2000",new Company("Wisky",R.drawable.logo));
        Job job8 = new Job("Ruby Engineer","2000",new Company("Wisky",R.drawable.logo));

        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);
        jobs.add(job4);
        jobs.add(job5);
        jobs.add(job6);
        jobs.add(job7);
        jobs.add(job8);

        customAdapter = new JobsListAdapter(JobsListActivity.this,jobs);
        lvJobs.setAdapter(customAdapter);

        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (JobsListActivity.this).customAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
