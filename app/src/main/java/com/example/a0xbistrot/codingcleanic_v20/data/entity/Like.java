package com.example.a0xbistrot.codingcleanic_v20.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Like {

    private long id;

    @SerializedName("feed_id")
    private long feed_id;

    private User user;

    @SerializedName("created_date")
    private Date created_date;

    @SerializedName("upload_date")
    private Date upload_date;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(Date upload_date) {
        this.upload_date = upload_date;
    }
}
