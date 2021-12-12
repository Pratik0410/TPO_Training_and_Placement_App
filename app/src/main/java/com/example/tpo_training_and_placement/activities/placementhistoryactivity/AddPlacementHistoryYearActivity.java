package com.example.tpo_training_and_placement.activities.placementhistoryactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;

public class AddPlacementHistoryYearActivity extends AppCompatActivity {

    public ImageButton addPlacementDataImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_placement_history_year);

        getSupportActionBar().hide();

        addPlacementDataImageButton = findViewById(R.id.id_add_placement_history_data);

        addPlacementDataImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddPlacementHistoryYearActivity.this,AddPlacementHistoryDataActivity.class));
            }
        });
    }
}