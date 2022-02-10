package com.example.tpo_training_and_placement.activities.placementhistoryactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.tpo_training_and_placement.R;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddPlacementHistoryDataActivity extends AppCompatActivity {

    public Button addBranchButton;
    public ImageButton arrowBackImageButton;
    public LinearLayout linearLayout;
    public List<String> selectBranchList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_placement_history_data);

        Objects.requireNonNull(getSupportActionBar()).hide();

        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_activity_add_placement_history_data);
        addBranchButton = findViewById(R.id.id_add_branch_button_in_activity_add_placement_history_data);
        linearLayout = findViewById(R.id.id_select_branch_linearlayout_in_activity_add_placement_history_data);

        selectBranchList.add("AI/ML");
        selectBranchList.add("CE");
        selectBranchList.add("CH");
        selectBranchList.add("CM");
        selectBranchList.add("IT");
        selectBranchList.add("ME");
        selectBranchList.add("EJ");

        arrowBackImageButton.setOnClickListener(view -> finish());
        addBranchButton.setOnClickListener(view -> addView());

    }

    private void addView() {
        View selectBranchView = getLayoutInflater().inflate(R.layout.model_select_branch_card,null,false);

        TextInputEditText textInputEditText = (TextInputEditText) selectBranchView.findViewById(R.id.id_no_of_students_textinputedittext_in_model_select_branch_card);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) selectBranchView.findViewById(R.id.id_select_branch_auto_complete_textview_in_model_select_branch_card);
        ImageView closeImageView = (ImageView) selectBranchView.findViewById(R.id.id_close_button_imageview_in_model_select_branch_card);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(AddPlacementHistoryDataActivity.this,R.layout.dropdownlist_item,selectBranchList);
        autoCompleteTextView.setAdapter(arrayAdapter);

        closeImageView.setOnClickListener(view -> removeView(selectBranchView));

        linearLayout.addView(selectBranchView);

    }

    private void removeView(View view) {
        linearLayout.removeView(view);
    }
}