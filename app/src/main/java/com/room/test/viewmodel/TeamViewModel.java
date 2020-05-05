package com.room.test.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.room.test.model.TeamModel;
import com.room.test.repository.TeamRepository;

import java.util.List;

public class TeamViewModel extends AndroidViewModel{
    private TeamRepository mRepository;

    private LiveData<List<TeamModel>> mAllUser;
    public TeamViewModel(@NonNull Application application) {
        super(application);
        mRepository = new TeamRepository(application);
        mAllUser = mRepository.getAllUser();
    }

    public LiveData<List<TeamModel>> getAllUser() { return mAllUser; }

    public void insert(TeamModel teamModel) { mRepository.insert(teamModel); }

    public void insert(List<TeamModel> teamModel) { mRepository.insert(teamModel); }

}