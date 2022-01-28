package com.example.tpo_training_and_placement.activities.preplacementactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.ui.PrePlacementUi;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class AddPrePlacementTalkActivity extends AppCompatActivity {

    public TextInputEditText companyNameTextInputEditText;
    public TextInputEditText detailsTextInputEditText;
    public TextInputEditText linkTextInputEditText;
    public Button submitButton;
    public ImageButton arrowBackImageButton;
    public String dateString;
    public Calendar calendar;
    public SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pre_placement_talk);

        Objects.requireNonNull(getSupportActionBar()).hide();

        companyNameTextInputEditText = findViewById(R.id.id_company_name_edit_text_in_pre_placement);
        detailsTextInputEditText = findViewById(R.id.id_details_edit_text_in_pre_placement);
        linkTextInputEditText = findViewById(R.id.id_link_edit_text_in_pre_placement);
        submitButton = findViewById(R.id.id_submit_button_in_pre_placement);
        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_activity_add_pre_placement_talk);

        submitButton.setOnClickListener(view -> {
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Pre Placement Talks");

            calendar = Calendar.getInstance();
            String dateFormat = "dd-MM-yyyy";
            simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.US);
            dateString = simpleDateFormat.format(calendar.getTime());

            if(companyNameTextInputEditText.getText().toString().length()!=0 && detailsTextInputEditText.getText().toString().length()!=0&&linkTextInputEditText.getText().toString().length()!=0){

                Map map = new HashMap();
                map.put("CompanyName",companyNameTextInputEditText.getText().toString());
                map.put("Details",detailsTextInputEditText.getText().toString());
                map.put("Link",linkTextInputEditText.getText().toString());
                databaseReference.child(dateString).setValue(map);

                startActivity(new Intent(AddPrePlacementTalkActivity.this, PrePlacementUi.class));
                finish();
            }
            else {
                Toast.makeText(AddPrePlacementTalkActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
            }
        });

        arrowBackImageButton.setOnClickListener(view -> finish());

    }
}