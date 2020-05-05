package com.room.test.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.room.test.dao.UserDao;
import com.room.test.db.UserDatabase;
import com.room.test.model.UserModel;

import java.util.List;

public class UserRepository {
    private UserDao uUserDao;
    private LiveData<List<UserModel>> mAllUser;
    public UserRepository(Application application) {
        UserDatabase db = UserDatabase.getDatabase(application);
        uUserDao = db.cardDao();
        mAllUser = uUserDao.getAlphabetizedUser();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<UserModel>> getAllUser() {
        return mAllUser;
    }


    public void insert(final UserModel user) {
        UserDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                uUserDao.insert(user);
            }
        });
    }

    public void insert(final List<UserModel> user) {
        UserDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                uUserDao.insert(user);
            }
        });
    }
}
