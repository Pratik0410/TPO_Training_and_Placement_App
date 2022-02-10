package com.example.tpo_training_and_placement.activities.placementhistoryactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;

import java.util.Objects;

public class EditPlacementHistoryActivity extends AppCompatActivity {

    public ImageButton arrowBackImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_placement_history);

        Objects.requireNonNull(getSupportActionBar()).hide();

        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_activity_edit_placement_history);

        arrowBackImageButton.setOnClickListener(view -> finish());

    }
}