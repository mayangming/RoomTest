package com.room.test.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.room.test.dao.TeamUserJoinDao;
import com.room.test.db.UserDatabase;
import com.room.test.model.TeamUserJoinModel;
import com.room.test.model.UserModel;

import java.util.List;

public class TeamCardRepository {
    private TeamUserJoinDao uCardDao;
    private LiveData<List<UserModel>> mAllUser;
    public TeamCardRepository(Application application) {
        UserDatabase db = UserDatabase.getDatabase(application);
        uCardDao = db.userCardJoinDao();
    }


    public LiveData<List<UserModel>> getUserForTeam(String teamId) {
        return uCardDao.getAlphabetizedUser(teamId);
    }

    public void insert(final TeamUserJoinModel user) {
        UserDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                uCardDao.insert(user);
            }
        });
    }

}
