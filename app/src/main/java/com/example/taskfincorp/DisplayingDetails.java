package com.example.taskfincorp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DisplayingDetails extends AppCompatActivity {



    Button insert,display;
    EditText name,age,city;
    DatabaseReference databaseUsers;

    String username,userage,usercity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaying_details);


        insert=findViewById(R.id.insert_data);
        display=findViewById(R.id.display_data);

        name=findViewById(R.id.etx_name);
        age=findViewById(R.id.etx_age);
        city=findViewById(R.id.etx_city);

        username=name.getText().toString();
        userage=age.getText().toString();
        usercity=city.getText().toString();


        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(DisplayingDetails.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();

            }
        });

        databaseUsers= FirebaseDatabase.getInstance().getReference();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username=name.getText().toString();
                userage=age.getText().toString();
                usercity=city.getText().toString();

                if (username.length() > 0) {

                    if (userage.length() > 0) {
                        if(usercity.length()>0)
                        {
                            InsertData();
                        }else{
                            city.setError("enter city");
                        }


                    }
                    else{
                        age.setError("enter age");
                    }



                    }
                else{
                    name.setError("enter name");
                }



            }
        });


        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DisplayingDetails.this,DisplayRelatedData.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });


    }

    private void InsertData() {




        String id=databaseUsers.push().getKey();

        User user=new User(username,userage,usercity);
        databaseUsers.child("users").child(id).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful())
                {
                    name.setText("");
                    age.setText("");
                    city.setText("");
                    Toast.makeText(DisplayingDetails.this, "Details inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(DisplayingDetails.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }
}



