package com.room.test.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

/**
 * 多对多关系中，需要使用索引，为了避免警告，同时也是为了提高查询效率
 */

@Entity(tableName = "team_user_join",
        primaryKeys = { "teamId","userId"},
        foreignKeys = {@ForeignKey(entity = TeamModel.class,
                parentColumns = "teamId",
                childColumns = "teamId"),
                @ForeignKey(entity = UserModel.class,
                        parentColumns = "userId",
                        childColumns = "userId")
        },indices = {@Index(value = "teamId",unique = true),@Index(value = "userId",unique = true)})
public class TeamUserJoinModel {
    @ColumnInfo(name = "teamId")
    @NonNull
    private String teamId;

    @ColumnInfo(name = "userId")
    @NonNull
    private String userId = "";

    @NonNull
    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(@NonNull String teamId) {
        this.teamId = teamId;
    }

    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }
}