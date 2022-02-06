package com.example.tpo_training_and_placement.data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.adapters.SentNotificationAdapter;
import com.example.tpo_training_and_placement.models.SentNotificationModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SentNotificationsData extends AppCompatActivity {

    public ImageButton arrowBackImageButton;
    RecyclerView sentNotificationRecyclerView;
    SentNotificationAdapter sentNotificationsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_sent_notifications);

        Objects.requireNonNull(getSupportActionBar()).hide();

        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_data_sent_notifications);
        sentNotificationRecyclerView = findViewById(R.id.id_sent_notifications_recycler_view);
        sentNotificationRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<SentNotificationModel> options =
                new FirebaseRecyclerOptions.Builder<SentNotificationModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Notice"), SentNotificationModel.class)
                        .build();

        sentNotificationsAdapter = new SentNotificationAdapter(options);
        sentNotificationRecyclerView.setAdapter(sentNotificationsAdapter);

        arrowBackImageButton.setOnClickListener(view -> finish());

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

    @Override
    protected void onResume() {
        super.onResume();

        FirebaseRecyclerOptions<SentNotificationModel> options =
                new FirebaseRecyclerOptions.Builder<SentNotificationModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Notice"), SentNotificationModel.class)
                        .build();

        sentNotificationsAdapter = new SentNotificationAdapter(options);
        sentNotificationRecyclerView.setAdapter(sentNotificationsAdapter);

        arrowBackImageButton.setOnClickListener(view -> finish());

        sentNotificationsAdapter.startListening();
    }
}