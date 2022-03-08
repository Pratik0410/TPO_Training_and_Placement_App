package com.example.tpo_training_and_placement.activities.placementhistoryactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tpo_training_and_placement.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import okhttp3.internal.cache.DiskLruCache;

public class AddPlacementHistoryDataActivity extends AppCompatActivity {

    public ImageButton arrowBackImageButton;
    public AutoCompleteTextView yearAutoCompleteTextView;
    public AutoCompleteTextView studentNameAutoCompleteTextView;
    public TextInputLayout textInputLayout;
    public AutoCompleteTextView selectCompanyAutoCompleteTextView;
    public TextInputEditText designationTextInputEditText, salaryTextInputEdittext;
    public Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_placement_history_data);

        Objects.requireNonNull(getSupportActionBar()).hide();

        yearAutoCompleteTextView = findViewById(R.id.id_auto_complete_textview_in_edit_existing_company2);
        studentNameAutoCompleteTextView = findViewById(R.id.id_auto_complete_textview_in_edit_existing_company3);
        textInputLayout = findViewById(R.id.id_text_input_layout);
        selectCompanyAutoCompleteTextView = findViewById(R.id.id_auto_complete_textview_in_edit_existing_company);
        designationTextInputEditText = findViewById(R.id.id_average_lpa_edit_text_in_activity_add_placement_history_data);
        salaryTextInputEdittext = findViewById(R.id.id_about_edit_text_in_edit_existing_company);
        submitButton = findViewById(R.id.id_upload_button_in_activity_add_placement_opportunity);
        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_activity_add_placement_history_data);

        arrowBackImageButton.setOnClickListener(view -> finish());

        yearAutoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AddPlacementHistoryDataActivity.this);
                builder.setTitle("Warning").setMessage("Select correct year. You can't edit year later!!!");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ArrayList<String> years = new ArrayList<String>();
                        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
                        for(int y = 2000; y <= thisYear; y++) {
                            years.add(Integer.toString(y));
                        }
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddPlacementHistoryDataActivity.this,R.layout.dropdownlist_item,years);
                        yearAutoCompleteTextView.setAdapter(arrayAdapter);

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        ArrayList<String> company = new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddPlacementHistoryDataActivity.this,R.layout.dropdownlist_item,company);
        selectCompanyAutoCompleteTextView.setAdapter(adapter);
        database.child("List of Companies").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot companyNameSnapshot : snapshot.getChildren()){
                    company.add(companyNameSnapshot.child("CompanyName").getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        ArrayList<String> student = new ArrayList<String>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddPlacementHistoryDataActivity.this,R.layout.dropdownlist_item,student);
        studentNameAutoCompleteTextView.setAdapter(arrayAdapter);
        databaseReference.child("Students").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot studentNameSnapshot : snapshot.getChildren()){
                    student.add(studentNameSnapshot.child("StudentName").getValue().toString());
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yearAutoCompleteTextView.getText().toString().length() != 0 && studentNameAutoCompleteTextView.getText().toString().length() != 0 && selectCompanyAutoCompleteTextView.getText().toString().length() != 0
                        && designationTextInputEditText.getText().toString().length() != 0 && salaryTextInputEdittext.getText().toString().length() != 0)
                {
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference placementHistory = firebaseDatabase.getReference("Placement History");

                    Map<String, String> data = new HashMap();
                    data.put("Year", yearAutoCompleteTextView.getText().toString());
                    data.put("StudentName", studentNameAutoCompleteTextView.getText().toString());
                    data.put("Company", selectCompanyAutoCompleteTextView.getText().toString());
                    data.put("Designation", designationTextInputEditText.getText().toString());
                    data.put("Salary", salaryTextInputEdittext.getText().toString());
                    placementHistory.child(yearAutoCompleteTextView.getText().toString()).child(studentNameAutoCompleteTextView.getText().toString()).setValue(data);

                    finish();
                }else{
                    Toast.makeText(AddPlacementHistoryDataActivity.this, "Fill All The Details", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}