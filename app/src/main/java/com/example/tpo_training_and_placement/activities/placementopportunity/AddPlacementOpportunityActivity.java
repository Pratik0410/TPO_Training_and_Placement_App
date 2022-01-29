package com.example.tpo_training_and_placement.activities.placementopportunity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.example.tpo_training_and_placement.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.Objects;

public class AddPlacementOpportunityActivity extends AppCompatActivity {

    public String companyName;
    public MaterialTextView companyNameMaterialTexView;
    public ImageButton arrowBackImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_placement_opportunity);

        Objects.requireNonNull(getSupportActionBar()).hide();

        companyNameMaterialTexView = findViewById(R.id.id_company_name_in_job_opportunity);
        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_activity_add_placement_opportunity);

        companyName = getIntent().getExtras().get("Company Name").toString();

        companyNameMaterialTexView.setText(companyName);

        arrowBackImageButton.setOnClickListener(view -> finish());
    }
}