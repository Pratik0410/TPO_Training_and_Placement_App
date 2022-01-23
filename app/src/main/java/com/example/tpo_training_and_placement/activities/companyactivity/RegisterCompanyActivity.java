package com.example.tpo_training_and_placement.activities.companyactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.ui.CompaniesUi;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterCompanyActivity extends AppCompatActivity {

    public Button registerButton;
    public String[] productServiceArray = {"Product Based","Service Based","Both(Product & Service)"};
    public TextInputEditText companyNameTextInputEditText, productServiceTextInputEditText, aboutTextInputEditText, contactDetailsTextInputEditText;
    public TextInputLayout textInputLayout;
    public AutoCompleteTextView typeOfCompanyAutoCompleteTextView;

    @Override
    protected void onResume() {
        super.onResume();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(RegisterCompanyActivity.this,R.layout.dropdownlist_item,productServiceArray);
        typeOfCompanyAutoCompleteTextView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_company);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(RegisterCompanyActivity.this,R.layout.dropdownlist_item,productServiceArray);

        getSupportActionBar().hide();
        registerButton = findViewById(R.id.id_register_company_button);
        companyNameTextInputEditText = findViewById(R.id.id_company_name_edit_text_in_register_company);
        productServiceTextInputEditText = findViewById(R.id.id_product_service_edit_text);
        aboutTextInputEditText = findViewById(R.id.id_about_edit_text_in_register_company);
        contactDetailsTextInputEditText = findViewById(R.id.id_contact_details_edit_text_in_register_company);
        textInputLayout = findViewById(R.id.id_text_input_layout);
        typeOfCompanyAutoCompleteTextView = findViewById(R.id.id_auto_complete_textview);

        typeOfCompanyAutoCompleteTextView.setAdapter(arrayAdapter);

        registerButton.setOnClickListener(view -> {

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("List of Companies");

            Map map = new HashMap();
            map.put("Company Name",companyNameTextInputEditText.getText().toString());
            map.put("Type of Company",typeOfCompanyAutoCompleteTextView.getText().toString());
            map.put("Product or Service of Company",productServiceTextInputEditText.getText().toString());
            map.put("About Company",aboutTextInputEditText.getText().toString());
            map.put("Contact Details",contactDetailsTextInputEditText.getText().toString());
            databaseReference.child(companyNameTextInputEditText.getText().toString()).setValue(map);

            startActivity(new Intent(RegisterCompanyActivity.this, CompaniesUi.class));
            finish();
        });


    }
}