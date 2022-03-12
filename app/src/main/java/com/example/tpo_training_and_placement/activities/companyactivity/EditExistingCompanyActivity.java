package com.example.tpo_training_and_placement.activities.companyactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.ui.CompaniesUi;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.squareup.picasso.Picasso;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EditExistingCompanyActivity extends AppCompatActivity {

    public ImageButton arrowBackImageButton;
    public Button updateButton, deleteButton;
    public TextInputEditText companyNameTextInputEditText, productServiceTextInputEditText, aboutTextInputEditText, contactDetailsTextInputEditText;
    public AutoCompleteTextView typeOfCompanyAutoCompleteTextView;
    public String[] productServiceArray = {"Product Based","Service Based","Both(Product & Service)"};
    public ImageView companyImageView;
    public String companyNameString, typeOfCompanyString, productServiceString, aboutString, contactDetailsString, companyLogoString;
    public Uri filepath;
    public Bitmap bitmap;
    public int flagToCheckUploadingImage =0;

    @Override
    protected void onResume() {
        super.onResume();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(EditExistingCompanyActivity.this,R.layout.dropdownlist_item,productServiceArray);
        typeOfCompanyAutoCompleteTextView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_existing_company);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(EditExistingCompanyActivity.this,R.layout.dropdownlist_item,productServiceArray);

        Objects.requireNonNull(getSupportActionBar()).hide();

        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_activity_edit_existing_company);
        companyNameTextInputEditText = findViewById(R.id.id_company_name_edit_text_in_activity_edit_existing_company);
        typeOfCompanyAutoCompleteTextView = findViewById(R.id.id_auto_complete_textview_in_activity_edit_existing_company);
        productServiceTextInputEditText = findViewById(R.id.id_product_service_edit_text_in_activity_edit_existing_company);
        aboutTextInputEditText = findViewById(R.id.id_about_edit_text_in_edit_existing_company);
        contactDetailsTextInputEditText = findViewById(R.id.id_contact_details_edit_text_in_activity_edit_existing_company);
        companyImageView = findViewById(R.id.id_upload_company_logo_imageview_in_activity_edit_existing_company);
        updateButton = findViewById(R.id.id_upload_button_in_activity_edit_existing_company2);
        deleteButton = findViewById(R.id.id_upload_button_in_activity_edit_existing_company);

        companyNameString = getIntent().getExtras().get("Company Name").toString();
        typeOfCompanyString = getIntent().getExtras().get("Type of Company").toString();
        productServiceString = getIntent().getExtras().get("Product or Service of Company").toString();
        aboutString = getIntent().getExtras().get("About Company").toString();
        contactDetailsString = getIntent().getExtras().get("Contact Details").toString();
        companyLogoString = getIntent().getExtras().get("Company Logo").toString();

        companyNameTextInputEditText.setText(companyNameString);
        typeOfCompanyAutoCompleteTextView.setText(typeOfCompanyString);
        productServiceTextInputEditText.setText(productServiceString);
        aboutTextInputEditText.setText(aboutString);
        contactDetailsTextInputEditText.setText(contactDetailsString);
        Picasso.get().load(companyLogoString).into(companyImageView);

        arrowBackImageButton.setOnClickListener(view -> finish());

        typeOfCompanyAutoCompleteTextView.setAdapter(arrayAdapter);

        typeOfCompanyAutoCompleteTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                productService = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        companyImageView.setOnClickListener(view -> Dexter.withActivity(EditExistingCompanyActivity.this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response)
                    {
                        Intent intent=new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(Intent.createChooser(intent,"Please select Image"),1);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }

                }).check());


        updateButton.setOnClickListener(view -> {

            if (Objects.requireNonNull(companyNameTextInputEditText.getText()).toString().length() !=0 && typeOfCompanyAutoCompleteTextView.getText().toString().length() != 0 && Objects.requireNonNull(productServiceTextInputEditText.getText()).toString().length() !=0
                    && Objects.requireNonNull(aboutTextInputEditText.getText()).toString().length() !=0 && Objects.requireNonNull(contactDetailsTextInputEditText.getText()).toString().length() !=0) {
                if (flagToCheckUploadingImage == 5) {

                    FirebaseStorage storage = FirebaseStorage.getInstance();
                    StorageReference uploader = storage.getReference().child("Companies").child(companyNameTextInputEditText.getText().toString());

                    uploader.putFile(filepath)
                            .addOnSuccessListener(taskSnapshot -> {
                                Task<Uri> result = taskSnapshot.getStorage().getDownloadUrl();
                                result.addOnSuccessListener(uri -> {

                                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                    DatabaseReference databaseReference = firebaseDatabase.getReference("List of Companies");

                                    Map<String, String> map = new HashMap<>();
                                    map.put("CompanyName", companyNameTextInputEditText.getText().toString());
                                    map.put("TypeofCompany", typeOfCompanyAutoCompleteTextView.getText().toString());
                                    map.put("ProductorServiceofCompany", productServiceTextInputEditText.getText().toString());
                                    map.put("AboutCompany", aboutTextInputEditText.getText().toString());
                                    map.put("ContactDetails", contactDetailsTextInputEditText.getText().toString());
                                    map.put("CompanyLogo", uri.toString());

                                    FirebaseDatabase.getInstance().getReference("List of Companies")
                                            .child(companyNameString).removeValue();
                                    databaseReference.child(companyNameTextInputEditText.getText().toString()).setValue(map);
                                    startActivity(new Intent(EditExistingCompanyActivity.this, CompaniesUi.class));
                                    finish();
                                }).addOnFailureListener(e -> Toast.makeText(EditExistingCompanyActivity.this, "Failed to Update", Toast.LENGTH_SHORT).show());
                            });
                }
                else{

                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference = firebaseDatabase.getReference("List of Companies");

                    Map<String, String> map = new HashMap<>();
                    map.put("CompanyName", Objects.requireNonNull(companyNameTextInputEditText.getText()).toString());
                    map.put("TypeofCompany", typeOfCompanyAutoCompleteTextView.getText().toString());
                    map.put("ProductorServiceofCompany", Objects.requireNonNull(productServiceTextInputEditText.getText()).toString());
                    map.put("AboutCompany", Objects.requireNonNull(aboutTextInputEditText.getText()).toString());
                    map.put("ContactDetails", Objects.requireNonNull(contactDetailsTextInputEditText.getText()).toString());
                    map.put("CompanyLogo", companyLogoString);

                    FirebaseDatabase.getInstance().getReference("List of Companies")
                            .child(companyNameString).removeValue();
                    databaseReference.child(companyNameTextInputEditText.getText().toString()).setValue(map);
                    startActivity(new Intent(EditExistingCompanyActivity.this, CompaniesUi.class));
                    finish();
                }
            } else{
                Toast.makeText(EditExistingCompanyActivity.this, "Please Fill All Details", Toast.LENGTH_SHORT).show();
            }
        });

        deleteButton.setOnClickListener(view -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EditExistingCompanyActivity.this);
            alertDialogBuilder.setTitle("Delete").setMessage("Are you Sure?");
            alertDialogBuilder.setPositiveButton("Yes", (dialog, which) -> FirebaseDatabase.getInstance().getReference("List of Companies").child(companyNameString).removeValue()
                    .addOnSuccessListener(unused -> FirebaseStorage.getInstance().getReference("List of Companies").child(companyNameString).delete().addOnSuccessListener(unused1 -> {
                        Toast.makeText(EditExistingCompanyActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }).addOnFailureListener(e -> Toast.makeText(EditExistingCompanyActivity.this, "Failed to Delete", Toast.LENGTH_SHORT).show())));
            alertDialogBuilder.setNegativeButton("No", (dialogInterface, i) -> Toast.makeText(view.getContext(), "Failed to Delete", Toast.LENGTH_SHORT).show());
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode==1 && resultCode==RESULT_OK)
        {
            assert data != null;
            filepath=data.getData();
            try
            {
                InputStream inputStream=getContentResolver().openInputStream(filepath);
                bitmap= BitmapFactory.decodeStream(inputStream);
                companyImageView.setImageBitmap(bitmap);
                flagToCheckUploadingImage =5;
            }catch (Exception ex)
            {
                //pass
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}