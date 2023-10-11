package com.codewithmanav.room;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.codewithmanav.room.database.userDao;
import com.codewithmanav.room.database.users;
import com.codewithmanav.room.database.usersDatabase;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder>
{

    List<users> users;

    public adapter(List<users> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.idRef.setText(String.valueOf(users.get(position).getId()));
        holder.emailRef.setText(users.get(position).getEmail());
        holder.passRef.setText(users.get(position).getPassword());

        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersDatabase db = Room.databaseBuilder(holder.idRef.getContext(),
                        usersDatabase.class,"usersDB").allowMainThreadQueries().build();

                userDao userdao = db.getDao();
                //this will delete data from room database;
                userdao.delete(users.get(position).getId());
                // this will delete data from array list which is the source of recview data
                users.remove(position);
                // update the fresh list to recview
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView idRef,emailRef,passRef;
        ImageButton del;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            idRef = itemView.findViewById(R.id.idRef);
            emailRef = itemView.findViewById(R.id.emailRef);
            passRef = itemView.findViewById(R.id.passRef);
            del = itemView.findViewById(R.id.delete);
        }
    }
}
