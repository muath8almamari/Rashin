package com.example.menu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update extends AppCompatActivity {
    EditText objName, objPrice, objQuantity;
    String id,name, price, quantity;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        objName = findViewById(R.id.obj_name_update);
        objPrice = findViewById(R.id.obj_price_update);
        objQuantity = findViewById(R.id.obj_quantity_update);
        update = findViewById(R.id.update);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelperList myDb = new DbHelperList(update.this);
                myDb.updateData(id, String.valueOf(objName.getText()), String.valueOf(objPrice.getText()),String.valueOf(objQuantity.getText()));
                System.out.println(id);

                Intent intent = new Intent(update.getContext(), List.class);
                startActivity(intent);


            }
        });
        getIntentData();
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }


    }

    void getIntentData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
             id = bundle.getString("id");
             name = bundle.getString("name");
            price = bundle.getString("price");
            quantity = bundle.getString("quantity");

            objName.setText(name);
            objPrice.setText(price);
            objQuantity.setText(quantity);
        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }



}