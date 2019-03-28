package com.Desert.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private ImageView logoImageView;
    private ImageView jobImageView;
    private ImageView profileImageView;
    private boolean loggedIn;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //check login
        loggedIn = Boolean.valueOf(UtilsSession.readSharedSetting(MainActivity.this, "myLogin", "false"));

        logoImageView = findViewById(R.id.logoImageView);
        jobImageView = findViewById(R.id.jobImageView);
        profileImageView = findViewById(R.id.profileImageView);

        profileImageView.setOnClickListener(view -> gotoProfile());
        jobImageView.setOnClickListener(view -> gotoJobsList());
//        this.logoImageView.setOnClickListener(view ->gotoCvLayout());
    }

    private void gotoProfile(){
        //login required
        if (!loggedIn) {
            Intent introIntent = new Intent(MainActivity.this, LoginActivity.class);
            introIntent.putExtra("myLogin", loggedIn);
            startActivity(introIntent);
        } else {
            Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(intent);
        }
    }

    private void gotoJobsList(){
        Intent intent = new Intent(MainActivity.this,JobsListActivity.class);
        startActivity(intent);
    }

//    private void gotoCvLayout(){
//        setContentView(R.layout.cvlayout);
//    }

    }

