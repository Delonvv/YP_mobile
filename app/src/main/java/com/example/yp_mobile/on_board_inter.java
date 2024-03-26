package com.example.yp_mobile;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


import com.example.yp_mobile.databinding.ActivityOnBoardingScreenBinding;
import com.google.firebase.auth.FirebaseAuth;
public class on_board_inter extends AppCompatActivity {

    private on_board_inter binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = on_board_inter.inflate(getLayoutInflater());
        setContentView(R.layout.on_boarding1);
    }

    int start_x = 0;
    int end_x = 0;
    @Override
    public  boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_UP:
                start_x = (int) event.getX();
                break;
            case MotionEvent.ACTION_DOWN:
                end_x = (int) event.getX();
                break;
        }
        if(start_x != 0 && end_x != 0)
        {

            if(start_x > end_x) setContentView((R.layout.on_boarding1));

            else if(start_x < end_x)
            {
                setContentView(R.layout.on_boarding2);
                Button sign_in = findViewById(R.id.signinbut);
                Button sign_up = findViewById(R.id.signupbut);
                TextView guest = findViewById(R.id.guest);
                if (isnetworkAv(getApplicationContext())) {
                    guest.setVisibility(View.GONE);

                } else {
                    guest.setVisibility(View.VISIBLE);
                }
                guest.setOnClickListener(v -> {
                    // Дописать startActivity(new Intent(on_board_inter.this,.class));
                });
                sign_in.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(on_board_inter.this,SignIn.class));
                    }
                });
                sign_up.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startActivity(new Intent(on_board_inter.this, SignUp.class));
                    }
                });

            }
            start_x = 0;
            end_x = 0;
        }
        return false;
    }

    public boolean isnetworkAv(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    private static on_board_inter inflate(LayoutInflater layoutInflater) {
    }
}
