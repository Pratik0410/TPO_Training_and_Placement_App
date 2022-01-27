package com.example.tpo_training_and_placement.activities.placementopportunity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tpo_training_and_placement.R;

import java.util.Objects;

public class AddPlacementOpportunityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_placement_opportunity);

        Objects.requireNonNull(getSupportActionBar()).hide();

    }
}