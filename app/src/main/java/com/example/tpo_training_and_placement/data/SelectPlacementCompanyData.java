package com.example.tpo_training_and_placement.data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;

import java.util.Objects;

public class SelectPlacementCompanyData extends AppCompatActivity {

    public ImageButton arrowBackImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_select_placement_company);

        Objects.requireNonNull(getSupportActionBar()).hide();

        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_data_select_placement_company);

        arrowBackImageButton.setOnClickListener(view -> {
            finish();
        });

    }
}