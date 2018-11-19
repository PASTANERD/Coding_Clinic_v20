package com.example.a0xbistrot.codingcleanic_v20.db.dao;


import com.example.a0xbistrot.codingcleanic_v20.data.entity.User;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user WHERE me = 1")
    User getMaster();

    @Query("SELECT * FROM user WHERE id = :userId")
    User getUser(long userId);

    @Insert
    void insert(User user);
}
