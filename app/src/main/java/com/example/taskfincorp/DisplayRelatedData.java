package com.example.taskfincorp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DisplayRelatedData extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<User> list;

    DatabaseReference databaseReference;

    Button options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_related_data);


        options=findViewById(R.id.dots);


        recyclerView=findViewById(R.id.data_recy);

        databaseReference= FirebaseDatabase.getInstance().getReference("users");


        list=new ArrayList<>();



        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(DisplayRelatedData.this,DisplayingDetails.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();

            }
        });


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(DisplayRelatedData.this);
        recyclerView.setLayoutManager(layoutManager);
        CustomDataAdapter adapter=new CustomDataAdapter(DisplayRelatedData.this,list);
        recyclerView.setAdapter(adapter);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    User user=dataSnapshot.getValue(User.class);
                    list.add(user);
                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void clickDots(View view) {



            PopupMenu popupMenu = new PopupMenu(DisplayRelatedData.this, options);
            popupMenu.getMenuInflater().inflate(R.menu.abc, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {


                @Override
                public boolean onMenuItemClick(MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.sor_name:

                            Intent nameintent = new Intent(DisplayRelatedData.this, DisplayNames.class);
                            nameintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(nameintent);
                            finish();
                            popupMenu.dismiss();
                            break;

                        case R.id.sor_age:
                            Intent ageintent = new Intent(DisplayRelatedData.this, DisplayAge.class);
                            ageintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(ageintent);
                            finish();
                            popupMenu.dismiss();
                            break;
                        case R.id.sor_city:
                            Intent cityintent = new Intent(DisplayRelatedData.this, Displaycity.class);
                            cityintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(cityintent);
                            finish();
                            popupMenu.dismiss();
                            break;

                    }


                    return true;
                }
            });
            popupMenu.show();
        }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(DisplayRelatedData.this,DisplayingDetails.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();

    }
}
