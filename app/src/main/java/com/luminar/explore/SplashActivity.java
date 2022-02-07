package com.luminar.explore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView bottomImg1,bottomImg2,bottomImg3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        init();


        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                bottomImg1.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.darkGreen));
            }
        },1500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                bottomImg2.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.darkGreen));
            }
        },2500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                bottomImg3.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.darkGreen));
            }
        },3500);
        

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(4000);

                } catch (Exception e){
                    e.printStackTrace();
                }

                startActivity(intent);
                finish();

            }
        }).start();

    }

    void init(){

        bottomImg1 = findViewById(R.id.bottomImg1);
        bottomImg2 = findViewById(R.id.bottomImg2);
        bottomImg3 = findViewById(R.id.bottomImg3);

    }
}