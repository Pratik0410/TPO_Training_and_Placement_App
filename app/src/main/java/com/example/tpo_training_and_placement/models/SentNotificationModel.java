package com.example.tpo_training_and_placement.models;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tpo_training_and_placement.R;

public class SentNotificationModel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.model_sent_notification);

        getSupportActionBar().hide();
    }
}