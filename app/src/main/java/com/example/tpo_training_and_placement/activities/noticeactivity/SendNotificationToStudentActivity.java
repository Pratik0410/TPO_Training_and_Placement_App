package com.example.tpo_training_and_placement.activities.noticeactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.fragment.StudentListBottomSheetFragment;
import com.google.android.material.datepicker.MaterialDatePicker;
import java.util.Objects;

public class SendNotificationToStudentActivity extends AppCompatActivity {

    public EditText studentDateEditText;
    public EditText studentNoticeEditText;
    public Button studentSendNoticeButton;
    public ImageButton arrowBackImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_student_notification);

        Objects.requireNonNull(getSupportActionBar()).hide();

        studentDateEditText = findViewById(R.id.id_student_notify_date);
        studentNoticeEditText=findViewById(R.id.id_student_notify_notice);
        studentSendNoticeButton=findViewById(R.id.id_send_button_in_activity_send_student_notification);
        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_activity_send_student_notification);

        arrowBackImageButton.setOnClickListener(view -> finish());

        MaterialDatePicker.Builder<Long> materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTitleText("Select Today's Date");
        final MaterialDatePicker<Long> materialDatePicker = materialDateBuilder.build();

        studentDateEditText.setOnClickListener(view -> materialDatePicker.show(getSupportFragmentManager(),"MATERIAL_DATE_PICKER"));

        materialDatePicker.addOnPositiveButtonClickListener(selection -> studentDateEditText.setText(materialDatePicker.getHeaderText()));

        studentSendNoticeButton.setOnClickListener(view -> {

            StudentListBottomSheetFragment studentListBottomSheetFragment = new StudentListBottomSheetFragment();
            studentListBottomSheetFragment.show(getSupportFragmentManager(),studentListBottomSheetFragment.getTag());

        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}