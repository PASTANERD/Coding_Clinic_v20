package com.example.a0xbistrot.codingcleanic_v20.data.entity;

import com.google.gson.annotations.SerializedName;


import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = Feed.class,
                parentColumns = "id",
                childColumns = "feed_id",
                onDelete = CASCADE),
        @ForeignKey(
                entity = User.class,
                parentColumns = "id",
                childColumns = "user_id")
})
public class Reply {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "feed_id")
    @SerializedName("feed_id")
    private long feed_id;

    @ColumnInfo(name = "user_id")
    @SerializedName("user_id")
    private long user_id;

    private String text;

    @ColumnInfo(name = "created_date")
    @SerializedName("created_date")
    private Date created_date;

    @ColumnInfo(name = "update_date")
    @SerializedName("update_date")
    private Date update_date;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFeed_id() {
        return feed_id;
    }

    public void setFeed_id(long feed_id) {
        this.feed_id = feed_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }


    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }


}
