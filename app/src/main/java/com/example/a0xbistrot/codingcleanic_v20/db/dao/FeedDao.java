package com.example.a0xbistrot.codingcleanic_v20.db.dao;

import com.example.a0xbistrot.codingcleanic_v20.data.entity.Feed;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface FeedDao {

    @Query("SELECT * FROM feed ORDER BY update_date DESC")
    List<Feed> getAll();

    @Insert
    void insert(Feed feed);
}
