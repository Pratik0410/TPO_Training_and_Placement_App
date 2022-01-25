package com.example.tpo_training_and_placement.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.companyactivity.RegisterCompanyActivity;
import com.example.tpo_training_and_placement.adapters.RegisteredCompanyAdapter;
import com.example.tpo_training_and_placement.models.PrePlacementModel;
import com.example.tpo_training_and_placement.models.RegisteredCompanyModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class CompaniesUi extends AppCompatActivity {

    public CardView companiesUiCardView;
    public ImageButton registerCompanyImageButton;
    public RecyclerView registeredcompanyRecyclerView;
    public RegisteredCompanyAdapter registeredCompanyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_companies);

        getSupportActionBar().hide();

        companiesUiCardView = findViewById(R.id.id_ui_pre_placement);
        registerCompanyImageButton = findViewById(R.id.id_register_company);
        registeredcompanyRecyclerView = findViewById(R.id.id_list_of_companies_recycler_view);

        registeredcompanyRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<RegisteredCompanyModel> options =
                new FirebaseRecyclerOptions.Builder<RegisteredCompanyModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("List of Companies"), RegisteredCompanyModel.class)
                        .build();

        registeredCompanyAdapter = new RegisteredCompanyAdapter(options);
        registeredcompanyRecyclerView.setAdapter(registeredCompanyAdapter);



        companiesUiCardView.setBackgroundResource(R.drawable.top_card_radius);

        registerCompanyImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CompaniesUi.this, RegisterCompanyActivity.class));
                finish();
            }
        });


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
}