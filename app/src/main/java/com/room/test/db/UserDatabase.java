package com.room.test.db;

import android.content.Context;
import android.text.TextUtils;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.room.test.dao.TeamUserJoinDao;
import com.room.test.dao.UserDao;
import com.room.test.dao.TeamDao;
import com.room.test.model.UserModel;
import com.room.test.model.TeamModel;
import com.room.test.model.TeamUserJoinModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {
        TeamUserJoinModel.class,
        UserModel.class,
        TeamModel.class},
        version = 1, exportSchema = false)

public abstract class UserDatabase extends RoomDatabase {
    public abstract TeamDao userDao();

    public abstract UserDao cardDao();

    public abstract TeamUserJoinDao userCardJoinDao();

    public static volatile String USER_ID = "";
    private static volatile UserDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public static UserDatabase createDatabase(final Context context,String userId) {
        USER_ID = userId;
        return getDatabase(context);
    }

    public static UserDatabase getDatabase(final Context context) {
        if (TextUtils.isEmpty(USER_ID)){
            throw new IllegalStateException("使用数据库前必须先调用ApplicationViewModel定义数据库名字");
        }
        if (INSTANCE == null) {
            synchronized (UserDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserDatabase.class, "user_database_"+USER_ID)//数据库名
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 关闭数据库
     */
    public void closeDataBase(){
        if (null != INSTANCE){
            INSTANCE.close();
            INSTANCE = null;
            USER_ID = "";
        }
    }
}