package com.example.innorevaresourcemanager.ui.HomeModule.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.innorevaresourcemanager.R;
import com.example.innorevaresourcemanager.ui.HomeModule.models.EventModel;

import java.util.List;

public class SearchItemAdapter extends RecyclerView.Adapter<SearchItemAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(EventModel eventModel);
    }

    Context context;
    List<EventModel> eventModelList;
    private OnItemClickListener listener;

    public SearchItemAdapter(Context context, List<EventModel> eventModelList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.eventModelList = eventModelList;
        this.listener = onItemClickListener;
    }

    @NonNull
    @Override
    public SearchItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_event_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchItemAdapter.ViewHolder holder, int position) {
        holder.title.setText(eventModelList.get(position).getTitle());
        holder.itemView.setOnClickListener(view -> listener.onItemClick(eventModelList.get(position)));
    }

    @Override
    public int getItemCount() {
        return eventModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.search_event_title);
        }

    }
}
