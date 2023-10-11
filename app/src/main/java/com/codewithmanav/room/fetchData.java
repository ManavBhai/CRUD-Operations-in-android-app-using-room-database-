package com.codewithmanav.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import com.codewithmanav.room.database.userDao;
import com.codewithmanav.room.database.users;
import com.codewithmanav.room.database.usersDatabase;

import java.util.List;

public class fetchData extends AppCompatActivity {
    RecyclerView RV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);

        getRoomData();
    }
    public void getRoomData()
    {
        usersDatabase db = Room.databaseBuilder(getApplicationContext(),
                usersDatabase.class,"usersDB").allowMainThreadQueries().build();

        userDao userdao = db.getDao();
        RV = findViewById(R.id.recycle);
        RV.setLayoutManager(new LinearLayoutManager(this));

        List<users> users = userdao.getAllusers();
        adapter adapter = new adapter(users);
        RV.setAdapter(adapter);
    }
}