package com.example.tpo_training_and_placement.activities.placementopportunity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.ui.PlacementOpportunityUi;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AddPlacementOpportunityActivity extends AppCompatActivity {

    public String companyName;
    public MaterialTextView companyNameMaterialTextView;
    public ImageButton arrowBackImageButton;
    public EditText roleTextInputLayout,locationTextInputLayout, summaryTextInputLayout, keyQualificationTextInputlayout,
           jobDescriptionTextInputLayout, additionalRequirementsTextInputLayout, linkForApplyingTextInputLayout;
    public Button uploadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_placement_opportunity);

        Objects.requireNonNull(getSupportActionBar()).hide();

        companyNameMaterialTextView = findViewById(R.id.id_company_name_edit_text_in_activity_add_placement_opportunity);
        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_activity_add_placement_opportunity);
        roleTextInputLayout = findViewById(R.id.id_role_edit_text_in_activity_edit_placement_opportunity);
        locationTextInputLayout = findViewById(R.id.id_location_edit_text_in_activity_add_placement_opportunity);
        summaryTextInputLayout = findViewById(R.id.id_summary_edit_text_in_activity_add_placement_opportunity);
        keyQualificationTextInputlayout = findViewById(R.id.id_key_qualification_edit_text_in_activity_add_placement_opportunity);
        jobDescriptionTextInputLayout = findViewById(R.id.id_job_description_edit_text_in_activity_add_placement_opportunity);
        additionalRequirementsTextInputLayout = findViewById(R.id.id_additional_requirements_edit_text_in_activity_add_placement_opportunity);
        linkForApplyingTextInputLayout = findViewById(R.id.id_link_for_applying_edit_text_in_activity_add_placement_opportunity);
        uploadButton = findViewById(R.id.id_upload_button_in_activity_add_placement_opportunity);

        companyName = getIntent().getExtras().get("Company Name").toString();

        companyNameMaterialTextView.setText(companyName);

        arrowBackImageButton.setOnClickListener(view -> finish());

        uploadButton.setOnClickListener(view -> {
            if(companyNameMaterialTextView.getText().toString().length() != 0 && roleTextInputLayout.getText().toString().length() != 0 && locationTextInputLayout.getText().toString().length() != 0
                    && summaryTextInputLayout.getText().toString().length() != 0 && keyQualificationTextInputlayout.getText().toString().length() != 0 && jobDescriptionTextInputLayout.getText().toString().length() != 0
                    && additionalRequirementsTextInputLayout.getText().toString().length() != 0 && linkForApplyingTextInputLayout.getText().toString().length() != 0)
            {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference placementOpportunity = database.getReference("Placement Opportunity");

                Map<String, String> data = new HashMap();
                data.put("CompanyName", companyNameMaterialTextView.getText().toString());
                data.put("Role", roleTextInputLayout.getText().toString());
                data.put("Location", locationTextInputLayout.getText().toString());
                data.put("Summary", summaryTextInputLayout.getText().toString());
                data.put("KeyQualification", keyQualificationTextInputlayout.getText().toString());
                data.put("JobDescription", jobDescriptionTextInputLayout.getText().toString());
                data.put("AdditionalRequirements", additionalRequirementsTextInputLayout.getText().toString());
                data.put("LinkForApplying", linkForApplyingTextInputLayout.getText().toString());
                placementOpportunity.child(companyNameMaterialTextView.getText().toString()).setValue(data);

                startActivity(new Intent(AddPlacementOpportunityActivity.this, PlacementOpportunityUi.class));
                finish();
            }else{
                Toast.makeText(AddPlacementOpportunityActivity.this, "Fill All The Details", Toast.LENGTH_SHORT).show();
            }
        });
    }
}