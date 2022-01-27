package com.example.tpo_training_and_placement.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.data.EditPlacementData;
import com.example.tpo_training_and_placement.data.SelectPlacementCompanyData;

import java.util.Objects;

public class PlacementOpportunityUi extends AppCompatActivity {

    public CardView placementOpportunityUiCardView;
    public CardView editPlacementOpportunitiesCardView;
    public CardView addPlacementOpportunitiesCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_placement_opportunity);

        Objects.requireNonNull(getSupportActionBar()).hide();

        placementOpportunityUiCardView = findViewById(R.id.id_ui_placement_opportunity);
        editPlacementOpportunitiesCardView = findViewById(R.id.id_edit_placement_opportunities);
        addPlacementOpportunitiesCardView = findViewById(R.id.id_add_placement_opportunities);

        placementOpportunityUiCardView.setBackgroundResource(R.drawable.top_card_radius);

        editPlacementOpportunitiesCardView.setOnClickListener(view -> {
            startActivity(new Intent(PlacementOpportunityUi.this, EditPlacementData.class));
        });

        addPlacementOpportunitiesCardView.setOnClickListener(view -> {
            startActivity(new Intent(PlacementOpportunityUi.this, SelectPlacementCompanyData.class));
        });

    }
}