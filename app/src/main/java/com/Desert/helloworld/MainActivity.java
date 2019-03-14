package com.Desert.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView logoImageView;
    private ImageView jobImageView;
    private ImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.logoImageView = findViewById(R.id.logoImageView);
        this.jobImageView = findViewById(R.id.jobImageView);
        this.profileImageView = findViewById(R.id.profileImageView);

        this.profileImageView.setOnClickListener(view -> gotoProfile());
        this.logoImageView.setOnClickListener(view ->gotoCvLayout());
    }

    private void gotoProfile() {
        setContentView(R.layout.profile_layout);
    }
    private void gotoCvLayout(){
        setContentView(R.layout.cvlayout);
    }

}
