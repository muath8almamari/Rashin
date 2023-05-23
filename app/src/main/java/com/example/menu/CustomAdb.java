//package com.example.menu;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class CustomAdb extends RecyclerView.Adapter<CustomAdb.MyViewHolder> {
//
//    Context context;
//    ArrayList<String> obj_id, obj_name, obj_price, objQuantity;
//
//    public CustomAdb(Context context, ArrayList<String> obj_id, ArrayList<String> obj_name, ArrayList<String> obj_price, ArrayList<String> objQuantity) {
//        this.context = context;
//        this.obj_id = obj_id;
//        this.obj_name = obj_name;
//        this.obj_price = obj_price;
//        this.objQuantity = objQuantity;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.list_layout,parent,false);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.obj_name_txt.setText(String.valueOf(obj_name.get(position)));
//        holder.obj_price_txt.setText(String.valueOf(obj_price.get(position)));
//        holder.obj_quantity_txt.setText(String.valueOf(objQuantity.get(position)));
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return obj_id.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView obj_id_txt, obj_name_txt, obj_price_txt,obj_quantity_txt;
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            obj_name_txt = itemView.findViewById(R.id.obj_name_card);
//            obj_name_txt = itemView.findViewById(R.id.obj_price_card);
//            obj_name_txt = itemView.findViewById(R.id.obj_quantity_card);
//
//
//
//
//        }
//    }
//}
