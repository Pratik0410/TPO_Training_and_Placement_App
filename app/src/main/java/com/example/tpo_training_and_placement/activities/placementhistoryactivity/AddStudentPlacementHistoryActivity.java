package com.example.tpo_training_and_placement.activities.placementhistoryactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.errorhandling.WrapContentLinearLayoutManager;
import com.example.tpo_training_and_placement.adapters.AddPlacementHistoryDataAdapter;
import com.example.tpo_training_and_placement.models.AddPlacementHistoryDataModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class AddStudentPlacementHistoryActivity extends AppCompatActivity {

    public ImageButton arrowBackImageButton;
    public RecyclerView addPlacementHistoryRecyclerView;
    public AddPlacementHistoryDataAdapter addPlacementHistoryDataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_placement_history);

        Objects.requireNonNull(getSupportActionBar()).hide();
        addPlacementHistoryRecyclerView = findViewById(R.id.id_add_student_recycler_view_in_placement_history);
        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_activity_add_placement_history_data);
        arrowBackImageButton.setOnClickListener(view -> finish());

        addPlacementHistoryRecyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this));

        FirebaseRecyclerOptions<AddPlacementHistoryDataModel> options =
                new FirebaseRecyclerOptions.Builder<AddPlacementHistoryDataModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Students"), AddPlacementHistoryDataModel.class)
                        .build();

        addPlacementHistoryDataAdapter = new AddPlacementHistoryDataAdapter(options);
        addPlacementHistoryRecyclerView.setAdapter(addPlacementHistoryDataAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        addPlacementHistoryDataAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        addPlacementHistoryDataAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseRecyclerOptions<AddPlacementHistoryDataModel> options =
                new FirebaseRecyclerOptions.Builder<AddPlacementHistoryDataModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Students"), AddPlacementHistoryDataModel.class)
                        .build();

        addPlacementHistoryDataAdapter = new AddPlacementHistoryDataAdapter(options);
        addPlacementHistoryRecyclerView.setAdapter(addPlacementHistoryDataAdapter);

        arrowBackImageButton.setOnClickListener(view -> finish());

        addPlacementHistoryDataAdapter.startListening();
    }
}