package com.room.test.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.room.test.model.UserModel;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(UserModel word);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<UserModel> word);

    @Query("SELECT * from user_table ORDER BY userId ASC")
    LiveData<List<UserModel>> getAlphabetizedUser();

    @Update
    void update(UserModel word);//这个会根据唯一主键进行修改

    @Query("UPDATE user_table SET userName = :name WHERE userId = :id")
    void updateForUserId(String id,String name);

    @Query("DELETE FROM user_table")
    void deleteAll();

    @Query("SELECT * from user_table WHERE userId = :userId")
    LiveData<UserModel> getUserByUserId(String userId);
}