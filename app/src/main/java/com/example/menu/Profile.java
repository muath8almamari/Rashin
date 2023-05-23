package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(R.anim.slid_right, R.anim.slid_left);
                    finish();
                    return true;
                case R.id.list:
                    startActivity(new Intent(getApplicationContext(), List.class));
                    overridePendingTransition(R.anim.slid_right, R.anim.slid_left);
                    finish();
                    return true;
                case R.id.profile:
                    return true;
                case R.id.map:
                    startActivity(new Intent(getApplicationContext(), Map.class));
                    overridePendingTransition(R.anim.slid_right, R.anim.slid_left);
                    finish();
                    return true;
            }
            return false;
        });
    }
}