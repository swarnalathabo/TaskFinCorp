package com.example.taskfincorp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomNameAdapter extends RecyclerView.Adapter<CustomNameAdapter.ViewHolder> {
    DisplayNames displayNames;
    ArrayList<User> list;
    public CustomNameAdapter(DisplayNames displayNames, ArrayList<User> list) {
        this.displayNames=displayNames;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(displayNames);
        View v=layoutInflater.inflate(R.layout.display_names,parent,false);
        ViewHolder holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user=list.get(position);
        holder.textnames.setText(user.getName());

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textnames;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textnames=itemView.findViewById(R.id.distxt_name);
        }
    }
}
