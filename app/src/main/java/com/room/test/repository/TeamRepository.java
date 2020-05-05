package com.room.test.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.room.test.dao.TeamDao;
import com.room.test.db.UserDatabase;
import com.room.test.model.TeamModel;

import java.util.List;

public class TeamRepository {
    private TeamDao mTeamDao;
    private LiveData<List<TeamModel>> mAllUser;
    public TeamRepository(Application application) {
        UserDatabase db = UserDatabase.getDatabase(application);
        mTeamDao = db.userDao();
        mAllUser = mTeamDao.getAlphabetizedUser();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<TeamModel>> getAllUser() {
        return mAllUser;
    }

    public void insert(final TeamModel teamModel) {
        UserDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mTeamDao.insert(teamModel);
            }
        });
    }

    public void insert(final List<TeamModel> teamModel) {
        UserDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mTeamDao.insert(teamModel);
            }
        });
    }
}
