package com.example.tpo_training_and_placement.activities.placementopportunity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.data.EditPlacementData;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EditPlacementOpportunityActivity extends AppCompatActivity {
    public EditText roleEditText, locationEditText, summaryEditText, keyQualificationEditText;
    public EditText jobDescriptionEditText, additionalRequirementsEditText, linkForApplyingEditText;
    public TextView companyNameTextView;
    public String companyNameString, roleString, locationString, summaryString, keyQualificationString, jobDescriptionString,
    additionalRequirementString, linkForApplyingString;
    public Button updateButton, deleteButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_placement_opportunity);
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
        Objects.requireNonNull(getSupportActionBar()).hide();


        companyNameString = getIntent().getExtras().get("CompanyName").toString();
        roleString = getIntent().getExtras().get("Role").toString();
        locationString = getIntent().getExtras().get("Location").toString();
        summaryString = getIntent().getExtras().get("Summary").toString();
        keyQualificationString = getIntent().getExtras().get("KeyQualification").toString();
        jobDescriptionString = getIntent().getExtras().get("JobDescription").toString();
        additionalRequirementString = getIntent().getExtras().get("AdditionalRequirements").toString();
        linkForApplyingString = getIntent().getExtras().get("LinkForApplying").toString();

       companyNameTextView.setText(companyNameString);
        roleEditText.setText(roleString);
        locationEditText.setText(locationString);
        summaryEditText.setText(summaryString);
        keyQualificationEditText.setText(keyQualificationString);
        jobDescriptionEditText.setText(jobDescriptionString);
        additionalRequirementsEditText.setText(additionalRequirementString);
        linkForApplyingEditText.setText(linkForApplyingString);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reference = FirebaseDatabase.getInstance().getReference("Placement Opportunity");
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
                            .child(companyNameString).updateChildren(data)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(EditPlacementOpportunityActivity.this, "Success", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(EditPlacementOpportunityActivity.this, EditPlacementData.class));
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(EditPlacementOpportunityActivity.this, "fail", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                Toast.makeText(EditPlacementOpportunityActivity.this, "Fill All The Details", Toast.LENGTH_SHORT).show();
            }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference("Placement Opportunity")
                        .child(companyNameString).removeValue()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(EditPlacementOpportunityActivity.this, "Success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(EditPlacementOpportunityActivity.this, EditPlacementData.class));
                                finish();
                            }
                        }) .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(EditPlacementOpportunityActivity.this, "fail", Toast.LENGTH_SHORT).show();
                    }
                });


            }

        });



    }
}