package com.example.tpo_training_and_placement.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tpo_training_and_placement.R;

import java.util.Objects;

public class ContactUsUi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_contact_us);

        Objects.requireNonNull(getSupportActionBar()).hide();
    }
}