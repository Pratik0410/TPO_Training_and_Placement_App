package com.example.tpo_training_and_placement.activities.requestactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.adapters.StudentRequestAdapter;
import com.example.tpo_training_and_placement.models.StudentRequestModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class StudentRequestActivity extends AppCompatActivity {

    public CardView requestUiCardView;
    RecyclerView requestRecyclerView;
    StudentRequestAdapter studentRequestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_student_request);

        getSupportActionBar().hide();

        requestUiCardView = findViewById(R.id.id_ui_student_request);
        requestUiCardView.setBackgroundResource(R.drawable.top_card_radius);

        FirebaseRecyclerOptions<StudentRequestModel> options =
                new FirebaseRecyclerOptions.Builder<StudentRequestModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference(), StudentRequestModel.class)
                        .build();

        requestRecyclerView = findViewById(R.id.id_student_request_recycler_view);
        requestRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentRequestAdapter = new StudentRequestAdapter(options);
        requestRecyclerView.setAdapter(studentRequestAdapter);

    }
}
