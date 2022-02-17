package com.example.tpo_training_and_placement.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.placementopportunity.EditPlacementOpportunityActivity;
import com.example.tpo_training_and_placement.models.EditPlacementOpportunityModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class EditPlacementOpportunityAdapter extends FirebaseRecyclerAdapter<EditPlacementOpportunityModel, EditPlacementOpportunityAdapter.ViewHolder> {

    public EditPlacementOpportunityAdapter(@NonNull FirebaseRecyclerOptions<EditPlacementOpportunityModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull EditPlacementOpportunityModel model) {
        holder.companyNameTextView.setText(model.getCompanyName());
        holder.roleTextView.setText(model.getRole());
        Picasso.get().load(model.getCompanyLogo()).into(holder.companyLogoImageView);
        holder.companyLogoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EditPlacementOpportunityActivity.class);
                intent.putExtra("CompanyName", holder.companyNameTextView.getText().toString());
                intent.putExtra("Role", holder.roleTextView.getText().toString());
                intent.putExtra("Location", model.getLocation());
                intent.putExtra("Summary", model.getSummary());
                intent.putExtra("KeyQualification", model.getKeyQualification());
                intent.putExtra("JobDescription", model.getJobDescription());
                intent.putExtra("AdditionalRequirements", model.getAdditionalRequirements());
                intent.putExtra("LinkForApplying", model.getLinkForApplying());
                view.getContext().startActivity(intent);
            }
        });
        holder.roleTextView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), EditPlacementOpportunityActivity.class);
            intent.putExtra("CompanyName", holder.companyNameTextView.getText().toString());
            intent.putExtra("Role", holder.roleTextView.getText().toString());
            intent.putExtra("Location", model.getLocation());
            intent.putExtra("Summary", model.getSummary());
            intent.putExtra("KeyQualification", model.getKeyQualification());
            intent.putExtra("JobDescription", model.getJobDescription());
            intent.putExtra("AdditionalRequirements", model.getAdditionalRequirements());
            intent.putExtra("LinkForApplying", model.getLinkForApplying());
            view.getContext().startActivity(intent);
        });
        holder.companyNameTextView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), EditPlacementOpportunityActivity.class);
            intent.putExtra("CompanyName", holder.companyNameTextView.getText().toString());
            intent.putExtra("Role", holder.roleTextView.getText().toString());
            intent.putExtra("Location", model.getLocation());
            intent.putExtra("Summary", model.getSummary());
            intent.putExtra("KeyQualification", model.getKeyQualification());
            intent.putExtra("JobDescription", model.getJobDescription());
            intent.putExtra("AdditionalRequirements", model.getAdditionalRequirements());
            intent.putExtra("LinkForApplying", model.getLinkForApplying());
            view.getContext().startActivity(intent);
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
        ImageView companyLogoImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            companyNameTextView = itemView.findViewById(R.id.id_company_name_in_model_edit_placement_opportunity);
            roleTextView = itemView.findViewById(R.id.id_role_in_model_edit_placement_opportunity);
            companyLogoImageView = itemView.findViewById(R.id.id_company_image_in_model_edit_placement_opportunity);
        }
    }
}
