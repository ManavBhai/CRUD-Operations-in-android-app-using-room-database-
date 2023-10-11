package com.codewithmanav.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.codewithmanav.room.database.users;
import com.codewithmanav.room.database.usersDatabase;

public class login extends AppCompatActivity {
    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.log_email);
        passwordEditText = findViewById(R.id.log_password);
        loginButton = findViewById(R.id.login);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve email and password input
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Perform a search by email and password
                users user = usersDatabase.getDB(login.this)
                        .getDao().findUserByEmailAndPassword(email, password);

                if (user != null)
                {
                    startActivity(new Intent(getApplicationContext(),home.class));
                } else
                {
                    // Invalid login credentials, show an error message
                    Toast.makeText(login.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}