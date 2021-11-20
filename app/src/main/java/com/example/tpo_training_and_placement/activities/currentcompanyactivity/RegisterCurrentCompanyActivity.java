package com.example.tpo_training_and_placement.activities.currentcompanyactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.ui.CurrentCompaniesUi;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterCurrentCompanyActivity extends AppCompatActivity {

    public TextView companyNameTextView;
    public TextView companyDescriptionTextView;
    public Button registerCurrentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_current_company);

        getSupportActionBar().hide();

        companyNameTextView = findViewById(R.id.id_company_name);
        companyDescriptionTextView = findViewById(R.id.id_company_description);
        registerCurrentButton = findViewById(R.id.id_register_current_company_button);

        registerCurrentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference notifyall = database.getReference("List of Companies");

                Map data = new HashMap();
                data.put("Company Name", companyNameTextView.getText().toString());
                data.put("Company Description", companyDescriptionTextView.getText().toString());
                notifyall.child(companyNameTextView.getText().toString()).setValue(data);

                startActivity(new Intent(RegisterCurrentCompanyActivity.this, CurrentCompaniesUi.class));
                finish();
            }
        });

    }
}