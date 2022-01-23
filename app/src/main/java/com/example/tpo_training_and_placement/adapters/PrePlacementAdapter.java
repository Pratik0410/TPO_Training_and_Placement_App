package com.example.tpo_training_and_placement.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.models.PrePlacementModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.textview.MaterialTextView;

public class PrePlacementAdapter extends FirebaseRecyclerAdapter<PrePlacementModel,PrePlacementAdapter.ViewHolder> {

    public PrePlacementAdapter(@NonNull FirebaseRecyclerOptions<PrePlacementModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull PrePlacementModel model) {
        holder.companyNameMaterialTextView.setText(String.format("Company Name : %s", model.getCompanyName()));
        holder.detailsMaterialTextView.setText(String.format("Details : %s", model.getDetails()));
        holder.linkMaterialTextView.setText(String.format("Link : %s", model.getLink()));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_pre_placement_talks,parent,false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        MaterialTextView companyNameMaterialTextView, detailsMaterialTextView,linkMaterialTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            companyNameMaterialTextView = itemView.findViewById(R.id.id_company_name_text_view_in_model_pre_placement_talks);
            detailsMaterialTextView = itemView.findViewById(R.id.id_details_text_view_in_model_pre_placement_talks);
            linkMaterialTextView = itemView.findViewById(R.id.id_link_for_pre_placement_talk_text_view_in_model_pre_placement_talks);
        }
    }
}
