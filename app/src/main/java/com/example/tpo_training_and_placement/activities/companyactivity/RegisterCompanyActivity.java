package com.example.tpo_training_and_placement.activities.companyactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.ui.CompaniesUi;

public class RegisterCompanyActivity extends AppCompatActivity {

    public Button registerButton;
    public Spinner productServiceSpinner;
    public String[] productServiceArray = {"Type of Company","Product Based","Service Based","Both"};
    public EditText productServiceEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_company);

        ArrayAdapter arrayAdapter = new ArrayAdapter(RegisterCompanyActivity.this,R.layout.support_simple_spinner_dropdown_item,productServiceArray);

        getSupportActionBar().hide();
        registerButton = findViewById(R.id.id_register_company_button);
        productServiceSpinner = findViewById(R.id.product_service_spinner_id);
        productServiceEditText = findViewById(R.id.id_product_service_edit_text);

        productServiceSpinner.setAdapter(arrayAdapter);
        productServiceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(productServiceArray[i] == "Product Based"){
                    productServiceEditText.setHint("Name of Product");
                }
                else if(productServiceArray[i] == "Service Based"){
                    productServiceEditText.setHint("Name of Service Provided");
                }
                else if(productServiceArray[i] == "Type of Company"){
                    productServiceEditText.setHint("Select the Type of Company");
                }
                else if(productServiceArray[i] == "Both"){
                    productServiceEditText.setHint("Name of Product and Service Provided");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterCompanyActivity.this, CompaniesUi.class));
                finish();
            }
        });


    }
}