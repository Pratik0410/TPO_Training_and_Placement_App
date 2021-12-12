package com.example.tpo_training_and_placement.activities.placementhistoryactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tpo_training_and_placement.R;

public class AddPlacementHistoryDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_placement_history_data);

        getSupportActionBar().hide();
    }
}