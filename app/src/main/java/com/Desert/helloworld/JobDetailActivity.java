package com.Desert.helloworld;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.Desert.helloworld.dto.Job;

public class JobDetailActivity extends AppCompatActivity {

    ImageView imgCompany;
    TextView jobName, companyName, salary, time, quantity, required, companyPhone, companyEmail;
    Button apply;
    Job job;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);

        jobName = findViewById(R.id.txtJD_JobName);
        imgCompany = findViewById(R.id.imgCompany);
        companyName = findViewById(R.id.txtJD_CompanyName);
        salary = findViewById(R.id.txtJD_Salary);
        time = findViewById(R.id.txtJD_Time);
        quantity = findViewById(R.id.txtJD_Quantity);
        required = findViewById(R.id.txtJD_Required);
        companyPhone = findViewById(R.id.txtJD_CompanyPhone);
        companyEmail = findViewById(R.id.txtJD_CompanyEmail);
        apply = findViewById(R.id.btnApply);

        setJobInfo();

    }

    private void setJobInfo(){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                job = (Job) bundle.getSerializable("JOB");
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                setTitle(job.getName());
                jobName.setText(job.getName());
                imgCompany.setImageResource(job.getCompany().getImage());
                companyName.setText(job.getCompany().getName());
                salary.setText(job.getSalary());
                time.setText("5 mins ago");
                quantity.setText("5 slots");
                required.setText("2 years exp required");
                companyPhone.setText("0123456789");
                companyEmail.setText("hr.wisky@wisky.vn");
            }
        }.execute();

    }
}
