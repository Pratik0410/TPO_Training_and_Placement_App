package com.example.tpo_training_and_placement.activities.noticeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.tpo_training_and_placement.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SendNotificationToStudentActivity extends AppCompatActivity {

    public EditText studentDateEditText;
    public Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_student_notification);

        getSupportActionBar().hide();

        studentDateEditText = findViewById(R.id.id_student_notify_date);

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
                String dateFormat = "dd/MM/yyyy";
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

    }
}