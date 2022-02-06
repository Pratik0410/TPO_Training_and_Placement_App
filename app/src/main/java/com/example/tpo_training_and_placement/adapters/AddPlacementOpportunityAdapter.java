package com.example.tpo_training_and_placement.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.placementopportunity.AddPlacementOpportunityActivity;
import com.example.tpo_training_and_placement.models.AddPlacementOpportunityModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AddPlacementOpportunityAdapter extends FirebaseRecyclerAdapter<AddPlacementOpportunityModel, AddPlacementOpportunityAdapter.ViewHolder> {

    public AddPlacementOpportunityAdapter(@NonNull FirebaseRecyclerOptions<AddPlacementOpportunityModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull AddPlacementOpportunityModel model) {
        holder.companyNameTextView.setText(model.getCompanyName());
        holder.companyNameTextView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), AddPlacementOpportunityActivity.class);
            intent.putExtra("Company Name",model.getCompanyName());
            view.getContext().startActivity(intent);
        });
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), AddPlacementOpportunityActivity.class);
            intent.putExtra("Company Name",model.getCompanyName());
            view.getContext().startActivity(intent);
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_select_company_card,parent,false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView companyNameTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            companyNameTextView = itemView.findViewById(R.id.id_register_company_name);
        }
    }
}
