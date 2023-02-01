package com.example.innorevaresourcemanager.ui.HomeModule.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.innorevaresourcemanager.MainActivity;
import com.example.innorevaresourcemanager.R;
import com.example.innorevaresourcemanager.ui.HomeModule.EventDetailsActivity;
import com.example.innorevaresourcemanager.ui.HomeModule.models.UpcomingModel;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.viewHolder> {

    Context context;
    List<UpcomingModel> list;

    public EventsAdapter(Context context, List<UpcomingModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EventsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.event_card_item, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapter.viewHolder holder, int position) {
        holder.viewDetailsBtn.setOnClickListener(View -> viewDetails(position));
        holder.registerBtn.setOnClickListener(View -> registerForEvent(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        MaterialButton viewDetailsBtn, registerBtn;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            viewDetailsBtn = itemView.findViewById(R.id.view_details_btn);
            registerBtn = itemView.findViewById(R.id.register_btn);
        }
    }

    private void viewDetails(int position) {
        Intent intent = new Intent(context, EventDetailsActivity.class);
        intent.putExtra("data", position);
        context.startActivity(intent);
    }

    private void registerForEvent(int position) {
        Toast.makeText(context, "No registration link found!", Toast.LENGTH_SHORT).show();
    }

}
