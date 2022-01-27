package com.example.tpo_training_and_placement.data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;

import java.util.Objects;

public class EditPlacementData extends AppCompatActivity {

    public ImageButton arrowBackImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_edit_placement);

        Objects.requireNonNull(getSupportActionBar()).hide();

        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_data_edit_placement);

        arrowBackImageButton.setOnClickListener(view -> {
            finish();
        });
    }
}