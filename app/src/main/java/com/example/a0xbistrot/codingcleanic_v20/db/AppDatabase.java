package com.example.a0xbistrot.codingcleanic_v20.db;

import com.example.a0xbistrot.codingcleanic_v20.data.entity.Feed;
import com.example.a0xbistrot.codingcleanic_v20.data.entity.Like;
import com.example.a0xbistrot.codingcleanic_v20.data.entity.Reply;
import com.example.a0xbistrot.codingcleanic_v20.data.entity.User;
import com.example.a0xbistrot.codingcleanic_v20.db.dao.FeedDao;
import com.example.a0xbistrot.codingcleanic_v20.db.dao.UserDao;
import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseApplication;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Feed.class,
        Like.class,
        Reply.class,
        User.class}, version = 1)
@TypeConverters(DateTypeConverter.class)
// Database에는 primitive type 밖에 저장이 안된다.
// 그래서 날짜에 대해 long으로 convert하는 코드가 필요함.
public abstract class AppDatabase extends RoomDatabase {

    public abstract FeedDao feedDao();
    public abstract UserDao userDao();

    private static AppDatabase instance;

    public static synchronized AppDatabase get() {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    BaseApplication.getInstance(), AppDatabase.class, "app_database")
                    .fallbackToDestructiveMigration() // Migration을 하지 않고 매번 데이터베이스 스키마를 새로 생성함
                    .build();
        }

        return instance;
    }
}
