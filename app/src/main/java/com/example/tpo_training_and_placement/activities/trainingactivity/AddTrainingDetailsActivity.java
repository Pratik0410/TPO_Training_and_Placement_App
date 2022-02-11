package com.example.tpo_training_and_placement.activities.trainingactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.placementopportunity.AddPlacementOpportunityActivity;
import com.example.tpo_training_and_placement.data.SelectPlacementCompanyData;
import com.example.tpo_training_and_placement.ui.TrainingUi;

public class AddTrainingDetailsActivity extends AppCompatActivity {

    public ImageButton arrowBackImageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_training_details);

        getSupportActionBar().hide();

        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_activity_add_training_details);

        arrowBackImageButton.setOnClickListener(view -> {
            finish();
        });

    }
}