package com.example.tpo_training_and_placement.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.preplacementactivity.AddPrePlacementTalkActivity;
import com.example.tpo_training_and_placement.data.PreviousPrePlacementTalksData;

public class PrePlacementUi extends AppCompatActivity {

    public CardView prePlacementUiCardView;
    public CardView addPrePlacementTalksCardView;
    public CardView previousPrePlacementTalksCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_pre_placement);

        getSupportActionBar().hide();

        prePlacementUiCardView = findViewById(R.id.id_ui_pre_placement);
        addPrePlacementTalksCardView = findViewById(R.id.ID_Card_AddPrePlacement);
        previousPrePlacementTalksCardView = findViewById(R.id.ID_CardPreviousPrePlacement);

        prePlacementUiCardView.setBackgroundResource(R.drawable.top_card_radius);

        addPrePlacementTalksCardView.setOnClickListener(view ->
                startActivity(new Intent(PrePlacementUi.this, AddPrePlacementTalkActivity.class))
        );

        previousPrePlacementTalksCardView.setOnClickListener(view ->
                startActivity(new Intent(PrePlacementUi.this, PreviousPrePlacementTalksData.class))
        );

    }
}