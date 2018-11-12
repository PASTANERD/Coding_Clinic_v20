package com.example.a0xbistrot.codingcleanic_v20.ui.feed;

import com.example.a0xbistrot.codingcleanic_v20.R;

public class FeedItem {

    private int feed_user_pic;
    private String feed_user_id;
    private String feed_date;
    private int feed_content_pic;

    public FeedItem(String feed_date, int feed_content_pic) {
        this.feed_user_pic = R.drawable.ic_if_user;
        this.feed_user_id = "user19239";
        this.feed_date = feed_date;
        this.feed_content_pic = feed_content_pic;
    }

    public int getFeed_user_pic() {
        return feed_user_pic;
    }

    public void setFeed_user_pic(int feed_user_pic) {
        this.feed_user_pic = feed_user_pic;
    }

    public String getFeed_user_id() {
        return feed_user_id;
    }

    public void setFeed_user_id(String feed_user_id) {
        this.feed_user_id = feed_user_id;
    }

    public String getFeed_date() {
        return feed_date;
    }

    public void setFeed_date(String feed_date) {
        this.feed_date = feed_date;
    }

    public int getFeed_content_pic() {
        return feed_content_pic;
    }

    public void setFeed_content_pic(int feed_content_pic) {
        this.feed_content_pic = feed_content_pic;
    }
}
