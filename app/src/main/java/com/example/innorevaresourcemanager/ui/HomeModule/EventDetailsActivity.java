package com.example.innorevaresourcemanager.ui.HomeModule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.innorevaresourcemanager.databinding.ActivityEventDetailsBinding;
import com.example.innorevaresourcemanager.ui.HomeModule.models.EventModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class EventDetailsActivity extends AppCompatActivity {
    ActivityEventDetailsBinding binding;
    FirebaseDatabase database;
    DatabaseReference eventRef;
    String id, title;
    EventModel eventModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        binding = ActivityEventDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Event Details");

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        title = intent.getStringExtra("title");

        database = FirebaseDatabase.getInstance();
        eventRef = database.getReference("Events").child(id);
        fetchEventData();

        binding.eventTitle.setText(title);
        binding.descTv.setText("l");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    void fetchEventData() {
        eventRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                eventModel = snapshot.getValue(EventModel.class);
                Glide.with(getApplicationContext()).load(eventModel.getImageUrl()).into(binding.eventImg);
                binding.descTv.setText(eventModel.getDescription());
                binding.eventVenueDetails.setText(eventModel.getVenue());
                binding.startsOnTv.setText(eventModel.getStartDate());
                binding.endsOnTv.setText(eventModel.getEndDate());
                binding.timeTv.setText(eventModel.getTime());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}