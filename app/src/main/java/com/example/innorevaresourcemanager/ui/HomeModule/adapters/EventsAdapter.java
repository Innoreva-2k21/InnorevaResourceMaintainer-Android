package com.example.innorevaresourcemanager.ui.HomeModule.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.innorevaresourcemanager.R;
import com.example.innorevaresourcemanager.ui.HomeModule.EventDetailsActivity;
import com.example.innorevaresourcemanager.ui.HomeModule.models.EventModel;
import com.google.android.material.button.MaterialButton;

import java.io.Serializable;
import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.viewHolder> {

    Context context;
    List<EventModel> eventModelList;

    public EventsAdapter(Context context, List<EventModel> eventModelList) {
        this.context = context;
        this.eventModelList = eventModelList;
    }

    @NonNull
    @Override
    public EventsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.event_card_item, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapter.viewHolder holder, int position) {
        setItemData(holder, position);
        holder.viewDetailsBtn.setOnClickListener(View -> viewDetails(position));
        holder.registerBtn.setOnClickListener(View -> registerForEvent(position));
    }

    @Override
    public int getItemCount() {
        return eventModelList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        MaterialButton viewDetailsBtn, registerBtn;
        TextView title, venue, date_time;
        ImageView eventImg;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            viewDetailsBtn = itemView.findViewById(R.id.view_details_btn);
            registerBtn = itemView.findViewById(R.id.register_btn);
            title = itemView.findViewById(R.id.event_title);
            venue = itemView.findViewById(R.id.event_venue);
            date_time = itemView.findViewById(R.id.event_date_time);
            eventImg = itemView.findViewById(R.id.event_img);
        }
    }

    private void viewDetails(int position) {
        Intent intent = new Intent(context, EventDetailsActivity.class);
        intent.putExtra("id", eventModelList.get(position).getId());
        intent.putExtra("title", eventModelList.get(position).getTitle());
        context.startActivity(intent);
    }

    private void registerForEvent(int position) {
        if (eventModelList.get(position).getRegistrationLink().isEmpty()) {
            Toast.makeText(context, "No registration link found!", Toast.LENGTH_SHORT).show();
        }
    }

    private void setItemData(viewHolder holder, int position) {
        holder.title.setText(eventModelList.get(position).getTitle());
        holder.venue.setText(eventModelList.get(position).getVenue());

        String dateTime = eventModelList.get(position).getStartDate() + " - " +
                eventModelList.get(position).getEndDate() + "  " +
                eventModelList.get(position).getTime();
        holder.date_time.setText(dateTime);
    }
}
