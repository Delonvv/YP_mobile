package com.example.yp_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.example.yp_mobile.databinding.MainScreenBinding;
import com.example.yp_mobile.main_elements.MainFragment;
public class MainScreen extends AppCompatActivity  {
    private MainScreen binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainScreen.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(binding.fragment_container.getId(),new HomeFragment()).commit();
        binding.bottom_nav.setSelectedItemId(R.id.home);
        Map<Integer, Fragment> fragmentMap = new HashMap<>();
        fragmentMap.put(R.id.home,new HomeFragment());
        binding.bottomNav.setOnItemSelectedListener(item -> {
            Fragment fragment = fragmentMap.get(item.getItemId());
            getSupportFragmentManager().beginTransaction().replace(binding.fragmentContainer.getId(), fragment).commit();

            return true;
        });
    }

    private static MainScreen inflate(LayoutInflater layoutInflater) {
    }
}
