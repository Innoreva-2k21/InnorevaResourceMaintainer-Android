package com.example.innorevaresourcemanager.ui.webDevModule;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.innorevaresourcemanager.databinding.FragmentWebDevBinding;
import com.example.innorevaresourcemanager.ui.DomainModule.ViewPagerDomainAdapter;

public class WebDevFragment extends Fragment {
    FragmentWebDevBinding binding;
    ViewPagerDomainAdapter adapter;

    public WebDevFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentWebDevBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter= new ViewPagerDomainAdapter(getChildFragmentManager());
        binding.viewPager.setAdapter(adapter);
        binding.tab.setupWithViewPager(binding.viewPager);
    }
}