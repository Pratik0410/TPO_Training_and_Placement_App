package com.example.tpo_training_and_placement.activities.noticeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.fragment.StudentListBottomSheetFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SendNotificationToStudentActivity extends AppCompatActivity {

    public EditText studentDateEditText;
    public EditText studentNoticeEditText;
    public Button studentSendNoticeButton;
    public Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_student_notification);

        getSupportActionBar().hide();
        studentDateEditText = findViewById(R.id.id_student_notify_date);
        studentNoticeEditText=findViewById(R.id.id_student_notify_notice);
        studentSendNoticeButton=findViewById(R.id.id_student_notify_send);

        calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int YEAR, int MONTH, int DAY_OF_MONTH) {
                calendar.set(Calendar.YEAR,YEAR);
                calendar.set(Calendar.MONTH,MONTH);
                calendar.set(Calendar.DAY_OF_MONTH,DAY_OF_MONTH);

                updateCalender();
            }

            private void updateCalender() {
                String dateFormat = "dd-MM-yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.US);
                studentDateEditText.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };

        studentDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentDateEditText.setTextColor(Color.BLACK);
                new DatePickerDialog(SendNotificationToStudentActivity.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        studentSendNoticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StudentListBottomSheetFragment studentListBottomSheetFragment = new StudentListBottomSheetFragment();
                studentListBottomSheetFragment.show(getSupportFragmentManager(),studentListBottomSheetFragment.getTag());

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference StudentNotice = database.getReference("Student Notice");

                Map data = new HashMap();
                data.put("Date",studentDateEditText.getText().toString());
                data.put("Notice",studentNoticeEditText.getText().toString());
                StudentNotice.child(studentDateEditText.getText().toString()).setValue(data);

            }
        });

    }
}