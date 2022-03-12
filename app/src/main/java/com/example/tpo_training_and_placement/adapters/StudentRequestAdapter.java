package com.example.tpo_training_and_placement.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.models.StudentRequestModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.HashMap;
import java.util.Map;

public class StudentRequestAdapter extends FirebaseRecyclerAdapter<StudentRequestModel, StudentRequestAdapter.ViewHolder> {

    public StudentRequestAdapter(@NonNull FirebaseRecyclerOptions<StudentRequestModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull StudentRequestModel studentRequestModel) {
        holder.nameTextView.setText(studentRequestModel.getStudentName());
        holder.emailTextView.setText(studentRequestModel.getEmail());
        holder.mobileNumberTextView.setText(studentRequestModel.getPhoneNumber());
        holder.branchTextView.setText(studentRequestModel.getBranch());
        holder.acceptButton.setOnClickListener(view -> {
            FirebaseAuth mAuth;
            mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(studentRequestModel.getEmail(), studentRequestModel.getPassword())
                    .addOnCompleteListener((Activity) view.getContext(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                DatabaseReference databaseReference = firebaseDatabase.getReference().child("Students");
                                FirebaseUser firebaseUser = mAuth.getCurrentUser();
                                Map<String,String> map = new HashMap<>();
                                map.put("StudentImage",studentRequestModel.getStudentImage());
                                map.put("StudentName",studentRequestModel.getStudentName());
                                map.put("Email",studentRequestModel.getEmail());
                                map.put("PhoneNumber",studentRequestModel.getPhoneNumber());
                                map.put("Branch",studentRequestModel.getBranch());
                                assert firebaseUser != null;
                                databaseReference.child(firebaseUser.getUid()).setValue(map);
                                FirebaseDatabase.getInstance().getReference("Student Request")
                                        .child(studentRequestModel.getStudentName()).removeValue();
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("TAG", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(view.getContext(), "Authentication failed." + task.getException(),
                                        Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }
                        }
                        private void updateUI(FirebaseUser user) {
                        }
                    });
            /*Notification code remaining
            * Send notification to student of admin has accepted or denied the request*/
        });
        holder.denyButton.setOnClickListener(view -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());
            alertDialogBuilder.setTitle("Deny").setMessage("Are you Sure?");
            alertDialogBuilder.setPositiveButton("Yes", (dialogInterface, i) -> FirebaseDatabase.getInstance().getReference("Student Request")
                    .child(studentRequestModel.getStudentName()).removeValue()
                    .addOnSuccessListener(unused -> {
                        FirebaseStorage.getInstance().getReference("Student Profile").child(studentRequestModel.getStudentName()).delete().addOnSuccessListener(unused1 -> {
                            Toast.makeText(view.getContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
                            ((Activity)view.getContext()).finish();
                        }).addOnFailureListener(e -> Toast.makeText(view.getContext(), "Failed to Delete", Toast.LENGTH_SHORT).show());
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        assert user != null;
                        user.delete()
                                .addOnCompleteListener(task -> {
                                    if (task.isSuccessful()) {
                                        Log.d("TAG", "User account deleted.");
                                    }
                                });
                        Toast.makeText(view.getContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
                        ((Activity)view.getContext()).finish();
                    }));
            alertDialogBuilder.setNegativeButton("No", (dialogInterface, i) -> Toast.makeText(view.getContext(), "Failed to delete user", Toast.LENGTH_SHORT).show());
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_student_registration_card,parent,false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, emailTextView, mobileNumberTextView, branchTextView;
        Button acceptButton, denyButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.id_student_registration_name);
            emailTextView = itemView.findViewById(R.id.id_student_registration_email);
            mobileNumberTextView = itemView.findViewById(R.id.id_student_registration_mobile_number);
            branchTextView = itemView.findViewById(R.id.id_student_registration_branch);
            acceptButton = itemView.findViewById(R.id.id_student_registration_accept);
            denyButton = itemView.findViewById(R.id.id_student_registration_deny);
        }
    }
}
