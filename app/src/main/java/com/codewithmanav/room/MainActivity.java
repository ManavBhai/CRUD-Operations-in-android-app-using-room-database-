package com.codewithmanav.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codewithmanav.room.database.userDao;
import com.codewithmanav.room.database.users;
import com.codewithmanav.room.database.usersDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button signUp,fetchData,login,imageBtn;

    private usersDatabase usersDatabase;
    private userDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersDatabase=usersDatabase.getDB(MainActivity.this);
        userDao=usersDatabase.getDao();

        email= (EditText) findViewById(R.id.e_mail);
        password = (EditText) findViewById(R.id.password);
        signUp = (Button) findViewById(R.id.sign);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String e_mail = email.getText().toString();
                String pass = password.getText().toString();

                users users = new users(0,e_mail,pass);
                userDao.addTx(users);

                Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();

            }
        });

        fetchData = (Button) findViewById(R.id.fetch);
        fetchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),fetchData.class));
            }
        });

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });

        imageBtn = (Button) findViewById(R.id.image);
        imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),GetImage.class));
            }
        });

    }
}