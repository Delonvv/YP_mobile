package com.example.yp_mobile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.yp_mobile.databinding.MainScreenBinding;
import com.example.yp_mobile.boottomNav.HomeFragment;


import com.example.yp_mobile.databinding.MainScreenBinding;

import java.util.HashMap;
import java.util.Map;

public class MainScreen extends AppCompatActivity  {
    private MainScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(binding.fragmentContainer.getId(),new HomeFragment()).commit();
        binding.bottomNav.setSelectedItemId(R.id.home);
        Map<Integer, Fragment> fragmentMap = new HashMap<>();
        fragmentMap.put(R.id.home,new HomeFragment());
        binding.bottomNav.setOnItemSelectedListener(item -> {
            Fragment fragment = fragmentMap.get(item.getItemId());
            getSupportFragmentManager().beginTransaction().replace(binding.fragmentContainer.getId(), fragment).commit();

            return true;
        });
    }
}
