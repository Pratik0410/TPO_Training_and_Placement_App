package com.example.tpo_training_and_placement.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.currentcompanyactivity.RegisterCurrentCompanyActivity;
import com.example.tpo_training_and_placement.activities.placementopportunity.JobOpportunityActivity;

public class PlacementOpportunityUi extends AppCompatActivity {

    public CardView placementOpportunityUiCardView;
    public ImageButton jobOpportunityImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_placement_opportunity);

        getSupportActionBar().hide();

        placementOpportunityUiCardView = findViewById(R.id.id_ui_placement_opportunity);
        jobOpportunityImageButton = findViewById(R.id.id_job_opportunities);

        placementOpportunityUiCardView.setBackgroundResource(R.drawable.top_card_radius);

        jobOpportunityImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlacementOpportunityUi.this, JobOpportunityActivity.class));
                finish();
            }
        });

    }
}