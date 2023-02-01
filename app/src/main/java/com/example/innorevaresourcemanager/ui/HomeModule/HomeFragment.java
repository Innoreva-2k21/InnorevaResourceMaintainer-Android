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
import com.example.innorevaresourcemanager.databinding.FragmentHomeBinding;
import com.example.innorevaresourcemanager.ui.HomeModule.adapters.EventsAdapter;
import com.example.innorevaresourcemanager.ui.HomeModule.models.UpcomingModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    EventsAdapter adapter;
    List<UpcomingModel> list;


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
        list= new ArrayList<>();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setBanner();

        list.add(new UpcomingModel("","Event1","event", "1"));
        list.add(new UpcomingModel("","Event1","event", "1"));
        list.add(new UpcomingModel("","Event1","event", "1"));
        list.add(new UpcomingModel("","Event1","event", "1"));
        list.add(new UpcomingModel("","Event1","event", "1"));
        list.add(new UpcomingModel("","Event1","event", "1"));

        adapter = new EventsAdapter(getContext(), list);

        binding.upcomingRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.upcomingRv.setAdapter(adapter);

    }

    private void setBanner() {
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel("https://bit.ly/2YoJ77H", "Title", ScaleTypes.FIT));
        imageList.add(new SlideModel("https://bit.ly/2BteuF2", "Title", ScaleTypes.FIT));
        imageList.add(new SlideModel("https://bit.ly/3fLJf72", "Title", ScaleTypes.FIT));
        binding.imageSlider.setImageList(imageList);
    }
}