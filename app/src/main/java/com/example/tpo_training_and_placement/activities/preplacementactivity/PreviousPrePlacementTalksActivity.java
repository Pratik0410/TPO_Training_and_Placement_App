package com.example.tpo_training_and_placement.activities.preplacementactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tpo_training_and_placement.R;

public class PreviousPrePlacementTalksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_pre_placement_talks);

        getSupportActionBar().hide();
    }
}