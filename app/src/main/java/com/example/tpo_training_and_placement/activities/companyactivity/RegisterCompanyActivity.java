package com.example.tpo_training_and_placement.activities.companyactivity;

import androidx.annotation.Nullable;
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
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tpo_training_and_placement.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegisterCompanyActivity extends AppCompatActivity {

    public Button registerButton;
    public String[] productServiceArray = {"Product Based","Service Based","Both(Product & Service)"};
    public TextInputEditText companyNameTextInputEditText, productServiceTextInputEditText, aboutTextInputEditText, contactDetailsTextInputEditText;
    public TextInputLayout textInputLayout;
    public AutoCompleteTextView typeOfCompanyAutoCompleteTextView;
    public ImageView companyImageView;
    public Uri filepath;
    public Bitmap bitmap;
    public int flagToCheckUploadingImage =0;
    public int productService;


    @Override
    protected void onResume() {
        super.onResume();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(RegisterCompanyActivity.this,R.layout.dropdownlist_item,productServiceArray);
        typeOfCompanyAutoCompleteTextView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_company);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(RegisterCompanyActivity.this,R.layout.dropdownlist_item,productServiceArray);

        Objects.requireNonNull(getSupportActionBar()).hide();

        registerButton = findViewById(R.id.id_upload_button_in_activity_add_placement_opportunity);
        companyNameTextInputEditText = findViewById(R.id.id_company_name_edit_text_in_register_company);
        productServiceTextInputEditText = findViewById(R.id.id_product_service_edit_text);
        aboutTextInputEditText = findViewById(R.id.id_about_edit_text_in_register_company);
        contactDetailsTextInputEditText = findViewById(R.id.id_contact_details_edit_text_in_register_company);
        textInputLayout = findViewById(R.id.id_text_input_layout);
        typeOfCompanyAutoCompleteTextView = findViewById(R.id.id_auto_complete_textview);
        companyImageView = findViewById(R.id.id_upload_company_logo_imageview);

        typeOfCompanyAutoCompleteTextView.setAdapter(arrayAdapter);

        typeOfCompanyAutoCompleteTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                productService = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        companyImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withActivity(RegisterCompanyActivity.this)
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

                        }).check();

            }
        });



        registerButton.setOnClickListener(view -> {

            if (companyNameTextInputEditText.getText().toString().length() !=0 && typeOfCompanyAutoCompleteTextView.getText().toString().length() != 0 && productServiceTextInputEditText.getText().toString().length() !=0
            && aboutTextInputEditText.getText().toString().length() !=0 && contactDetailsTextInputEditText.getText().toString().length() !=0) {

                if (flagToCheckUploadingImage == 5) {
                    FirebaseStorage storage = FirebaseStorage.getInstance();//image1 is your image name
                    StorageReference uploader = storage.getReference().child(companyNameTextInputEditText.getText().toString());

                    uploader.putFile(filepath)
                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    Task<Uri> result = taskSnapshot.getStorage().getDownloadUrl();
                                    result.addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {

                                            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                            DatabaseReference databaseReference = firebaseDatabase.getReference("List of Companies");

                                            Map map = new HashMap();
                                            map.put("CompanyName", companyNameTextInputEditText.getText().toString());
                                            map.put("Type of Company", typeOfCompanyAutoCompleteTextView.getText().toString());
                                            map.put("Product or Service of Company", productServiceTextInputEditText.getText().toString());
                                            map.put("About Company", aboutTextInputEditText.getText().toString());
                                            map.put("Contact Details", contactDetailsTextInputEditText.getText().toString());
                                            map.put("Company Logo", uri.toString());
                                            databaseReference.child(companyNameTextInputEditText.getText().toString()).setValue(map);
                                        }
                                    });
                                }
                            });
                    finish();
                } else {
                    Toast.makeText(RegisterCompanyActivity.this, "Please Select Image", Toast.LENGTH_SHORT).show();
                }
            } else{
                Toast.makeText(RegisterCompanyActivity.this, "Please Fill All Details", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode==1 && resultCode==RESULT_OK)
        {
            filepath=data.getData();
            try
            {
                InputStream inputStream=getContentResolver().openInputStream(filepath);
                bitmap= BitmapFactory.decodeStream(inputStream);
                companyImageView.setImageBitmap(bitmap);
                flagToCheckUploadingImage =5;
            }catch (Exception ex)
            {
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