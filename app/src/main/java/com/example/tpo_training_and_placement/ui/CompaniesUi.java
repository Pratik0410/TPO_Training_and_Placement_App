package com.example.tpo_training_and_placement.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.companyactivity.RegisterCompanyActivity;
import com.example.tpo_training_and_placement.data.EditCompanyData;

import java.util.Objects;

public class CompaniesUi extends AppCompatActivity {

    public CardView companiesUiCardView, editExistingCompanyCarView, addCompanyCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_companies);

        Objects.requireNonNull(getSupportActionBar()).hide();

        companiesUiCardView = findViewById(R.id.id_ui_pre_placement);
        editExistingCompanyCarView = findViewById(R.id.id_edit_existing_company_card_in_ui_companies);
        addCompanyCardView = findViewById(R.id.id_add_company_card_in_ui_companies);

        editExistingCompanyCarView.setOnClickListener(view -> startActivity(new Intent(CompaniesUi.this, EditCompanyData.class)));

        addCompanyCardView.setOnClickListener(view -> startActivity(new Intent(CompaniesUi.this, RegisterCompanyActivity.class)));

        companiesUiCardView.setBackgroundResource(R.drawable.top_card_radius);

    }
}