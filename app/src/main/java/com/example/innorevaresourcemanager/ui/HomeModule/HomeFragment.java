package com.example.innorevaresourcemanager.ui.HomeModule;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.innorevaresourcemanager.R;
import com.example.innorevaresourcemanager.databinding.FragmentHomeBinding;
import com.example.innorevaresourcemanager.ui.HomeModule.adapters.EventsAdapter;
import com.example.innorevaresourcemanager.ui.HomeModule.models.BannerDataModel;
import com.example.innorevaresourcemanager.ui.HomeModule.models.EventModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    EventsAdapter adapter;
    List<EventModel> eventModelList;
    List<BannerDataModel> bannerDataModelList;
    FirebaseDatabase database;
    DatabaseReference bannerRef, eventRef;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        eventModelList= new ArrayList<>();
        bannerDataModelList= new ArrayList<>();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        database = FirebaseDatabase.getInstance();
        bannerRef = database.getReference("Banner");
        eventRef = database.getReference("Events");

        //addEventData();

        fetchBannerData();
        fetchEventData();

        binding.searchTv.setOnClickListener(View -> new SearchBottomSheet(requireContext(),eventModelList).show());
        handleEventButtons();

    }

    private void setBanner() {
        List<SlideModel> imageList = new ArrayList<>();
        for(BannerDataModel banner : bannerDataModelList){
            imageList.add(new SlideModel(banner.getUrl(), banner.getTitle(), ScaleTypes.FIT));
        }
        binding.imageSlider.setImageList(imageList);
    }

    private void handleEventButtons() {
        binding.allBtn.setOnClickListener(View -> {
            clearAllSelections();
            binding.allBtn.setBackgroundColor(this.getResources().getColor(R.color.dark_blue));
        });
        binding.upcomingBtn.setOnClickListener(View -> {
            clearAllSelections();
            binding.upcomingBtn.setBackgroundColor(this.getResources().getColor(R.color.dark_blue));
        });
        binding.pastBtn.setOnClickListener(View -> {
            clearAllSelections();
            binding.pastBtn.setBackgroundColor(this.getResources().getColor(R.color.dark_blue));
        });
    }

    private void clearAllSelections() {
        binding.allBtn.setBackgroundColor(this.getResources().getColor(R.color.denim_blue));
        binding.upcomingBtn.setBackgroundColor(this.getResources().getColor(R.color.denim_blue));
        binding.pastBtn.setBackgroundColor(this.getResources().getColor(R.color.denim_blue));
    }

    void fetchBannerData(){
        bannerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    bannerDataModelList.add(dataSnapshot.getValue(BannerDataModel.class));
                }
                setBanner();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    void fetchEventData(){
        eventRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    eventModelList.add(dataSnapshot.getValue(EventModel.class));
                }
                binding.homePb.setVisibility(View.GONE);
                binding.eventsRv.setVisibility(View.VISIBLE);
                setUpRecyclerView();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void setUpRecyclerView() {
        adapter = new EventsAdapter(getContext(), eventModelList);

        binding.eventsRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.eventsRv.setAdapter(adapter);
    }

    void addEventData(){
        String key = getSaltString();
        eventRef.child(key).setValue(new EventModel(key,"","Innoreva Workshop","Welcome","LHC-305","04/02/2023","05-02-2023","2:30-4:00 PM",""));
    }

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}