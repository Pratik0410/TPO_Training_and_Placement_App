package com.example.tpo_training_and_placement.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.currentcompanyactivity.RegisterCurrentCompanyActivity;

public class CurrentCompaniesUi extends AppCompatActivity {

    public CardView currentCompaniesUiCardView;
    public ImageButton registerCurrentCompanyImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_current_companies);

        getSupportActionBar().hide();

        currentCompaniesUiCardView = findViewById(R.id.id_ui_current_companies);
        registerCurrentCompanyImageButton = findViewById(R.id.id_register_current_company);

        currentCompaniesUiCardView.setBackgroundResource(R.drawable.top_card_radius);

        registerCurrentCompanyImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CurrentCompaniesUi.this, RegisterCurrentCompanyActivity.class));
            }
        });

    }
}