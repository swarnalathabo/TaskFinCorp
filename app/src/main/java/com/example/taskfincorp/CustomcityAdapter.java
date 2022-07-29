package com.example.taskfincorp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomcityAdapter extends RecyclerView.Adapter<CustomcityAdapter.ViewHolder> {
    Displaycity displaycity;
    ArrayList<User> list;
    public CustomcityAdapter(Displaycity displaycity, ArrayList<User> list) {
        this.displaycity=displaycity;
        this.list=list;
    }

    @NonNull
    @Override
    public CustomcityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(displaycity);
        View v=layoutInflater.inflate(R.layout.display_city,parent,false);
        ViewHolder holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomcityAdapter.ViewHolder holder, int position) {

        User user=list.get(position);
        holder.textcity.setText(user.getCity());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textcity;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textcity=itemView.findViewById(R.id.distxt_city);
        }
    }
}
