package com.example.tpo_training_and_placement.activities.noticeactivity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import com.example.tpo_training_and_placement.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SendNotificationToAllActivity extends AppCompatActivity {

    public EditText dateEditText;
    public EditText enterNoticeEditText;
    public CardView notifyAllUiCardView;
    public Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notification_to_all);

        getSupportActionBar().hide();

        dateEditText = findViewById(R.id.id_notify_all_date);
        enterNoticeEditText = findViewById(R.id.id_notify_all_notice);
        notifyAllUiCardView = findViewById(R.id.id_notification_card);

        calendar =Calendar.getInstance();
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
                dateEditText.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };

        notifyAllUiCardView.setBackgroundResource(R.drawable.bottom_card_radius);

        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateEditText.setTextColor(Color.BLACK);
                new DatePickerDialog(SendNotificationToAllActivity.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        enterNoticeEditText.setOnClickListener(view ->
                enterNoticeEditText.setTextColor(Color.BLACK)
        );

    }
}