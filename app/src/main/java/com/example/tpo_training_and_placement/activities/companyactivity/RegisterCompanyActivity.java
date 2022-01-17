package com.example.tpo_training_and_placement.activities.companyactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.ui.CompaniesUi;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterCompanyActivity extends AppCompatActivity {

    public Button registerButton;
    public String[] productServiceArray = {"Product Based","Service Based","Both(Product & Service)"};
    public EditText productServiceEditText;
    public TextInputLayout textInputLayout;
    public AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onResume() {
        super.onResume();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(RegisterCompanyActivity.this,R.layout.dropdownlist_item,productServiceArray);
        autoCompleteTextView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_company);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(RegisterCompanyActivity.this,R.layout.dropdownlist_item,productServiceArray);

        getSupportActionBar().hide();
        registerButton = findViewById(R.id.id_register_company_button);
        productServiceEditText = findViewById(R.id.id_product_service_edit_text);
        textInputLayout = findViewById(R.id.id_text_input_layout);
        autoCompleteTextView = findViewById(R.id.id_auto_complete_textview);

        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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