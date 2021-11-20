package com.example.tpo_training_and_placement.activities.noticeactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.adapters.SentNotificationAdapter;
import com.example.tpo_training_and_placement.models.SentNotificationModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SentNotificationsActivity extends AppCompatActivity {

    RecyclerView sentNotificationRecyclerView;
    SentNotificationAdapter sentNotificationsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent_notifications);

        Objects.requireNonNull(getSupportActionBar()).hide();

        sentNotificationRecyclerView = findViewById(R.id.id_sent_notify_recycler_view);
        sentNotificationRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<SentNotificationModel> options =
                new FirebaseRecyclerOptions.Builder<SentNotificationModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Notice"), SentNotificationModel.class)
                        .build();

        sentNotificationsAdapter = new SentNotificationAdapter(options);
        sentNotificationRecyclerView.setAdapter(sentNotificationsAdapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        sentNotificationsAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        sentNotificationsAdapter.stopListening();
    }
}