package com.example.tpo_training_and_placement.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;

public class PlacementHistoryUi extends AppCompatActivity {

    public CardView placementHistoryYearUiCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_placement_history);

        placementHistoryYearUiCardView = findViewById(R.id.id_ui_placement_history);



        getSupportActionBar().hide();

        placementHistoryYearUiCardView.setBackgroundResource(R.drawable.top_card_radius);



    }
}