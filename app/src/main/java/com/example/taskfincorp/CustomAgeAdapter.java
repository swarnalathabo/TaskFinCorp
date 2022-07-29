package com.example.taskfincorp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAgeAdapter extends RecyclerView.Adapter<CustomAgeAdapter.ViewHolder> {
    DisplayAge displayAge;
    ArrayList<User> list;
    public CustomAgeAdapter(DisplayAge displayAge, ArrayList<User> list) {
        this.displayAge=displayAge;
        this.list=list;
    }

    @NonNull
    @Override
    public CustomAgeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(displayAge);
        View v=layoutInflater.inflate(R.layout.display_ages,parent,false);
        ViewHolder holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAgeAdapter.ViewHolder holder, int position) {

        User user=list.get(position);
        holder.textage.setText(user.getAge());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textage=itemView.findViewById(R.id.distxt_age);
        }
    }
}
