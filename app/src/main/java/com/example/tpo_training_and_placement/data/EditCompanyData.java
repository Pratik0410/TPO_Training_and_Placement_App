package com.example.tpo_training_and_placement.data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.adapters.RegisteredCompanyAdapter;
import com.example.tpo_training_and_placement.models.RegisteredCompanyModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class EditCompanyData extends AppCompatActivity {

    public ImageButton arrowBackImageButton;
    public RecyclerView registeredCompanyRecyclerView;
    public RegisteredCompanyAdapter registeredCompanyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_edit_company);

        Objects.requireNonNull(getSupportActionBar()).hide();

        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_data_edit_company);
        registeredCompanyRecyclerView = findViewById(R.id.id_select_company_recycler_view_in_data_edit_company);

        registeredCompanyRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<RegisteredCompanyModel> options =
                new FirebaseRecyclerOptions.Builder<RegisteredCompanyModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("List of Companies"), RegisteredCompanyModel.class)
                        .build();

        registeredCompanyAdapter = new RegisteredCompanyAdapter(options);
        registeredCompanyRecyclerView.setAdapter(registeredCompanyAdapter);

        arrowBackImageButton.setOnClickListener(view -> finish());

    }

    @Override
    protected void onStart() {
        super.onStart();
        registeredCompanyAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        registeredCompanyAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();

        FirebaseRecyclerOptions<RegisteredCompanyModel> options =
                new FirebaseRecyclerOptions.Builder<RegisteredCompanyModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("List of Companies"), RegisteredCompanyModel.class)
                        .build();

        registeredCompanyAdapter = new RegisteredCompanyAdapter(options);
        registeredCompanyRecyclerView.setAdapter(registeredCompanyAdapter);

        arrowBackImageButton.setOnClickListener(view -> finish());

        registeredCompanyAdapter.startListening();
    }
}