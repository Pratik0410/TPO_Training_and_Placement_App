package com.example.tpo_training_and_placement.activities.placementopportunity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.tpo_training_and_placement.R;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EditPlacementOpportunityActivity extends AppCompatActivity {

    public EditText roleEditText, locationEditText, summaryEditText, keyQualificationEditText;
    public EditText jobDescriptionEditText, additionalRequirementsEditText, linkForApplyingEditText;
    public TextView companyNameTextView;
    public String companyName, role, location, summary, keyQualification, jobDescription, additionalRequirements, linkForApplying;
    public Button updateButton, deleteButton;
    public ImageButton arrowBackImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_placement_opportunity);

        Objects.requireNonNull(getSupportActionBar()).hide();

        companyNameTextView = findViewById(R.id.id_company_name_text_view_in_activity_edit_placement_opportunity);
        roleEditText = findViewById(R.id.id_role_edit_text_in_activity_edit_placement_opportunity);
        locationEditText = findViewById(R.id.id_location_edit_text_in_activity_edit_placement_opportunity);
        summaryEditText = findViewById(R.id.id_summary_edit_text_in_activity_edit_placement_opportunity);
        keyQualificationEditText = findViewById(R.id.id_key_qualification_edit_text_in_activity_edit_placement_opportunity);
        jobDescriptionEditText = findViewById(R.id.id_job_description_edit_text_in_activity_edit_placement_opportunity);
        additionalRequirementsEditText = findViewById(R.id.id_additional_requirements_edit_text_in_activity_edit_placement_opportunity);
        linkForApplyingEditText = findViewById(R.id.id_link_for_applying_edit_text_in_activity_edit_placement_opportunity);
        updateButton = findViewById(R.id.id_update_placement_button_in_activity_edit_placement_opportunity);
        deleteButton = findViewById(R.id.id_delete_placement_button_in_activity_edit_placement_opportunity);
        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_activity_edit_placement_opportunity);

        companyName = getIntent().getExtras().get("CompanyName").toString();
        role = getIntent().getExtras().get("Role").toString();
        location = getIntent().getExtras().get("Location").toString();
        summary = getIntent().getExtras().get("Summary").toString();
        keyQualification = getIntent().getExtras().get("KeyQualification").toString();
        jobDescription = getIntent().getExtras().get("JobDescription").toString();
        additionalRequirements = getIntent().getExtras().get("AdditionalRequirements").toString();
        linkForApplying = getIntent().getExtras().get("LinkForApplying").toString();

        companyNameTextView.setText(companyName);
        roleEditText.setText(role);
        locationEditText.setText(location);
        summaryEditText.setText(summary);
        keyQualificationEditText.setText(keyQualification);
        jobDescriptionEditText.setText(jobDescription);
        additionalRequirementsEditText.setText(additionalRequirements);
        linkForApplyingEditText.setText(linkForApplying);

        arrowBackImageButton.setOnClickListener(view -> finish());

        updateButton.setOnClickListener(view -> {
        if(companyNameTextView.getText().toString().length() != 0 && roleEditText.getText().toString().length() != 0 && locationEditText.getText().toString().length() != 0
           && summaryEditText.getText().toString().length() != 0 && keyQualificationEditText.getText().toString().length() != 0 && jobDescriptionEditText.getText().toString().length() != 0
           && additionalRequirementsEditText.getText().toString().length() != 0 && linkForApplyingEditText.getText().toString().length() != 0)
            {
                Map<String, Object> data = new HashMap<>();
                data.put("CompanyName", companyNameTextView.getText().toString());
                data.put("Role", roleEditText.getText().toString());
                data.put("Location", locationEditText.getText().toString());
                data.put("Summary", summaryEditText.getText().toString());
                data.put("KeyQualification", keyQualificationEditText.getText().toString());
                data.put("JobDescription", jobDescriptionEditText.getText().toString());
                data.put("AdditionalRequirements", additionalRequirementsEditText.getText().toString());
                data.put("LinkForApplying", linkForApplyingEditText.getText().toString());

                FirebaseDatabase.getInstance().getReference("Placement Opportunity")
                        .child(companyName).updateChildren(data)
                        .addOnSuccessListener(unused -> {
                            Toast.makeText(EditPlacementOpportunityActivity.this, "Updated Successfully", Toast.LENGTH_LONG).show();
                            finish();
                        }).addOnFailureListener(e -> Toast.makeText(EditPlacementOpportunityActivity.this, "Failed to Update", Toast.LENGTH_SHORT).show());
            } else {
            Toast.makeText(EditPlacementOpportunityActivity.this, "Fill All The Details", Toast.LENGTH_SHORT).show();
        }
        });

        deleteButton.setOnClickListener(view -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EditPlacementOpportunityActivity.this);
            alertDialogBuilder.setTitle("Delete").setMessage("Are you Sure?");
            alertDialogBuilder.setPositiveButton("Yes", (dialogInterface, i) -> FirebaseDatabase.getInstance().getReference("Placement Opportunity")
                    .child(companyName).removeValue()
                    .addOnSuccessListener(unused -> {
                        Toast.makeText(EditPlacementOpportunityActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }));
            alertDialogBuilder.setNegativeButton("No", (dialogInterface, i) -> FirebaseDatabase.getInstance().getReference("Placement Opportunity")
                    .child(companyName).removeValue()
                    .addOnFailureListener(e -> Toast.makeText(EditPlacementOpportunityActivity.this, "Failed to Delete", Toast.LENGTH_SHORT).show()));

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}