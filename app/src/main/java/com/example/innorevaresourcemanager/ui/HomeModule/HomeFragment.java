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
import com.example.innorevaresourcemanager.ui.HomeModule.models.EventModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    EventsAdapter adapter;
    List<EventModel> eventModelList;


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

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setBanner();

        eventModelList.add(new EventModel("1","","Innoreva Workshop","Welcome","LHC-305","04/02/2023","05-02-2023","2:30-4:00 PM",""));
        eventModelList.add(new EventModel("1","","Innoreva Workshop","Welcome","LHC-305","04/02/2023","05-02-2023","2:30-4:00 PM",""));
        eventModelList.add(new EventModel("1","","Innoreva Workshop","Welcome","LHC-305","04/02/2023","05-02-2023","2:30-4:00 PM",""));
        eventModelList.add(new EventModel("1","","Innoreva Workshop","Welcome","LHC-305","04/02/2023","05-02-2023","2:30-4:00 PM",""));
        eventModelList.add(new EventModel("1","","Innoreva Workshop","Welcome","LHC-305","04/02/2023","05-02-2023","2:30-4:00 PM",""));
        eventModelList.add(new EventModel("1","","Innoreva Workshop","Welcome","LHC-305","04/02/2023","05-02-2023","2:30-4:00 PM",""));

        adapter = new EventsAdapter(getContext(), eventModelList);

        binding.upcomingRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.upcomingRv.setAdapter(adapter);

        binding.searchTv.setOnClickListener(View -> new SearchBottomSheet(requireContext(),eventModelList).show());
        handleEventButtons();

    }

    private void setBanner() {
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel("https://bit.ly/2YoJ77H", "Title", ScaleTypes.FIT));
        imageList.add(new SlideModel("https://bit.ly/2BteuF2", "Title", ScaleTypes.FIT));
        imageList.add(new SlideModel("https://bit.ly/3fLJf72", "Title", ScaleTypes.FIT));
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
}