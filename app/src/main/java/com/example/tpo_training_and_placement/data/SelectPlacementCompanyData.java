package com.example.tpo_training_and_placement.data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.errorhandling.WrapContentLinearLayoutManager;
import com.example.tpo_training_and_placement.adapters.AddPlacementOpportunityAdapter;
import com.example.tpo_training_and_placement.models.AddPlacementOpportunityModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SelectPlacementCompanyData extends AppCompatActivity {

    public ImageButton arrowBackImageButton;
    public RecyclerView selectCompanyRecyclerView;
    public AddPlacementOpportunityAdapter placementOpportunityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_select_placement_company);

        Objects.requireNonNull(getSupportActionBar()).hide();

        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_data_select_placement_company);
        selectCompanyRecyclerView = findViewById(R.id.id_select_company_recycler_view_in_data_select_company);

        selectCompanyRecyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this));

        FirebaseRecyclerOptions<AddPlacementOpportunityModel> options =
                new FirebaseRecyclerOptions.Builder<AddPlacementOpportunityModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("List of Companies"), AddPlacementOpportunityModel.class)
                        .build();

        placementOpportunityAdapter = new AddPlacementOpportunityAdapter(options);
        selectCompanyRecyclerView.setAdapter(placementOpportunityAdapter);

        arrowBackImageButton.setOnClickListener(view -> {
            finish();
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        placementOpportunityAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        placementOpportunityAdapter.stopListening();
    }
}