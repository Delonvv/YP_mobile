package com.example.yp_mobile.boottomNav.Menu;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yp_01.R;

public class MenuViewHolder extends RecyclerView.ViewHolder{
    TextView name;
    TextView price;
    ImageView img;
    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.Name);
        price = itemView.findViewById(R.id.Price);
        img = itemView.findViewById(R.id.imge);
    }
}
