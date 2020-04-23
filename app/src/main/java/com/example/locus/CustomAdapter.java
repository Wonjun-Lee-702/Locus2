package com.example.locus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private ArrayList<Location> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<Location> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tv_name.setText(arrayList.get(position).getName());
        holder.tv_sensor1.setText(String.valueOf(arrayList.get(position).getSensor1()));
        //holder.tv_sensor2.setText(String.valueOf(arrayList.get(position).getSensor2()));
        //holder.tv_sensor3.setText(String.valueOf(arrayList.get(position).getSensor3()));
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_sensor1;
        //TextView tv_sensor2;
        //TextView tv_sensor3;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_name = itemView.findViewById(R.id.tv_name);
            this.tv_sensor1 = itemView.findViewById(R.id.tv_sensor1);
            //this.tv_sensor2 = itemView.findViewById(R.id.tv_sensor2);
            //this.tv_sensor3 = itemView.findViewById(R.id.tv_sensor3);
        }
    }
}
