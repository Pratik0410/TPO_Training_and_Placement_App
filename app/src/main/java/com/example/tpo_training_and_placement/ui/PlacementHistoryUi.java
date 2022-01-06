package com.example.tpo_training_and_placement.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.currentcompanyactivity.RegisterCurrentCompanyActivity;
import com.example.tpo_training_and_placement.activities.placementhistoryactivity.AddPlacementHistoryYearActivity;

public class PlacementHistoryUi extends AppCompatActivity {

    public CardView placementHistoryYearUiCardView;
    public ImageButton addPlacementHistoryImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_placement_history);

        placementHistoryYearUiCardView = findViewById(R.id.id_ui_placement_history);
        addPlacementHistoryImageButton = findViewById(R.id.id_add_placement_year);


        getSupportActionBar().hide();

        placementHistoryYearUiCardView.setBackgroundResource(R.drawable.top_card_radius);
        addPlacementHistoryImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlacementHistoryUi.this, AddPlacementHistoryYearActivity.class));
            }
        });


    }
}