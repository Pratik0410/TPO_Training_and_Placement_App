package com.example.tpo_training_and_placement.activities.noticeactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.ui.NoticeUi;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class SendNotificationToAllActivity extends AppCompatActivity {

    public EditText dateEditText;
    public EditText enterNoticeEditText;
    public CardView notifyAllUiCardView;
    public Calendar calendar;
    public Button sendButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notification_to_all);

        Objects.requireNonNull(getSupportActionBar()).hide();

        dateEditText = findViewById(R.id.id_notify_all_date);
        enterNoticeEditText = findViewById(R.id.id_notify_all_notice);
        notifyAllUiCardView = findViewById(R.id.id_notification_card);
        sendButton = findViewById(R.id.id_notify_all_send);

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
                String dateFormat = "dd-MM-yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.US);
                dateEditText.setText(simpleDateFormat.format(calendar.getTime()));
            }


        };

        notifyAllUiCardView.setBackgroundResource(R.drawable.bottom_card_radius);

        dateEditText.setOnClickListener(view -> {
            dateEditText.setTextColor(Color.BLACK);
            new DatePickerDialog(SendNotificationToAllActivity.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        enterNoticeEditText.setOnClickListener(view ->
                enterNoticeEditText.setTextColor(Color.BLACK)
        );


        sendButton.setOnClickListener(view -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference notifyall = database.getReference("Notice");

            Map data = new HashMap();
            data.put("Date", dateEditText.getText().toString());
            data.put("Notice", enterNoticeEditText.getText().toString());
            notifyall.child(dateEditText.getText().toString()).setValue(data);

            startActivity(new Intent(SendNotificationToAllActivity.this, NoticeUi.class));
            finish();

        });

    }
}