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

import java.util.Objects;

public class StudentRequestActivity extends AppCompatActivity {

    public CardView requestUiCardView;
    RecyclerView requestRecyclerView;
    StudentRequestAdapter studentRequestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_student_request);

        Objects.requireNonNull(getSupportActionBar()).hide();

        requestUiCardView = findViewById(R.id.id_ui_student_request);
        requestUiCardView.setBackgroundResource(R.drawable.top_card_radius);

        FirebaseRecyclerOptions<StudentRequestModel> options =
                new FirebaseRecyclerOptions.Builder<StudentRequestModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Student Request"), StudentRequestModel.class)
                        .build();

        requestRecyclerView = findViewById(R.id.id_student_request_recycler_view);
        requestRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentRequestAdapter = new StudentRequestAdapter(options);
        requestRecyclerView.setAdapter(studentRequestAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        studentRequestAdapter.startListening();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        studentRequestAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseRecyclerOptions<StudentRequestModel> options =
                new FirebaseRecyclerOptions.Builder<StudentRequestModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Student Request"), StudentRequestModel.class)
                        .build();

        requestRecyclerView = findViewById(R.id.id_student_request_recycler_view);
        requestRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentRequestAdapter = new StudentRequestAdapter(options);
        requestRecyclerView.setAdapter(studentRequestAdapter);

        studentRequestAdapter.startListening();
    }
}
