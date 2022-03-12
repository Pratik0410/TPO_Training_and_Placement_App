package com.example.tpo_training_and_placement.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.trainingactivity.AddTrainingDetailsActivity;
import com.example.tpo_training_and_placement.data.EditTrainingDetailsData;

import java.util.Objects;

public class TrainingUi extends AppCompatActivity {

    public CardView trainingUiCardView;
    public CardView addTrainingDetailsCardView;
    public CardView editTrainingDetailsCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_training);

        Objects.requireNonNull(getSupportActionBar()).hide();

        trainingUiCardView = findViewById(R.id.id_ui_training_cardview_in_ui_training);
        addTrainingDetailsCardView = findViewById(R.id.id_add_training_details_cardview_in_ui_training);
        editTrainingDetailsCardView = findViewById(R.id.id_edit_training_details_cardview_in_ui_training);

        trainingUiCardView.setBackgroundResource(R.drawable.top_card_radius);

        addTrainingDetailsCardView.setOnClickListener(view -> startActivity(new Intent(TrainingUi.this, AddTrainingDetailsActivity.class)));
        editTrainingDetailsCardView.setOnClickListener(view -> startActivity(new Intent(TrainingUi.this, EditTrainingDetailsData.class)));

    }
}