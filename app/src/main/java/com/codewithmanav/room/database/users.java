package com.codewithmanav.room.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.*;
@Entity(tableName = "users")//this class is like creating a table.
public class users {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="user_email")
    private String email;

    @ColumnInfo(name="user_password")
    private String password;


    public users(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
