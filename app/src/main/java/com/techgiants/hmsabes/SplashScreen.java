package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_splash_screen);
            Intent iHome=new Intent(SplashScreen.this, LoginActivityJava.class);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run(){
                    startActivity(iHome);
                    finish();
                }
            },3000);

        }
    }