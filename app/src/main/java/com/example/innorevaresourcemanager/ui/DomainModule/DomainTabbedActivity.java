package com.example.innorevaresourcemanager.ui.DomainModule;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;


import com.example.innorevaresourcemanager.R;
import com.google.android.material.tabs.TabLayout;

public class DomainTabbedActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    Toolbar bar;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domain_tabbed);


        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);
        bar = findViewById(R.id.toolbar1);
        title = findViewById(R.id.toolbar1_title);

        ViewPagerDomainAdapter adapter = new ViewPagerDomainAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);

        bar.setTitle("");
        setSupportActionBar(bar);

        Intent intent = getIntent();
        String domain = intent.getStringExtra("domain");
        title.setText(domain);




    }


}