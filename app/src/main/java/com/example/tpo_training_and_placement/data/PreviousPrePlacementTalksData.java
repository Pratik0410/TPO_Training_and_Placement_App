package com.example.tpo_training_and_placement.data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.adapters.PrePlacementAdapter;
import com.example.tpo_training_and_placement.models.PrePlacementModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class PreviousPrePlacementTalksData extends AppCompatActivity {

    public ImageButton arrowBackImageButton;
    RecyclerView previousPrePlacementRecyclerView;
    PrePlacementAdapter prePlacementAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_previous_pre_placement_talks);

        Objects.requireNonNull(getSupportActionBar()).hide();

        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_data_previous_pre_placement_talk);
        previousPrePlacementRecyclerView = findViewById(R.id.id_recycler_view_in_previous_pre_placement);
        previousPrePlacementRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<PrePlacementModel> options =
                new FirebaseRecyclerOptions.Builder<PrePlacementModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Pre Placement Talks"), PrePlacementModel.class)
                        .build();

        prePlacementAdapter = new PrePlacementAdapter(options);
        previousPrePlacementRecyclerView.setAdapter(prePlacementAdapter);

        arrowBackImageButton.setOnClickListener(view -> finish());
    }

    @Override
    protected void onStart() {
        super.onStart();
        prePlacementAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        prePlacementAdapter.stopListening();
    }
}