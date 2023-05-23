package com.example.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.myViewHolder> {

    private Context context;
    private ArrayList<String> obj_id, obj_name, obj_price, objQuantity;
    private ArrayList<Boolean> objCheck;
    private Activity activity;

    public CustomAdapter(Activity activity,Context context, ArrayList<String> obj_id, ArrayList<String> obj_name, ArrayList<String> obj_price, ArrayList<String> objQuantity, ArrayList<Boolean> objCheck) {
        this.activity = activity;
        this.context = context;
        this.obj_id = obj_id;
        this.obj_name = obj_name;
        this.obj_price = obj_price;
        this.objQuantity = objQuantity;
        this.objCheck = objCheck;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_layout, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.obj_name_txt.setText(obj_name.get(position));
        holder.obj_price_txt.setText(obj_price.get(position) + " O.R");
        holder.obj_quantity_txt.setText(objQuantity.get(position));
        holder.obj_check_bool.setChecked(objCheck.get(position));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("id", String.valueOf(obj_id.get(position)));
                bundle.putString("name", String.valueOf(obj_name.get(position)));
                bundle.putString("price", String.valueOf(obj_price.get(position)));
                bundle.putString("quantity", String.valueOf(objQuantity.get(position)));
                Intent intent = new Intent(context, update.class);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return obj_id.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView obj_name_txt, obj_price_txt, obj_quantity_txt;
        CheckBox obj_check_bool;
        LinearLayout mainLayout;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            obj_name_txt = itemView.findViewById(R.id.obj_name_card);
            obj_price_txt = itemView.findViewById(R.id.obj_price_card);
            obj_quantity_txt = itemView.findViewById(R.id.obj_quantity_card);
            obj_check_bool = itemView.findViewById(R.id.checkBox);
            mainLayout = itemView.findViewById(R.id.row);
        }
    }
}
