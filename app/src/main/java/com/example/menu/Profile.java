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

//        // Assuming you have an instance of your database helper class
//        DbHelperList dbHelper = new DbHelperList(context);
//
//// Call the readAllData() method to retrieve the cursor
//        Cursor cursor = dbHelper.readAllData();
//
//// Iterate over the cursor to access the retrieved data
//        if (cursor != null && cursor.moveToFirst()) {
//            do {
//                // Extract data from the cursor based on column indices
//                int id = cursor.getInt(cursor.getColumnIndex("id"));
//                String name = cursor.getString(cursor.getColumnIndex("name"));
//                int price = cursor.getInt(cursor.getColumnIndex("price"));
//
//                // Do something with the retrieved data
//                // ...
//
//            } while (cursor.moveToNext());
//        }
//
//// Close the cursor to release resources
//        if (cursor != null) {
//            cursor.close();
//        }
//
//    }
}