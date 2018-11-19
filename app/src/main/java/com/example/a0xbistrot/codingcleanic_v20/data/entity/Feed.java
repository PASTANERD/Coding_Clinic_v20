package com.example.a0xbistrot.codingcleanic_v20.data.entity;

import com.example.a0xbistrot.codingcleanic_v20.data.source.UserLocalSource;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(
        entity = User.class,
        parentColumns = "id",
        childColumns = "user_id"))
public class Feed {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "user_id")
    @SerializedName("user_id")
    private int user_id;

    @ColumnInfo(name = "image_url")
    private String imgUrl;

    private String text;

    @ColumnInfo(name = "like_count")
    @SerializedName("like_count")
    private int likeCount;

    @ColumnInfo(name = "reply_count")
    @SerializedName("reply_count")
    private int replyCount;

    @ColumnInfo(name = "create_date")
    @SerializedName("create_date")
    private Date create_date;

    @ColumnInfo(name = "update_date")
    @SerializedName("update_date")
    private Date update_date;

    //Cache
    @Ignore
    @Expose
    private User user;

    public Feed(int user_id, String imgUrl, String text) {
        this.user_id = user_id;
        this.imgUrl = imgUrl;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date created_date) {
        this.create_date = created_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public synchronized User getUser() {
        if (user == null) user = new UserLocalSource().getUser(user_id);
        return user;
    }

}
