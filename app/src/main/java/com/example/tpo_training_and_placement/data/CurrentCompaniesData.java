package com.example.tpo_training_and_placement.data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;

import com.example.tpo_training_and_placement.R;

public class CurrentCompaniesData extends AppCompatActivity {

    public CardView currentCompanyUiCardView;
    public EditText companyDescriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_current_companies);

        getSupportActionBar().hide();

        currentCompanyUiCardView = findViewById(R.id.id_current_company_ui);
        companyDescriptionEditText = findViewById(R.id.id_current_company_description);

        currentCompanyUiCardView.setBackgroundResource(R.drawable.bottom_card_radius);

        companyDescriptionEditText.setOnClickListener(view ->
                companyDescriptionEditText.setTextColor(Color.BLACK)
        );

    }
}