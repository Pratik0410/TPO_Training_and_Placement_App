package com.example.tpo_training_and_placement.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.noticeactivity.SendNotificationToStudentActivity;
import com.example.tpo_training_and_placement.activities.noticeactivity.SendNotificationToAllActivity;
import com.example.tpo_training_and_placement.data.SentNotificationsData;

public class NoticeUi extends AppCompatActivity {

    public CardView noticeUiCardView;
    public CardView sendNotificationToAllCardView;
    public CardView sendNotificationToStudentCardView;
    public CardView sentNotificationCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_notice);

        getSupportActionBar().hide();

        noticeUiCardView = findViewById(R.id.id_ui_notice);
        sendNotificationToAllCardView = findViewById(R.id.ID_CardNotifyAll);
        sendNotificationToStudentCardView = findViewById(R.id.ID_CardStudNotify);
        sentNotificationCardView = findViewById(R.id.ID_CardSentNotification);

        noticeUiCardView.setBackgroundResource(R.drawable.top_card_radius);

        sendNotificationToAllCardView.setOnClickListener(view ->
                startActivity(new Intent(NoticeUi.this, SendNotificationToAllActivity.class))
        );

        sendNotificationToStudentCardView.setOnClickListener(view ->
                startActivity(new Intent(NoticeUi.this, SendNotificationToStudentActivity.class))
        );

        sentNotificationCardView.setOnClickListener(view ->
                startActivity(new Intent(NoticeUi.this, SentNotificationsData.class))
        );
    }
}