package com.Desert.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class CVDetailActivity extends AppCompatActivity {
    private int PICK_PDF = 1;
    private Button buttonChoose;
    private EditText desc;
    private TextView filename;
    private Uri filePath;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cv_choose);
        setTitle("Edit CV Detail");

        buttonChoose = findViewById(R.id.btnBrowse);
        desc = findViewById(R.id.cv_description);
        filename = findViewById(R.id.cv_filename);

        buttonChoose.setOnClickListener(v -> chooseFile());
    }

    private void chooseFile(){
        Intent intent = new Intent();
        intent.setType("pdf -> application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select CV file"),PICK_PDF);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PDF && resultCode == RESULT_OK && data != null && data.getData() != null){
            filePath = data.getData();
            filename.setText(filePath.toString());
        }
    }
}
