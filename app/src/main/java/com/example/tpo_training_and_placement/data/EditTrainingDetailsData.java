package com.example.tpo_training_and_placement.data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.errorhandling.WrapContentLinearLayoutManager;
import com.example.tpo_training_and_placement.adapters.EditTrainingDetailsAdapter;
import com.example.tpo_training_and_placement.models.EditTrainingDetailsModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class EditTrainingDetailsData extends AppCompatActivity {

    public ImageButton arrowImageButton;
    public RecyclerView  editTrainingDetailsRecyclerView;
    public EditTrainingDetailsAdapter editTrainingDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_edit_training_details);

        Objects.requireNonNull(getSupportActionBar()).hide();

        arrowImageButton = findViewById(R.id.id_arrow_back_image_button_in_data_edit_placement_history);
        editTrainingDetailsRecyclerView = findViewById(R.id.id_edit_training_details_recycler_view_in_data_edit_training_details);

        arrowImageButton.setOnClickListener(view ->  finish() );

        editTrainingDetailsRecyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this));

        FirebaseRecyclerOptions<EditTrainingDetailsModel> options =
                new FirebaseRecyclerOptions.Builder<EditTrainingDetailsModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Training Activity"), EditTrainingDetailsModel.class)
                .build();

        editTrainingDetailsAdapter = new EditTrainingDetailsAdapter(options);
        editTrainingDetailsRecyclerView.setAdapter(editTrainingDetailsAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        editTrainingDetailsAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        editTrainingDetailsAdapter.stopListening();
    }


}