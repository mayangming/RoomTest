package com.room.test.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.room.test.model.TeamUserJoinModel;
import com.room.test.model.UserModel;
import com.room.test.repository.TeamCardRepository;

import java.util.List;

public class TeamCardViewModel extends AndroidViewModel{
    private TeamCardRepository mRepository;

    public TeamCardViewModel(@NonNull Application application) {
        super(application);
        mRepository = new TeamCardRepository(application);
    }

    public LiveData<List<UserModel>> getUserForTeam(String teamId) {
        return mRepository.getUserForTeam(teamId);
    }

    public void insert(TeamUserJoinModel user) { mRepository.insert(user); }

}