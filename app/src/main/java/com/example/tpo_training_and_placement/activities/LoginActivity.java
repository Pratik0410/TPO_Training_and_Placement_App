package com.example.tpo_training_and_placement.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.tpo_training_and_placement.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    public EditText usernameEditText;
    public EditText passwordEditText;
    public FirebaseAuth mAuth;
    public FirebaseUser adminUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.id_username);
        passwordEditText = findViewById(R.id.id_password);
        mAuth = FirebaseAuth.getInstance();
        adminUser = mAuth.getCurrentUser();

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));

        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);

        if(adminUser!=null){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }

    }

    public void afterLogin(View view){
        if(usernameEditText.getText().length()==0){
            Toast.makeText(LoginActivity.this, "Enter Email", Toast.LENGTH_LONG).show();
        }else if(passwordEditText.getText().length()==0){
            Toast.makeText(LoginActivity.this, "Enter Password", Toast.LENGTH_LONG).show();
        }else{
            mAuth.signInWithEmailAndPassword(usernameEditText.getText().toString(), passwordEditText.getText().toString())
                    .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                                updateUI(user);
                            } else {
                                Toast.makeText(LoginActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();
                                updateUI(null);
                            }
                        }

                        private void updateUI(FirebaseUser user) {
                        }
                    });
        }
    }
}