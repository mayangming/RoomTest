package com.room.test.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.room.test.model.UserModel;
import com.room.test.repository.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel{
    private UserRepository mRepository;

    private LiveData<List<UserModel>> mAllUser;
    public UserViewModel(@NonNull Application application) {
        super(application);
        mRepository = new UserRepository(application);
        mAllUser = mRepository.getAllUser();
    }

    public LiveData<List<UserModel>> getAllUser() { return mAllUser; }

    public void insert(UserModel user) { mRepository.insert(user); }

    public void insert(List<UserModel> user) { mRepository.insert(user); }

}