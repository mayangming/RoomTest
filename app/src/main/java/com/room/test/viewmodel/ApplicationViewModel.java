package com.room.test.viewmodel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.room.test.db.UserDatabase;

/**
 * 这个类主要是用来做RoomDataBase的整体操作,比如创建、打开、关闭
 */
public class ApplicationViewModel extends AndroidViewModel {

    public ApplicationViewModel(@NonNull Application application) {
        super(application);
    }

    public void initRoomDataBase(String dataBaseName){
        UserDatabase.createDatabase(getApplication(),dataBaseName);
    }

    /**
     * 关闭数据库
     */
    public void closeRoomDataBase(){
        UserDatabase.getDatabase(getApplication()).closeDataBase();
    }

}