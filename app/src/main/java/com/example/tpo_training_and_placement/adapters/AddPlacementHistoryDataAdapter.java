package com.example.tpo_training_and_placement.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.placementhistoryactivity.AddPlacementHistoryDataActivity;
import com.example.tpo_training_and_placement.models.AddPlacementHistoryDataModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddPlacementHistoryDataAdapter extends FirebaseRecyclerAdapter<AddPlacementHistoryDataModel,AddPlacementHistoryDataAdapter.ViewHolder> {

    public AddPlacementHistoryDataAdapter(@NonNull FirebaseRecyclerOptions<AddPlacementHistoryDataModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull AddPlacementHistoryDataModel model) {
        Glide.with(holder.studentImageImageView.getContext()).load(model.getStudentImage()).into(holder.studentImageImageView);
        holder.studentNameTextView.setText(model.getStudentName());
        holder.branchTextView.setText(model.getBranch());
        holder.studentImageImageView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), AddPlacementHistoryDataActivity.class);
            intent.putExtra("StudentImage",model.getStudentImage());
            intent.putExtra("StudentName", holder.studentNameTextView.getText().toString());
            intent.putExtra("Branch", holder.branchTextView.getText().toString());
            view.getContext().startActivity(intent);
        });
        holder.studentNameTextView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), AddPlacementHistoryDataActivity.class);
            intent.putExtra("StudentImage", model.getStudentImage());
            intent.putExtra("StudentName", holder.studentNameTextView.getText().toString());
            intent.putExtra("Branch", holder.branchTextView.getText().toString());
            view.getContext().startActivity(intent);
        });
        holder.branchTextView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), AddPlacementHistoryDataActivity.class);
            intent.putExtra("StudentImage", model.getStudentImage());
            intent.putExtra("StudentName", holder.studentNameTextView.getText().toString());
            intent.putExtra("Branch", holder.branchTextView.getText().toString());
            view.getContext().startActivity(intent);

        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_placement_history_student_card,parent,false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView studentImageImageView;
        TextView studentNameTextView, branchTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            studentImageImageView = itemView.findViewById(R.id.id_student_image_in_model_placement_history_student_card);
            studentNameTextView = itemView.findViewById(R.id.id_student_name_in_model_placement_history_student_card);
            branchTextView = itemView.findViewById(R.id.id_branch_in_model_placement_history_student_card);

        }
    }
}
