package com.example.tpo_training_and_placement.activities.trainingactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tpo_training_and_placement.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;

public class EditTrainingDetailsActivity extends AppCompatActivity {

    public TextInputEditText registrationDateTextInputEditText, lastDateOfRegistrationTextInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_training_details);

        registrationDateTextInputEditText = findViewById(R.id.id_registration_date_edit_text_in_activity_edit_training_details);
        lastDateOfRegistrationTextInputEditText = findViewById(R.id.id_last_date_of_registration_edit_text_in_activity_edit_training_details);

        MaterialDatePicker.Builder<Long> materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTitleText("Select Registration Date");
        final MaterialDatePicker<Long> materialDatePicker = materialDateBuilder.build();

        registrationDateTextInputEditText.setOnClickListener(view -> materialDatePicker.show(getSupportFragmentManager(),"MATERIAL_DATE_PICKER"));

        materialDatePicker.addOnPositiveButtonClickListener(selection -> registrationDateTextInputEditText.setText(materialDatePicker.getHeaderText()));

        MaterialDatePicker.Builder<Long> lastDateOfRegistrationMaterialDateBuilder = MaterialDatePicker.Builder.datePicker();
        lastDateOfRegistrationMaterialDateBuilder.setTitleText("Select Last Date of Registration");
        final MaterialDatePicker<Long> lastDateOfRegistrationMaterialDatePicker = lastDateOfRegistrationMaterialDateBuilder.build();

        lastDateOfRegistrationTextInputEditText.setOnClickListener(view -> lastDateOfRegistrationMaterialDatePicker.show(getSupportFragmentManager(),"MATERIAL_DATE_PICKER"));

        lastDateOfRegistrationMaterialDatePicker.addOnPositiveButtonClickListener(selection -> lastDateOfRegistrationTextInputEditText.setText(lastDateOfRegistrationMaterialDatePicker.getHeaderText()));

    }
}