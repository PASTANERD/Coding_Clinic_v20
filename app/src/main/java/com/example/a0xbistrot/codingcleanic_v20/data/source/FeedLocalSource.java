package com.example.a0xbistrot.codingcleanic_v20.data.source;

import com.example.a0xbistrot.codingcleanic_v20.data.entity.Feed;
import com.example.a0xbistrot.codingcleanic_v20.db.AppDatabase;
import com.example.a0xbistrot.codingcleanic_v20.db.dao.FeedDao;

import java.util.Date;
import java.util.List;

public class FeedLocalSource {

    private AppDatabase appDatabase = AppDatabase.get();
    private FeedDao feedDao = appDatabase.feedDao();


    public List<Feed> getAll(){
        return feedDao.getAll();
    }


    public void insert(Feed feed) {
        Date date = new Date();
        feed.setCreate_date(date);
        feed.setUpdate_date(date);
        feedDao.insert(feed);
    }

}
