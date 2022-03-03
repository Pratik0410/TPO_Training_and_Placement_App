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
import com.example.tpo_training_and_placement.activities.trainingactivity.EditTrainingDetailsActivity;
import com.example.tpo_training_and_placement.models.EditTrainingDetailsModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;


public class EditTrainingDetailsAdapter extends FirebaseRecyclerAdapter<EditTrainingDetailsModel, EditTrainingDetailsAdapter.ViewHolder> {


    public EditTrainingDetailsAdapter(@NonNull FirebaseRecyclerOptions<EditTrainingDetailsModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull EditTrainingDetailsModel model) {
        holder.companyNameTextView.setText(model.getCompanyName());
        holder.companyNameTextView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), EditTrainingDetailsActivity.class);
            intent.putExtra("CompanyName", holder.companyNameTextView.getText().toString());
            intent.putExtra("AboutCompany", model.getAboutCompany());
            intent.putExtra("ContentOfTraining", model.getContentOfTraining());
            intent.putExtra("EligibilityCriteria", model.getEligibilityCriteria());
            intent.putExtra("TrainingDuration", model.getTrainingDuration());
            intent.putExtra("TrainingCharges", model.getTrainingCharges());
            intent.putExtra("RegistrationDate", model.getRegistrationDate());
            intent.putExtra("lastDateOfRegistration", model.getLastDateOfRegistration());
            intent.putExtra("ContactDetails", model.getContactDetails());
            view.getContext().startActivity(intent);
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_edit_training_card, parent, false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView companyNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            companyNameTextView = itemView.findViewById(R.id.id_training_company_name);
        }
    }
}
