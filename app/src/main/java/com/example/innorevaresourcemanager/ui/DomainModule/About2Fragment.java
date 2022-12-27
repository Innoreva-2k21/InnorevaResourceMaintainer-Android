package com.example.innorevaresourcemanager.ui.DomainModule;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.innorevaresourcemanager.R;

import org.w3c.dom.Text;


public class About2Fragment extends Fragment {


    public About2Fragment() {
        // Required empty public constructor
    }



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_about2, container, false);

        Intent intent = getActivity().getIntent();
        String domain = intent.getStringExtra("domain");


        return view;
    }
}