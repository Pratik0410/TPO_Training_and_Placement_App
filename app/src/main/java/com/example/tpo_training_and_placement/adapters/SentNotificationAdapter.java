package com.example.tpo_training_and_placement.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpo_training_and_placement.R;
import com.example.tpo_training_and_placement.models.SentNotificationModel;
import com.example.tpo_training_and_placement.models.SentNotificationModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class SentNotificationAdapter extends FirebaseRecyclerAdapter<SentNotificationModel,SentNotificationAdapter.ViewHolder> {

    public SentNotificationAdapter(@NonNull FirebaseRecyclerOptions<SentNotificationModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull SentNotificationModel model) {
        holder.dateTextView.setText(model.getDateString());
        holder.noticeTextView.setText(model.getNoticeString());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_sent_notification,parent,false);
        return new ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView dateTextView, noticeTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTextView = (TextView) itemView.findViewById(R.id.id_notification_date);
            noticeTextView = (TextView) itemView.findViewById(R.id.id_notice);
        }
    }

}
