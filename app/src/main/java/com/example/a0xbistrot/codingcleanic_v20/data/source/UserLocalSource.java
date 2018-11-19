package com.example.a0xbistrot.codingcleanic_v20.data.source;


import com.example.a0xbistrot.codingcleanic_v20.data.entity.User;
import com.example.a0xbistrot.codingcleanic_v20.db.AppDatabase;
import com.example.a0xbistrot.codingcleanic_v20.db.dao.UserDao;

import java.util.Date;
import java.util.List;

public class UserLocalSource {

    private AppDatabase appDatabase = AppDatabase.get();
    private UserDao userDao = appDatabase.userDao();


    public User getMaster(){
        return userDao.getMaster();
    }

    public User getUser(long user_id){
        return userDao.getUser(user_id);
    }

    public void insert(User user) {
        Date date = new Date();
        user.setCreate_date(date);
        user.setUpdate_date(date);
        userDao.insert(user);
    }
}
