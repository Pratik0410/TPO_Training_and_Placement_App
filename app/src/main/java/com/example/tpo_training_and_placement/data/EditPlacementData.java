package com.example.tpo_training_and_placement.data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;
import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.errorhandling.WrapContentLinearLayoutManager;
import com.example.tpo_training_and_placement.adapters.EditPlacementOpportunityAdapter;
import com.example.tpo_training_and_placement.models.EditPlacementOpportunityModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Objects;

public class EditPlacementData extends AppCompatActivity {

    public ImageButton arrowBackImageButton;
    public RecyclerView editCompanyRecyclerView;
    public EditPlacementOpportunityAdapter editPlacementOpportunityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_edit_placement);

        Objects.requireNonNull(getSupportActionBar()).hide();

        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_data_edit_placement);
        editCompanyRecyclerView = findViewById(R.id.id_edit_company_recycler_view_in_data_edit_placement);

        editCompanyRecyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this));

        FirebaseRecyclerOptions<EditPlacementOpportunityModel> options =
                new FirebaseRecyclerOptions.Builder<EditPlacementOpportunityModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Placement Opportunity"), EditPlacementOpportunityModel.class)
                .build();

        editPlacementOpportunityAdapter = new EditPlacementOpportunityAdapter(options);
        editCompanyRecyclerView.setAdapter(editPlacementOpportunityAdapter);

        arrowBackImageButton.setOnClickListener(view -> finish());

    }

    @Override
    protected void onStart() {
        super.onStart();
        editPlacementOpportunityAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        editPlacementOpportunityAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();

        FirebaseRecyclerOptions<EditPlacementOpportunityModel> options =
                new FirebaseRecyclerOptions.Builder<EditPlacementOpportunityModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Placement Opportunity"), EditPlacementOpportunityModel.class)
                        .build();

        editPlacementOpportunityAdapter = new EditPlacementOpportunityAdapter(options);
        editCompanyRecyclerView.setAdapter(editPlacementOpportunityAdapter);

        arrowBackImageButton.setOnClickListener(view -> finish());

        editPlacementOpportunityAdapter.startListening();
    }
}