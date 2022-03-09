package com.example.tpo_training_and_placement.activities.trainingactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.placementopportunity.EditPlacementOpportunityActivity;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class EditTrainingDetailsActivity extends AppCompatActivity {

    public TextInputEditText registrationDateTextInputEditText, lastDateOfRegistrationTextInputEditText, aboutCompanyTextInputEditText,
            contentsOfTrainingTextInputEditText, eligibilityCriteriaTextInputEditText, trainingDurationTextInputEditText,
            trainingChargesTextInputEditText, contactDetailsTextInputEditText;
    public TextView comapanyNameTextView;
    public Button uploadButton;
    public String companyName, aboutComapny, contentsOfTraining, eligibilityCriteria, trainingDuration, trainingCharges, contactDetails,
                  registrationDate, lastDateOfRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_training_details);

        comapanyNameTextView = findViewById(R.id.id_name_of_company_or_organization_text_view_in_activity_edit_training_details);
        aboutCompanyTextInputEditText = findViewById(R.id.id_about_the_company_or_organization_edit_text_in_activity_edit_training_details);
        contentsOfTrainingTextInputEditText = findViewById(R.id.id_content_of_training_edit_text_in_activity_edit_training_details);
        eligibilityCriteriaTextInputEditText = findViewById(R.id.id_eligibility_criteria_edit_text_in_activity_edit_training_details);
        trainingDurationTextInputEditText = findViewById(R.id.id_training_duration_edit_text_in_activity_edit_training_details);
        trainingChargesTextInputEditText = findViewById(R.id.id_training_charges_edit_text_in_activity_edit_training_details);
        contactDetailsTextInputEditText = findViewById(R.id.id_contact_details_edit_text_in_activity_edit_training_details);
        registrationDateTextInputEditText = findViewById(R.id.id_registration_date_edit_text_in_activity_edit_training_details);
        lastDateOfRegistrationTextInputEditText = findViewById(R.id.id_last_date_of_registration_edit_text_in_activity_edit_training_details);
        uploadButton = findViewById(R.id.id_upload_button_in_activity_edit_training_details);


        MaterialDatePicker.Builder<Long> materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTitleText("Select Registration Date");
        final MaterialDatePicker<Long> materialDatePicker = materialDateBuilder.build();

        registrationDateTextInputEditText.setOnClickListener(view -> materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER"));

        materialDatePicker.addOnPositiveButtonClickListener(selection -> registrationDateTextInputEditText.setText(materialDatePicker.getHeaderText()));

        MaterialDatePicker.Builder<Long> lastDateOfRegistrationMaterialDateBuilder = MaterialDatePicker.Builder.datePicker();
        lastDateOfRegistrationMaterialDateBuilder.setTitleText("Select Last Date of Registration");
        final MaterialDatePicker<Long> lastDateOfRegistrationMaterialDatePicker = lastDateOfRegistrationMaterialDateBuilder.build();

        lastDateOfRegistrationTextInputEditText.setOnClickListener(view -> lastDateOfRegistrationMaterialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER"));

        lastDateOfRegistrationMaterialDatePicker.addOnPositiveButtonClickListener(selection -> lastDateOfRegistrationTextInputEditText.setText(lastDateOfRegistrationMaterialDatePicker.getHeaderText()));

        companyName = getIntent().getExtras().get("CompanyName").toString();
        aboutComapny = getIntent().getExtras().get("AboutCompany").toString();
        contentsOfTraining = getIntent().getExtras().get("ContentOfTraining").toString();
        eligibilityCriteria = getIntent().getExtras().get("EligibilityCriteria").toString();
        trainingDuration = getIntent().getExtras().get("TrainingDuration").toString();
        trainingCharges = getIntent().getExtras().get("TrainingCharges").toString();
        contactDetails = getIntent().getExtras().get("ContactDetails").toString();
        registrationDate = getIntent().getExtras().get("RegistrationDate").toString();
        lastDateOfRegistration = getIntent().getExtras().get("lastDateOfRegistration").toString();

        comapanyNameTextView.setText(companyName);
        aboutCompanyTextInputEditText.setText(aboutComapny);
        contentsOfTrainingTextInputEditText.setText(contentsOfTraining);
        eligibilityCriteriaTextInputEditText.setText(eligibilityCriteria);
        trainingDurationTextInputEditText.setText(trainingDuration);
        trainingChargesTextInputEditText.setText(trainingCharges);
        contactDetailsTextInputEditText.setText(contactDetails);
        registrationDateTextInputEditText.setText(registrationDate);
        lastDateOfRegistrationTextInputEditText.setText(lastDateOfRegistration);

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (comapanyNameTextView.getText().toString().length() != 0 && aboutCompanyTextInputEditText.getText().toString().length() != 0 && contentsOfTrainingTextInputEditText.getText().toString().length() != 0
                        && eligibilityCriteriaTextInputEditText.getText().toString().length() != 0 && trainingDurationTextInputEditText.getText().toString().length() != 0 && trainingChargesTextInputEditText.getText().toString().length() != 0
                        && registrationDateTextInputEditText.getText().toString().length() != 0 && lastDateOfRegistrationTextInputEditText.getText().toString().length() != 0 && contactDetailsTextInputEditText.getText().toString().length() != 0) {
                    Map<String, Object> data = new HashMap<>();
                    data.put("CompanyName", comapanyNameTextView.getText().toString());
                    data.put("AboutCompany", aboutCompanyTextInputEditText.getText().toString());
                    data.put("ContentOfTraining", contentsOfTrainingTextInputEditText.getText().toString());
                    data.put("EligibilityCriteria", eligibilityCriteriaTextInputEditText.getText().toString());
                    data.put("TrainingDuration", trainingDurationTextInputEditText.getText().toString());
                    data.put("TrainingCharges", trainingChargesTextInputEditText.getText().toString());
                    data.put("RegistrationDate", registrationDateTextInputEditText.getText().toString());
                    data.put("lastDateOfRegistration", lastDateOfRegistrationTextInputEditText.getText().toString());
                    data.put("ContactDetails", contactDetailsTextInputEditText.getText().toString());

                    FirebaseDatabase.getInstance().getReference("Training Activity")
                            .child(companyName).updateChildren(data)
                            .addOnSuccessListener(unused -> {
                                Toast.makeText(EditTrainingDetailsActivity.this, "Updated Successfully", Toast.LENGTH_LONG).show();
                                finish();
                            }).addOnFailureListener(e -> Toast.makeText(EditTrainingDetailsActivity.this, "Failed to Update", Toast.LENGTH_SHORT).show());
                } else {
                    Toast.makeText(EditTrainingDetailsActivity.this, "Fill All The Details", Toast.LENGTH_SHORT).show();
                }

            }


        });
    }
}



