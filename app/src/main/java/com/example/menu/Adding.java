package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adding extends AppCompatActivity {
    EditText objName, objPrice, objQuantity;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);

        objName = findViewById(R.id.obj_name);
        objPrice = findViewById(R.id.obj_price);
        objQuantity = findViewById(R.id.obj_quantity);
        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelperList myDB = new DbHelperList(Adding.this);
                long res= myDB.addBook(objName.getText().toString().trim(),
                        objPrice.getText().toString().trim(),
                        Integer.valueOf(objQuantity.getText().toString().trim()),false);

                if (res==0){
                    Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();;
                }
                else{
                    Toast.makeText(getApplicationContext(), "Added Successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}