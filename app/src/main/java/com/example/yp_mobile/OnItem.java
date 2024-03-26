package com.example.yp_mobile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.yp_mobile.databinding.ActivityOneItemScreenBinding;
import com.example.yp_mobile.databinding.ActivitySignInScreenBinding;

public class OnItem extends AppCompatActivity {
    private ActivityOneItemScreenBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOneItemScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        if (intent != null) {
            binding.Name.setText(intent.getStringExtra("name"));
            binding.Price.setText(intent.getStringExtra("price"));
            Glide.with(this).load(intent.getStringExtra("img")).into(binding.img);
        }
        binding.back.setOnClickListener(v -> {
            startActivity(new Intent(OnItem.this, MainScreen.class));
            finish();
        });
    }
}
