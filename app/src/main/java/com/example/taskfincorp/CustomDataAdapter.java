package com.example.taskfincorp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomDataAdapter extends RecyclerView.Adapter<CustomDataAdapter.viewHolder> {
    DisplayRelatedData displayRelatedData;
    ArrayList<User> list;

    public CustomDataAdapter(DisplayRelatedData displayRelatedData, ArrayList<User> list) {
        this.displayRelatedData = displayRelatedData;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(displayRelatedData);
        View v=layoutInflater.inflate(R.layout.display_details,parent,false);
        viewHolder holder=new viewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {


        User user=list.get(position);
        holder.dis_name.setText(user.getName());
        holder.dis_age.setText(user.getAge());
        holder.dis_city.setText(user.getCity());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView dis_name,dis_age,dis_city;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            dis_name=itemView.findViewById(R.id.txt_name);
            dis_age=itemView.findViewById(R.id.txt_age);
            dis_city=itemView.findViewById(R.id.txt_city);
        }
    }
}
