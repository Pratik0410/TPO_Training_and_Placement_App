package com.example.tpo_training_and_placement.activities.currentcompanyactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.ui.CurrentCompaniesUi;

public class RegisterCurrentCompanyActivity extends AppCompatActivity {

    public Button registerCurrentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_current_company);

        getSupportActionBar().hide();

        registerCurrentButton = findViewById(R.id.id_register_current_company_button);

        registerCurrentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterCurrentCompanyActivity.this, CurrentCompaniesUi.class));
            }
        });

    }
}