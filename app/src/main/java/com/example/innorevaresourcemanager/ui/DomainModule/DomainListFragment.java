package com.example.innorevaresourcemanager.ui.DomainModule;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.innorevaresourcemanager.MainActivity;
import com.example.innorevaresourcemanager.R;
import com.example.innorevaresourcemanager.ui.HomeModule.HomeFragment;

import java.util.ArrayList;

public class DomainListFragment extends Fragment {

     ListView list;
     ArrayList<String> arr = new ArrayList<>();

    public DomainListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_domain_list, container, false);

        arr.add("Internet Of Things");
        arr.add("Web Development");
        arr.add("Android Development");
        arr.add("Machine Learning");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,arr);
        list = view.findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0){
                    Intent intent = new Intent(getActivity(),DomainTabbedActivity.class);
                    intent.putExtra("domain","Internet Of Things");
                    intent.putExtra("bg",R.drawable.iot);
                    startActivity(intent);
                }
                else if(position==1){
                    Intent intent = new Intent(getActivity(),DomainTabbedActivity.class);
                    intent.putExtra("domain","Web Development");
                    intent.putExtra("bg",R.drawable.web);
                    startActivity(intent);
                }
                else if(position==2){
                    Intent intent = new Intent(getActivity(),DomainTabbedActivity.class);
                    intent.putExtra("domain","Android Development");
                    intent.putExtra("bg",R.drawable.app);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getActivity(),DomainTabbedActivity.class);
                    intent.putExtra("domain","Machine Learning");
                    intent.putExtra("bg",R.drawable.ml);
                    startActivity(intent);
                }
            }
        });


        return view;



    }
}