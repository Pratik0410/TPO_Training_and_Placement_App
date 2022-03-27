package com.example.tpo_training_and_placement.activities.noticeactivity;

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
import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.fragment.StudentListBottomSheetFragment;
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

public class SendNotificationToStudentActivity extends AppCompatActivity {

    public EditText studentDateEditText;
    public EditText studentNoticeEditText;
    public Button studentSendNoticeButton;
    public ImageButton arrowBackImageButton;
    public TextView uploadFileTextView;
    public Uri filepath;
    public int flagToCheckUploadingPDF = 0;
    String pdfName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_student_notification);

        Objects.requireNonNull(getSupportActionBar()).hide();

        studentDateEditText = findViewById(R.id.id_student_notify_date);
        studentNoticeEditText=findViewById(R.id.id_student_notify_notice);
        studentSendNoticeButton=findViewById(R.id.id_send_button_in_activity_send_student_notification);
        arrowBackImageButton = findViewById(R.id.id_arrow_back_image_button_in_activity_send_student_notification);
        uploadFileTextView = findViewById(R.id.id_upload_file_edit_text_in_activity_send_notification_to_student);

        arrowBackImageButton.setOnClickListener(view -> finish());

        MaterialDatePicker.Builder<Long> materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTitleText("Select Today's Date");
        final MaterialDatePicker<Long> materialDatePicker = materialDateBuilder.build();

        studentDateEditText.setOnClickListener(view -> materialDatePicker.show(getSupportFragmentManager(),"MATERIAL_DATE_PICKER"));

        materialDatePicker.addOnPositiveButtonClickListener(selection -> studentDateEditText.setText(materialDatePicker.getHeaderText()));

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
                                startActivityForResult(Intent.createChooser(intent,"Select PDF File"),102);
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

        studentSendNoticeButton.setOnClickListener(view -> {
            if (studentDateEditText.getText().length() != 0 && studentNoticeEditText.getText().length() != 0){
                StudentListBottomSheetFragment studentListBottomSheetFragment = new StudentListBottomSheetFragment();
                studentListBottomSheetFragment.show(getSupportFragmentManager(),studentListBottomSheetFragment.getTag());

                if (flagToCheckUploadingPDF == 5){
                    FirebaseStorage storage = FirebaseStorage.getInstance();
                    StorageReference uploader = storage.getReference().child("Student Notice").child(studentDateEditText.getText().toString());

                    uploader.putFile(filepath)
                            .addOnSuccessListener(taskSnapshot -> {
                                Task<Uri> result = taskSnapshot.getStorage().getDownloadUrl();
                                result.addOnSuccessListener(uri -> {
                                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                    DatabaseReference databaseReference = firebaseDatabase.getReference("Student Notice");

                                    Map<String,String> data = new HashMap();
                                    data.put("Date",studentDateEditText.getText().toString());
                                    data.put("Notice",studentNoticeEditText.getText().toString());
                                    data.put("PDF File", uri.toString());
                                    databaseReference.child(studentDateEditText.getText().toString()).setValue(data);

                                });
                            });

                }else {
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference = firebaseDatabase.getReference("Student Notice");

                    Map<String, String> data = new HashMap();
                    data.put("Date", studentDateEditText.getText().toString());
                    data.put("Notice", studentNoticeEditText.getText().toString());
                    databaseReference.child(studentDateEditText.getText().toString()).setValue(data);
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
        if (requestCode==102 && resultCode == RESULT_OK){
            filepath = Objects.requireNonNull(data).getData();
            flagToCheckUploadingPDF = 5;
            if (filepath.toString().startsWith("content://")){
                Cursor cursor = null;
                cursor = SendNotificationToStudentActivity.this.getContentResolver().query(filepath,null,null,null,null);
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