package com.example.tpo_training_and_placement.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.placementhistoryactivity.AddPlacementHistoryDataActivity;
import com.example.tpo_training_and_placement.data.EditPlacementHistoryData;
import com.example.tpo_training_and_placement.data.ViewPlacementHistoryData;

import java.util.Objects;

public class PlacementHistoryUi extends AppCompatActivity {

    public CardView placementHistoryYearUiCardView;
    public CardView addPlacementHistoryCardView;
    public CardView editPlacementHistoryCardView;
    public CardView viewPlacementHistoryCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_placement_history);

        placementHistoryYearUiCardView = findViewById(R.id.id_ui_placement_history);
        addPlacementHistoryCardView = findViewById(R.id.id_add_placement_history_cardview_in_ui_placement_history);
        editPlacementHistoryCardView = findViewById(R.id.id_edit_placement_history_cardview_in_ui_placement_history);
        viewPlacementHistoryCardView = findViewById(R.id.id_view_placement_history_cardview_in_ui_placement_history);

        Objects.requireNonNull(getSupportActionBar()).hide();

        placementHistoryYearUiCardView.setBackgroundResource(R.drawable.top_card_radius);

        addPlacementHistoryCardView.setOnClickListener(view -> startActivity(new Intent(PlacementHistoryUi.this, AddPlacementHistoryDataActivity.class)));
        viewPlacementHistoryCardView.setOnClickListener(view -> startActivity(new Intent(PlacementHistoryUi.this,ViewPlacementHistoryData.class)));
        editPlacementHistoryCardView.setOnClickListener(view -> startActivity(new Intent(PlacementHistoryUi.this, EditPlacementHistoryData.class)));

    }
}