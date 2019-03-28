package com.Desert.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    private Button editProfile, myCV, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");
        editProfile = findViewById(R.id.btnP_edit);
        myCV = findViewById(R.id.btnP_myCV);
        logout = findViewById(R.id.btnP_logout);

        myCV.setOnClickListener(v -> gotoMyCV());
        logout.setOnClickListener(v -> logout());
    }

    private void logout(){
        UtilsSession.saveSharedSetting(ProfileActivity.this,"myLogin", "false");
        UtilsSession.sharedPrefesSave(getApplicationContext(),"");
        Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
        startActivity(intent);
    }

    private void gotoMyCV(){
        Intent intent = new Intent(ProfileActivity.this,CVDetailActivity.class);
        startActivity(intent);
    }
}
