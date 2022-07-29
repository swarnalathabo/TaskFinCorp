package com.example.taskfincorp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText name,password;
    Button login;

    String user_name,user_pass;




    private static final Pattern password_pattern=Pattern.compile("^"+
            "(?=.*[0-9])"+
            "(?=.*[a-z])"+
            "(?=.*[A-Z])"+
           // "(?=.*[a-zA-z])"+
            "(?=.*[@#$%^&+=])"+
            "(?=\\S+$)"+
            ".{7,}"+
            "$");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.etx_usr);
        password=findViewById(R.id.etx_pwd);
        login=findViewById(R.id.btn_lgn);


        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,ExitActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();

            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_name=name.getText().toString().trim();
                user_pass=password.getText().toString().trim();

                if(user_name.length()>0&&user_name.length()>=10)
                {

                    if(user_pass.isEmpty())
                    {
                        password.setError("please enter password");

                    }

                    else if(!password_pattern.matcher(user_pass).matches())
                    {


                        password.setError("password too weak");

                    }
                    else{

                        name.setText("");
                        password.setText("");
                        Intent intent=new Intent(MainActivity.this, DisplayingDetails.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        finish();
                    }
                }
                else{
                    name.setError("please enter username");


                }

            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(MainActivity.this,ExitActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }
}
