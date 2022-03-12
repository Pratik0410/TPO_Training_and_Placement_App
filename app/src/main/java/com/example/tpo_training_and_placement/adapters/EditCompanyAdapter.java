package com.example.tpo_training_and_placement.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.activities.companyactivity.EditExistingCompanyActivity;
import com.example.tpo_training_and_placement.models.EditCompanyModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class EditCompanyAdapter extends FirebaseRecyclerAdapter<EditCompanyModel,EditCompanyAdapter.ViewHolder> {


    public EditCompanyAdapter(@NonNull FirebaseRecyclerOptions<EditCompanyModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull EditCompanyModel model) {
            holder.companyNameTextView.setText(model.getCompanyName());
            holder.companyNameTextView.setOnClickListener(view -> {
                Intent intent = new Intent(view.getContext(), EditExistingCompanyActivity.class);
                intent.putExtra("Company Name",holder.companyNameTextView.getText().toString());
                intent.putExtra("Type of Company", model.getTypeofCompany());
                intent.putExtra("Product or Service of Company", model.getProductorServiceofCompany());
                intent.putExtra("About Company", model.getAboutCompany());
                intent.putExtra("Contact Details", model.getContactDetails());
                intent.putExtra("Company Logo", model.getCompanyLogo());

                view.getContext().startActivity(intent);
            });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_company_registration_card,parent,false);
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
