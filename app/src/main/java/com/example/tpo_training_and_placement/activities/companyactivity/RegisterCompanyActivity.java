package com.example.tpo_training_and_placement.activities.companyactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.ui.CompaniesUi;

public class RegisterCompanyActivity extends AppCompatActivity {

    public Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_company);

        getSupportActionBar().hide();
        registerButton = findViewById(R.id.id_register_company_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterCompanyActivity.this, CompaniesUi.class));
                finish();
            }
        });

    }
}