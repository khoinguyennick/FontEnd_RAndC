package com.Desert.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.Desert.dto.Job;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class JobsActivity extends AppCompatActivity {

//    List<Job> joblist = new ArrayList<>();

//        joblist.add(job2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);


//        Job job = new Job(1,"icons8search96","TMA solution tech","cong vien phan mem quang trung",600,1000);
//        Job job2 = new Job(2,"icons8search96","Cybersoft","cong vien phan mem quang trung",600,1000);
//        joblist.add(job);
//        joblist.add(job2);

//        CustomAdapter customAdapter = new CustomAdapter(joblist,getApplicationContext());
//        ListView listView = findViewById(R.id.jobList);
//        listView.setAdapter(customAdapter);
    }

//    class CustomAdapter extends BaseAdapter{
//
//        @Override
//        public int getCount() {
//            return joblist.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            convertView = getLayoutInflater().inflate(R.layout.job_item_layout,null);
//            ImageView logo = (ImageView)convertView.findViewById(R.id.imgJobLogoItem);
//            TextView jobName = (TextView)convertView.findViewById(R.id.txtJobNameItem);
//            TextView location = (TextView)convertView.findViewById(R.id.txtLocationItem);
//            TextView minSalary = (TextView)convertView.findViewById(R.id.txtMinSalary);
//            TextView maxSalary = (TextView)convertView.findViewById(R.id.txtMaxSalary);
//            //set resource view content
//            logo.setImageResource(R.drawable.icons8search96);
//            jobName.setText(joblist.get(position).getJobName());
//            location.setText(joblist.get(position).getLocation());
//            minSalary.setText(joblist.get(position).getMinSalary() + "");
//            maxSalary.setText(joblist.get(position).getMaxSalary() + "");
//            return convertView;
//        }
//    }


}
