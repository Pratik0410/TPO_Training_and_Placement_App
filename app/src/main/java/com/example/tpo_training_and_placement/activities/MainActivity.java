package com.example.tpo_training_and_placement.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.requestactivity.StudentRequestActivity;
import com.example.tpo_training_and_placement.ui.AllActivitiesUi;
import com.example.tpo_training_and_placement.ui.CompaniesUi;
import com.example.tpo_training_and_placement.ui.ContactUsUi;
import com.example.tpo_training_and_placement.ui.NoticeUi;
import com.example.tpo_training_and_placement.ui.PlacementHistoryUi;
import com.example.tpo_training_and_placement.ui.PlacementOpportunityUi;
import com.example.tpo_training_and_placement.ui.PrePlacementUi;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public Button viewAllButton;
    public CardView mainStudentRequestCardView;
    public CardView mainNoticeCardView;
    public CardView mainCurrentCompaniesCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.id_main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        viewAllButton = findViewById(R.id.id_main_view_all);
        mainStudentRequestCardView = findViewById(R.id.id_main_student_request);
        mainNoticeCardView = findViewById(R.id.id_main_notice);
        mainCurrentCompaniesCardView = findViewById(R.id.id_main_current_companies);

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));

        actionBar.setBackgroundDrawable(colorDrawable);

        viewAllButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AllActivitiesUi.class);
            startActivity(intent);
        });

        mainStudentRequestCardView.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, StudentRequestActivity.class))
        );

        mainNoticeCardView.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, NoticeUi.class))
        );

        mainCurrentCompaniesCardView.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, PlacementOpportunityUi.class))
        );

    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        actionBarDrawerToggle.onOptionsItemSelected(item);
        return true;
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_student_request:
                startActivity(new Intent(MainActivity.this,StudentRequestActivity.class));
                break;
            case R.id.nav_notice:
                startActivity(new Intent(MainActivity.this,NoticeUi.class));
                break;
            case R.id.nav_placement_opportunities:
                startActivity(new Intent(MainActivity.this,PlacementOpportunityUi.class));
                break;
            case R.id.nav_companies:
                startActivity(new Intent(MainActivity.this, CompaniesUi.class));
                break;
            case R.id.nav_pre_placement:
                startActivity(new Intent(MainActivity.this, PrePlacementUi.class));
                break;
            case R.id.nav_placement_history:
                startActivity(new Intent(MainActivity.this, PlacementHistoryUi.class));
                break;
            case R.id.nav_contact_us:
                startActivity(new Intent(MainActivity.this, ContactUsUi.class));
                break;
            case R.id.nav_logout:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return false;
    }
}
