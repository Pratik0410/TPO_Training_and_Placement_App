package com.example.tpo_training_and_placement.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.placementopportunity.EditPlacementOpportunityActivity;
import com.example.tpo_training_and_placement.models.EditPlacementOpportunityModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class EditPlacementOpportunityAdapter extends FirebaseRecyclerAdapter<EditPlacementOpportunityModel, EditPlacementOpportunityAdapter.ViewHolder> {

    public EditPlacementOpportunityAdapter(@NonNull FirebaseRecyclerOptions<EditPlacementOpportunityModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull EditPlacementOpportunityModel model) {
        holder.companyNameTextView.setText(model.getCompanyName());
        holder.roleTextView.setText(model.getRole());
        holder.roleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), EditPlacementOpportunityActivity.class);
                i.putExtra("CompanyName", holder.companyNameTextView.getText().toString());
                i.putExtra("Role", holder.roleTextView.getText().toString());
                i.putExtra("Location", model.getLocation());
                i.putExtra("Summary", model.getSummary());
                i.putExtra("KeyQualification", model.getKeyQualification());
                i.putExtra("JobDescription", model.getJobDescription());
                i.putExtra("AdditionalRequirements", model.getAdditionalRequirements());
                i.putExtra("LinkForApplying", model.getLinkForApplying());
                view.getContext().startActivity(i);
            }
        });
        holder.companyNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), EditPlacementOpportunityActivity.class);
                i.putExtra("CompanyName", holder.companyNameTextView.getText().toString());
                i.putExtra("Role", holder.roleTextView.getText().toString());
                i.putExtra("Location", model.getLocation());
                i.putExtra("Summary", model.getSummary());
                i.putExtra("KeyQualification", model.getKeyQualification());
                i.putExtra("JobDescription", model.getJobDescription());
                i.putExtra("AdditionalRequirements", model.getAdditionalRequirements());
                i.putExtra("LinkForApplying", model.getLinkForApplying());
                view.getContext().startActivity(i);
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_edit_placement_opportunity, parent, false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView companyNameTextView, roleTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            companyNameTextView = itemView.findViewById(R.id.id_company_name_in_model_edit_placement_opportunity);
            roleTextView = itemView.findViewById(R.id.id_role_in_model_edit_placement_opportunity);
        }
    }
}
