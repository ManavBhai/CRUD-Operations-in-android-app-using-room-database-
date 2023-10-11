package com.codewithmanav.room.database;

import androidx.room.Dao;
    //import androidx.room.Delete;
    import androidx.room.Delete;
    import androidx.room.Insert;
    import androidx.room.Query;
    import androidx.room.Update;

    import java.util.List;

@Dao
public interface userDao {



    @Query("Select * from users")
    List<users> getAllusers();

    @Insert
    void addTx(users users);

    @Update
    void updateTx(users users);

    @Query("Delete from users where Id =:id")
    void delete(int id);

    @Query("SELECT * FROM users WHERE user_email = :email AND user_password = :password")
    users findUserByEmailAndPassword(String email, String password);
}
