package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
    DbHelperList dbList;
    TextView price,quant;
    ArrayList<String> obj_id, obj_name, obj_price, obj_quantity;
    ArrayList<Boolean> obj_Check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        price = findViewById(R.id.price);
        quant = findViewById(R.id.quant);




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

        // Initialize the ArrayLists
        obj_id = new ArrayList<>();
        obj_name = new ArrayList<>();
        obj_price = new ArrayList<>();
        obj_quantity = new ArrayList<>();
        obj_Check = new ArrayList<>();

        // Instantiate your database helper class
        dbList = new DbHelperList(this);

        fetchDataFromDatabase();

        // Calculate the total price
        double totalPrice = calculateTotalPrice();

        // Set the total price in the TextView
        price.setText(String.valueOf(totalPrice));
        quant.setText(String.valueOf(obj_id.size()));


    }

    void fetchDataFromDatabase() {
        Cursor cursor = dbList.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                obj_id.add(cursor.getString(0));
                obj_name.add(cursor.getString(1));
                obj_price.add(cursor.getString(2));
                obj_quantity.add(cursor.getString(3));
                obj_Check.add(cursor.getInt(4) == 1);
            }
        }
        cursor.close(); // Close the cursor to release resources
    }

    double calculateTotalPrice() {
        double total = 0.0;
        for (String price : obj_price) {
            total += Double.parseDouble(price);
        }
        return total;
    }

}
