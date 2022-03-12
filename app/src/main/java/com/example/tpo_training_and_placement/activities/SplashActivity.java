package com.example.tpo_training_and_placement.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.tpo_training_and_placement.R;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    Timer welcomePageTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        welcomePageTimer = new Timer();

        welcomePageTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent new_page = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(new_page);
                finish();
            }
        },3800);

        Objects.requireNonNull(getSupportActionBar()).hide();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));

        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);

    }
}