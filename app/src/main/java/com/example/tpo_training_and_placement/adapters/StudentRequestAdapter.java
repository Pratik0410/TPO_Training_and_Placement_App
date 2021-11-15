package com.example.tpo_training_and_placement.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.models.StudentRequestModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;

public class StudentRequestAdapter extends FirebaseRecyclerAdapter<StudentRequestModel, StudentRequestAdapter.ViewHolder> {

    public StudentRequestAdapter(@NonNull FirebaseRecyclerOptions<StudentRequestModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull StudentRequestModel studentRequestModel) {
        holder.nameTextView.setText(studentRequestModel.getName());
        holder.emailTextView.setText(studentRequestModel.getEmail());
        holder.mobileNumberTextView.setText(studentRequestModel.getMobileNumber());
        holder.branchTextView.setText(studentRequestModel.getBranch());
        /*Accept and Deny Code Remaining in which Admin will accept or deny Student's Request
        for registration*/
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
