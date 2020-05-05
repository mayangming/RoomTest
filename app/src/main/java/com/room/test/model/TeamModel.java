package com.room.test.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;

@Entity(tableName = "team_table",primaryKeys = {"teamId" },indices = {@Index(value = "teamId",unique = true)})
public class TeamModel {

    @NonNull
    @ColumnInfo(name = "teamId")
    private String teamId = "2";//群ID

    @NonNull
    @ColumnInfo(name = "lordId")
    private String lordId = "";//群主Id

    @NonNull
    @ColumnInfo(name = "headPic")
    private String headPic = "";//群头像

    @NonNull
    @ColumnInfo(name = "teamName")
    private String teamName = "";//群名称

//    @NonNull
//    @ColumnInfo(name = "members")
//    private String members = "";//群成员列表，[1,2,3,4,5]

    @NonNull
    @ColumnInfo(name = "createTime")
    private String createTime = "";//创建时间

    @NonNull
    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(@NonNull String teamId) {
        this.teamId = teamId;
    }

    @NonNull
    public String getLordId() {
        return lordId;
    }

    public void setLordId(@NonNull String lordId) {
        this.lordId = lordId;
    }

    @NonNull
    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(@NonNull String headPic) {
        this.headPic = headPic;
    }

    @NonNull
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(@NonNull String teamName) {
        this.teamName = teamName;
    }

//    @NonNull
//    public String getMembers() {
//        return members;
//    }
//
//    public void setMembers(@NonNull String members) {
//        this.members = members;
//    }

    @NonNull
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(@NonNull String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TeamModel{" +
                " teamId='" + teamId + '\'' +
                ", lordId='" + lordId + '\'' +
                ", headPic='" + headPic + '\'' +
                ", teamName='" + teamName + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}