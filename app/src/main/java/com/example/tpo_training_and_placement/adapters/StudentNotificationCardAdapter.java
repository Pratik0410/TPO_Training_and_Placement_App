package com.example.tpo_training_and_placement.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.models.StudentNotificationCardModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class StudentNotificationCardAdapter extends FirebaseRecyclerAdapter<StudentNotificationCardModel,StudentNotificationCardAdapter.ViewHolder> {

    public StudentNotificationCardAdapter(@NonNull FirebaseRecyclerOptions<StudentNotificationCardModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull StudentNotificationCardAdapter.ViewHolder holder, int position, @NonNull StudentNotificationCardModel model) {
        holder.nameTextView.setText(model.getName());
        holder.branchTextView.setText(model.getBranch());
    }

    @NonNull
    @Override
    public StudentNotificationCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_current_company_registrarion_card,parent,false);
        return new ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView, branchTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.id_student_name);
            branchTextView = (TextView) itemView.findViewById(R.id.id_student_branch);
        }
    }
}
