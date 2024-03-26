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

    private ActivityOnBoardingScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardingScreenBinding.inflate(getLayoutInflater());
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
                Button sign_up = findViewById(R.id.signinbut);
                TextView goust = findViewById(R.id.guest);
                if (isNetworkAvailable(getApplicationContext())) {
                    goust.setVisibility(View.GONE);

                } else {
                    goust.setVisibility(View.VISIBLE);
                }
                goust.setOnClickListener(v -> {
                    startActivity(new Intent(on_board_inter.this,LaunchScreen.class));
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
    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
