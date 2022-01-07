package com.example.tpo_training_and_placement.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.requestactivity.StudentRequestActivity;

public class AllActivitiesUi extends AppCompatActivity {

    public CardView uiAllComponentsCardView;
    public CardView studentRequestCardView;
    public CardView noticeCardView;
    public CardView placementOpportunitiesCardView;
    public CardView companyCardView;
    public CardView prePlacementCardView;
    public CardView contactUsCardView;
    public CardView placementHistoryCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_all_activities);

        getSupportActionBar().hide();

        uiAllComponentsCardView = findViewById(R.id.id_ui_all_components);
        studentRequestCardView = findViewById(R.id.id_student_request_card);
        noticeCardView = findViewById(R.id.id_notice_card);
        placementOpportunitiesCardView = findViewById(R.id.id_current_companies_card);
        companyCardView = findViewById(R.id.id_companies_card);
        prePlacementCardView = findViewById(R.id.id_pre_placement_card);
        contactUsCardView = findViewById(R.id.id_contact_us_card);
        placementHistoryCardView = findViewById(R.id.id_placement_history_card);

        studentRequestCardView.setOnClickListener(view -> {
            startActivity(new Intent(AllActivitiesUi.this, StudentRequestActivity.class));
        });

        noticeCardView.setOnClickListener(view -> {
            startActivity(new Intent(AllActivitiesUi.this, NoticeUi.class));
        });

        placementOpportunitiesCardView.setOnClickListener(view -> {
            startActivity(new Intent(AllActivitiesUi.this,PlacementOpportunityUi.class));
        });

        companyCardView.setOnClickListener(View -> {
            startActivity(new Intent(AllActivitiesUi.this,CompaniesUi.class));

        });

        prePlacementCardView.setOnClickListener(View -> {
            startActivity(new Intent(AllActivitiesUi.this,PrePlacementUi.class));

        });

        placementHistoryCardView.setOnClickListener(view -> {
            startActivity(new Intent(AllActivitiesUi.this, PlacementHistoryUi.class));
        });


        contactUsCardView.setOnClickListener(View -> {
            startActivity(new Intent(AllActivitiesUi.this,ContactUsUi.class));

        });


    }
}