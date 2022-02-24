package com.example.tpo_training_and_placement.activities.trainingactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class AddTrainingDetailsActivity extends AppCompatActivity {

    public ImageButton arrowBackImageButton;
    public TextInputEditText nameOfCompanyOrOrganizationTextInputEditText, aboutCompanyTextInputEditText,
            contentsOfTrainingTextInputEditText, eligibilityCriteriaTextInputEditText, trainingDurationTextInputEditText,
            trainingChargesTextInputEditText, registrationDateTextInputEditText, lastDateOfRegistrationTextInputEditText,
            contactDetailsTextInputEditText;
    public TextInputLayout registrationDateTextInputLayout, lastDateOfRegistrationTextInputLayout;
    public Button uploadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_training_details);

        Objects.requireNonNull(getSupportActionBar()).hide();

        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_activity_add_training_details);
        nameOfCompanyOrOrganizationTextInputEditText = findViewById(R.id.id_name_of_company_or_organization_edit_text_in_activity_add_training_details);
        aboutCompanyTextInputEditText = findViewById(R.id.id_about_the_company_or_organization_edit_text_in_activity_add_training_details);
        contentsOfTrainingTextInputEditText = findViewById(R.id.id_content_of_training_edit_text_in_activity_add_training_details);
        eligibilityCriteriaTextInputEditText = findViewById(R.id.id_eligibility_criteria_edit_text_in_activity_add_training_details);
        trainingDurationTextInputEditText = findViewById(R.id.id_training_duration_edit_text_in_activity_add_training_details);
        trainingChargesTextInputEditText = findViewById(R.id.id_training_charges_edit_text_in_activity_add_training_details);
        registrationDateTextInputEditText = findViewById(R.id.id_registration_date_edit_text_in_activity_add_training_details);nameOfCompanyOrOrganizationTextInputEditText = findViewById(R.id.id_name_of_company_or_organization_edit_text_in_activity_add_training_details);nameOfCompanyOrOrganizationTextInputEditText = findViewById(R.id.id_name_of_company_or_organization_edit_text_in_activity_add_training_details);
        lastDateOfRegistrationTextInputEditText = findViewById(R.id.id_last_date_of_registration_edit_text_in_activity_add_training_details);
        contactDetailsTextInputEditText = findViewById(R.id.id_contact_details_edit_text_in_activity_add_training_details);
        uploadButton = findViewById(R.id.id_upload_button_in_activity_add_training_details);

        arrowBackImageButton.setOnClickListener(view -> finish());

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

        uploadButton.setOnClickListener(view -> {

        });

    }
}