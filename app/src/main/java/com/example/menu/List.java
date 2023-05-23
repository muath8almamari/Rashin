package com.example.menu;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class List extends AppCompatActivity {
    FloatingActionButton add;
    RecyclerView list;
    DbHelperList dbList;
    ArrayList<String> obj_id, obj_name, obj_price, obj_quantity;
    ArrayList<Boolean> obj_Check;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = findViewById(R.id.recyclerView);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.list);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(R.anim.slid_right, R.anim.slid_left);
                    finish();
                    return true;
                case R.id.list:
                    return true;
                case R.id.profile:
                    startActivity(new Intent(getApplicationContext(), Profile.class));
                    overridePendingTransition(R.anim.slid_right, R.anim.slid_left);
                    finish();
                    return true;
                case R.id.map:
                    startActivity(new Intent(getApplicationContext(), Map.class));
                    overridePendingTransition(R.anim.slid_right, R.anim.slid_left);
                    finish();
                    return true;
            }
            return false;
        });

        add = findViewById(R.id.add_floating);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List.this, Adding.class);
                Intent[] intentArray = {intent};
                startActivities(intentArray);
                System.out.println("button clicked");
            }
        });

        dbList = new DbHelperList(List.this);
        obj_id = new ArrayList<>();
        obj_name = new ArrayList<>();
        obj_price = new ArrayList<>();
        obj_quantity = new ArrayList<>();
        obj_Check = new ArrayList<>();

        customAdapter = new CustomAdapter(List.this,this, obj_id, obj_name, obj_price, obj_quantity, obj_Check);
        list.setAdapter(customAdapter);
        list.setLayoutManager(new LinearLayoutManager(List.this));

        fetchDataFromDatabase();
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
            customAdapter.notifyDataSetChanged();
        }
    }
}
