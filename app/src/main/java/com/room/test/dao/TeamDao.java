package com.room.test.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.room.test.model.TeamModel;

import java.util.List;

@Dao
public interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TeamModel word);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<TeamModel> word);

    @Query("SELECT * from team_table ORDER BY teamId ASC")
    LiveData<List<TeamModel>> getAlphabetizedUser();

    @Update
    void update(TeamModel word);//这个会根据唯一主键进行修改

    @Query("UPDATE team_table SET teamName = :name WHERE teamId = :id")
    void updateForUserId(String id,String name);

    @Query("DELETE FROM team_table")
    void deleteAll();

    @Query("SELECT * from team_table WHERE teamId = :teamId")
    LiveData<TeamModel> getTeamByTeamId(String teamId);

}