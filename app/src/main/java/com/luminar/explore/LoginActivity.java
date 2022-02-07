package com.luminar.explore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.luminar.explore.grid.PlacesGridViewActivity;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText etEmail,etPassword;
    TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        btnLogin.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), PlacesGridViewActivity.class);
            startActivity(i);
            finish();
        });

    }

    private void init(){
        tvSignUp = findViewById(R.id.tvSignUp);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

}