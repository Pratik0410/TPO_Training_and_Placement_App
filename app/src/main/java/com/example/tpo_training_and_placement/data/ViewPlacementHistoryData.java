package com.example.tpo_training_and_placement.data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tpo_training_and_placement.R;

import java.util.Objects;

public class ViewPlacementHistoryData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_view_placement_history);

        Objects.requireNonNull(getSupportActionBar()).hide();
    }
}