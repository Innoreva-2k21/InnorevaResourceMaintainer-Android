package com.example.innorevaresourcemanager.ui.HomeModule.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.innorevaresourcemanager.R;
import com.example.innorevaresourcemanager.ui.HomeModule.models.EventModel;

import java.util.List;

public class SearchItemAdapter extends RecyclerView.Adapter<SearchItemAdapter.ViewHolder> {
    Context context;
    List<EventModel> eventModelList;

    public SearchItemAdapter(Context context, List<EventModel> eventModelList) {
        this.context = context;
        this.eventModelList = eventModelList;
    }

    @NonNull
    @Override
    public SearchItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.search_event_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchItemAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return eventModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }

    }
}
