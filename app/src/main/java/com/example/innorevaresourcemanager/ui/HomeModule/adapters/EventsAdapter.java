package com.example.innorevaresourcemanager.ui.HomeModule.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.innorevaresourcemanager.R;
import com.example.innorevaresourcemanager.ui.HomeModule.models.UpcomingModel;

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
        View view= LayoutInflater.from(context).inflate(R.layout.event_card_item,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapter.viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
