package com.example.innorevaresourcemanager.ui.HomeModule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.innorevaresourcemanager.databinding.ActivityEventDetailsBinding;

import java.util.Objects;

public class EventDetailsActivity extends AppCompatActivity {
    ActivityEventDetailsBinding binding;
    String id, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        binding = ActivityEventDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Event Details");

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        title= intent.getStringExtra("title");

        binding.eventTitle.setText(title);
        binding.descTv.setText("Lorem ipsum dolor sit amet consectetur adipisicing elit.\\n\n" +
                "     Ducimus fugiat enim ratione.\\n \n" +
                "     Voluptates consequatur eveniet excepturi ad,\\n \n" +
                "     provident eum quae non ullam distinctio doloremque in, \\n \n" +
                "     quaerat tempora aut incidunt harum. \\n \\n\n" +
                "     Repudiandae deserunt cupiditate sequi voluptatum perspiciatis illum rem,\\n \n" +
                "      amet similique modi minima neque hic quidem quam placeat eaque repellendus?\\n \n" +
                "    Fugit aperiam laboriosam, rem necessitatibus amet quia in.\\n \\n\n" +
                "    Commodi sequi, modi iure nostrum atque est id aperiam adipisci\\n \n" +
                "     asperiores esse illum laborum maiores enim aut,\\n \n" +
                "      animi magni eveniet perferendis nesciunt aspernatur,\\n \n" +
                "       qui quibusdam amet magnam corporis eaque.\\n \\n\n" +
                "        Doloribus, facilis sapiente atque sequi nisi corporis debitis!\\n \n" +
                "         Aliquam voluptatum repellendus earum veniam quasi!\n" +
                "         Lorem ipsum dolor sit amet consectetur adipisicing elit.\\n \n" +
                "          Dicta quo at nisi et eos sunt totam eius voluptatibus ut? Quaerat.");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}