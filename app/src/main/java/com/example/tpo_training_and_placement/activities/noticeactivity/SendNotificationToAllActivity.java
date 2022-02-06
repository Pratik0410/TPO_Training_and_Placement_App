package com.example.tpo_training_and_placement.activities.noticeactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tpo_training_and_placement.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SendNotificationToAllActivity extends AppCompatActivity {

    public EditText dateEditText;
    public EditText enterNoticeEditText;
    public ImageButton arrowBackImageButton;
    public Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notification_to_all);

        Objects.requireNonNull(getSupportActionBar()).hide();

        dateEditText = findViewById(R.id.id_date_edit_text_in_activity_send_notification_to_all);
        enterNoticeEditText = findViewById(R.id.id_notice_edit_text_in_activity_send_notification_to_all);
        sendButton = findViewById(R.id.id_send_button_in_activity_send_notification_to_all);
        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_activity_send_notification_to_all);

        arrowBackImageButton.setOnClickListener(view -> finish());

        MaterialDatePicker.Builder<Long> materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTitleText("Select Today's Date");
        final MaterialDatePicker<Long> materialDatePicker = materialDateBuilder.build();

        dateEditText.setOnClickListener(view -> materialDatePicker.show(getSupportFragmentManager(),"MATERIAL_DATE_PICKER"));

        materialDatePicker.addOnPositiveButtonClickListener(selection -> dateEditText.setText(materialDatePicker.getHeaderText()));

        sendButton.setOnClickListener(view -> {

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Notice");

            if(dateEditText.getText().toString().length() > 0 && enterNoticeEditText.getText().toString().length() > 0){

                Map<String,String> data = new HashMap();
                data.put("Date", dateEditText.getText().toString());
                data.put("Notice", enterNoticeEditText.getText().toString());
                databaseReference.child(dateEditText.getText().toString()).setValue(data);

                finish();
            }
            else{
                Toast.makeText(SendNotificationToAllActivity.this, "Please Fill All Details", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}