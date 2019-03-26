package com.Desert.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText user, pass;
    Button login;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        user = findViewById(R.id.txtUsername);
        pass = findViewById(R.id.txtPassword);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(v -> {
            if (!isError()){
                UtilsSession.saveSharedSetting(LoginActivity.this,"myLogin","true");
                Intent imloggedIn = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(imloggedIn);
                finish();
            } else {
                pass.setText("");
            }
        });
    }

    private boolean isError(){
        if (user.getText() == null){
            Toast.makeText(this,"Username can't be blank!",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (pass.getText() == null){
            Toast.makeText(this,"Password can't be blank!",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (pass.getText().length() < 8){
            Toast.makeText(this,"Password is at least 8 characters!",Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
