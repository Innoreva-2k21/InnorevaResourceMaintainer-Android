package com.example.innorevaresourcemanager.ui.DomainModule;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;


import com.example.innorevaresourcemanager.R;
import com.google.android.material.tabs.TabLayout;

public class DomainTabbedActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    ImageView bgimg;
    TextView title;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domain_tabbed);


        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);
        title = findViewById(R.id.toolbar1_title);
        bgimg = findViewById(R.id.bg_img);

        ViewPagerDomainAdapter adapter = new ViewPagerDomainAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);



        Intent intent = getIntent();
        String domain = intent.getStringExtra("domain");
        int bg = intent.getIntExtra("bg",R.drawable.web);
        bgimg.setImageResource(bg);
        title.setText(domain);




    }


}