package com.example.tpo_training_and_placement.activities.noticeactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tpo_training_and_placement.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.datepicker.MaterialDatePicker;
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

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SendNotificationToAllActivity extends AppCompatActivity {

    public EditText dateEditText;
    public EditText enterNoticeEditText;
    public ImageButton arrowBackImageButton;
    public Button sendButton;
    public TextView uploadFileTextView;
    public Uri filepath;
    public int flagToCheckUploadingPDF = 0;
    String pdfName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notification_to_all);

        Objects.requireNonNull(getSupportActionBar()).hide();

        dateEditText = findViewById(R.id.id_date_edit_text_in_activity_send_notification_to_all);
        enterNoticeEditText = findViewById(R.id.id_notice_edit_text_in_activity_send_notification_to_all);
        sendButton = findViewById(R.id.id_send_button_in_activity_send_notification_to_all);
        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_activity_send_notification_to_all);
        uploadFileTextView = findViewById(R.id.id_upload_file_edit_text_in_activity_send_notification_to_all);

        arrowBackImageButton.setOnClickListener(view -> finish());

        MaterialDatePicker.Builder<Long> materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTitleText("Select Today's Date");
        final MaterialDatePicker<Long> materialDatePicker = materialDateBuilder.build();

        dateEditText.setOnClickListener(view -> materialDatePicker.show(getSupportFragmentManager(),"MATERIAL_DATE_PICKER"));

        materialDatePicker.addOnPositiveButtonClickListener(selection -> dateEditText.setText(materialDatePicker.getHeaderText()));

        uploadFileTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withContext(getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent intent = new Intent();
                                intent.setType("application/pdf");
                                intent.setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(Intent.createChooser(intent,"Select PDF File"),101);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                permissionToken.continuePermissionRequest();
                            }
                        }).check();
            }
        });

        sendButton.setOnClickListener(view -> {

            if (flagToCheckUploadingPDF == 5){
                uploadFileTextView.setText(pdfName);
                FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference uploader = storage.getReference().child("Notice").child(dateEditText.getText().toString());


                uploader.putFile(filepath)
                        .addOnSuccessListener(taskSnapshot -> {
                            Task<Uri> result = taskSnapshot.getStorage().getDownloadUrl();
                            result.addOnSuccessListener(uri -> {
                                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                DatabaseReference databaseReference = firebaseDatabase.getReference("Notice");

                                if(dateEditText.getText().toString().length() > 0 && enterNoticeEditText.getText().toString().length() > 0){

                                    Map<String,String> data = new HashMap<>();
                                    data.put("Date", dateEditText.getText().toString());
                                    data.put("Notice", enterNoticeEditText.getText().toString());
                                    data.put("PDF", uri.toString());
                                    databaseReference.child(dateEditText.getText().toString()).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(SendNotificationToAllActivity.this,"Notification Send Successfully", Toast.LENGTH_SHORT).show();
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(SendNotificationToAllActivity.this,"Fail To Send Notification",Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                    finish();
                                }
                                else{
                                    Toast.makeText(SendNotificationToAllActivity.this, "Please Fill All Details", Toast.LENGTH_SHORT).show();
                                }

                            });

                        });
            }else {
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = firebaseDatabase.getReference("Notice");

                if (dateEditText.getText().toString().length() > 0 && enterNoticeEditText.getText().toString().length() > 0) {

                    Map<String, String> data = new HashMap<>();
                    data.put("Date", dateEditText.getText().toString());
                    data.put("Notice", enterNoticeEditText.getText().toString());
                    databaseReference.child(dateEditText.getText().toString()).setValue(data);

                    finish();
                } else {
                    Toast.makeText(SendNotificationToAllActivity.this, "Please Fill All Details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @SuppressLint("Range")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==101 && resultCode == RESULT_OK){
            filepath = Objects.requireNonNull(data).getData();
            flagToCheckUploadingPDF = 5;
            if (filepath.toString().startsWith("content://")){
                Cursor cursor = null;
                cursor = SendNotificationToAllActivity.this.getContentResolver().query(filepath,null,null,null,null);
                if (cursor != null && cursor.moveToFirst()){
                    pdfName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }

            }else if(filepath.toString().startsWith("file://")){
                pdfName = new File(filepath.toString()).getName();
            }
            uploadFileTextView.setText(pdfName);
        }
    }
}