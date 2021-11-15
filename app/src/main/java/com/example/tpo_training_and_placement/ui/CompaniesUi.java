package com.example.tpo_training_and_placement.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.companyactivity.RegisterCompanyActivity;

public class CompaniesUi extends AppCompatActivity {

    public CardView companiesUiCardView;
    public ImageButton registerCompanyImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_companies);

        getSupportActionBar().hide();

        companiesUiCardView = findViewById(R.id.id_ui_pre_placement);
        registerCompanyImageButton = findViewById(R.id.id_register_company);

        companiesUiCardView.setBackgroundResource(R.drawable.top_card_radius);

        registerCompanyImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CompaniesUi.this, RegisterCompanyActivity.class));
            }
        });

    }
}