package com.example.tpo_training_and_placement.data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.ImageButton;
import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.errorhandling.WrapContentLinearLayoutManager;
import com.example.tpo_training_and_placement.adapters.EditCompanyAdapter;
import com.example.tpo_training_and_placement.models.EditCompanyModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Objects;

public class EditCompanyData extends AppCompatActivity {

    public ImageButton arrowBackImageButton;
    public RecyclerView editCompanyRecyclerView;
    public EditCompanyAdapter editCompanyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_edit_company);

        Objects.requireNonNull(getSupportActionBar()).hide();

        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_data_edit_company);
        editCompanyRecyclerView = findViewById(R.id.id_select_company_recycler_view_in_data_edit_company);

        editCompanyRecyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this));

        FirebaseRecyclerOptions<EditCompanyModel> options =
                new FirebaseRecyclerOptions.Builder<EditCompanyModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("List of Companies"), EditCompanyModel.class)
                        .build();

       editCompanyAdapter = new EditCompanyAdapter(options);
       editCompanyRecyclerView.setAdapter(editCompanyAdapter);

       arrowBackImageButton.setOnClickListener(view -> finish());

    }

    @Override
    protected void onStart() {
        super.onStart();
        editCompanyAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        editCompanyAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        editCompanyAdapter.startListening();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}