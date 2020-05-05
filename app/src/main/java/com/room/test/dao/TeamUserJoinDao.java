package com.room.test.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RoomWarnings;

import com.room.test.model.TeamModel;
import com.room.test.model.UserModel;
import com.room.test.model.TeamUserJoinModel;

import java.util.List;

@Dao
public interface TeamUserJoinDao {
    /**
     * 多对多的关系查询中，如果返回所有数据时候，会返回额外的字段(作为条件查询的字段)，这时候会出现警告，解决警告的方式有两种
     * 1、返回确定的字段
     * 2、采用注解，本例使用的该方式
     * 如果不是多对多的关系，那么可能是映射的字段写错了。
     */
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("SELECT * FROM user_table INNER JOIN team_user_join ON team_user_join.userId = user_table.userId WHERE team_user_join.teamId = :teamId")
    LiveData<List<UserModel>> getAlphabetizedUser(String teamId);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TeamUserJoinModel word);

    @Insert
    void insert(List<TeamUserJoinModel> playlistSongJoinList);

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("SELECT * FROM team_table " +
            "INNER JOIN team_user_join " +
            "ON team_table.teamId = team_user_join.teamId " +
            "WHERE team_user_join.userId = :userId")
    LiveData<List<TeamModel>> getTeamForUser(String userId);

}