package com.example.yp_mobile.boottomNav.MenuFragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.yp_mobile.Connection;
import com.example.yp_mobile.boottomNav.Menu.MenuAdapter;
import com.example.yp_mobile.boottomNav.Menu.MenuClass;
import com.example.yp_mobile.boottomNav.SelectedItem.SelectedItemAdapter;
import com.example.yp_mobile.boottomNav.SelectedItem.SelectedItemClass;
import com.example.yp_mobile.databinding.FragmentSauceBinding;

import java.util.ArrayList;

public class SauceFragment extends Fragment implements MenuAdapter.OnMenoClickListener, SelectedItemAdapter.OnFoodClickListener{
    private FragmentSauceBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSauceBinding.inflate(inflater, container, false);
        loadItem();
        return binding.getRoot();
    }
    public void loadItem(){
        ArrayList<MenuClass> sauce = new ArrayList<>();
        Connection dbHelper = new Connection(getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM sauce", null);

        if (cursor.moveToFirst()) {
            do {
                int ni =cursor.getColumnIndex("name");
                int pi =cursor.getColumnIndex("price");
                int ii =cursor.getColumnIndex("img");
                String name = cursor.getString(ni);
                String price = cursor.getString(pi);
                String img = cursor.getString(ii);
                sauce.add(new MenuClass(name,price,img));
            } while (cursor.moveToNext());
            cursor.close();

            // Set up the RecyclerView
            binding.snacksList.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
            binding.snacksList.setAdapter(new MenuAdapter(sauce,this));
        } else {
            // Handle case when there are no rows in the cursor
        }
    }
    @Override
    public void onMenuClick(MenuClass food) {
        ArrayList<SelectedItemClass> sic = new ArrayList<>();
        sic.add(new SelectedItemClass(food.name, food.price, food.img));

        binding.snacksList.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        binding.snacksList.setAdapter(new SelectedItemAdapter(sic,this));
    }

    @Override
    public void onItemClicked() {
        loadItem();
    }
}
