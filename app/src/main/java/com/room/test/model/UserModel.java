package com.room.test.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;

/**
 * 卡片
 */
@Entity(tableName = "user_table",primaryKeys = {"userId" },indices = {@Index(value = "userId",unique = true)})
public class UserModel {
    @NonNull
    @ColumnInfo(name = "userId")
    private String userId = "1";
    @NonNull
    @ColumnInfo(name = "userName",defaultValue = "")
    private String userName = "";

    @NonNull
    @ColumnInfo(name = "sex",defaultValue = "('Created at' || CURRENT_TIMESTAMP)")
    private String sex = "0";//0 男 1 女

    @NonNull
    @ColumnInfo(name = "headPic")
    private String headPic = "";//头像

    @NonNull
    @ColumnInfo(name = "friendStatus")
    private String friendStatus = "";//好友状态，是不是好友

    @Ignore //该字段会被忽略不会添加进数据库
    private boolean isCheck = false;//是否被选择

    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    @NonNull
    public String getSex() {
        return sex;
    }

    public void setSex(@NonNull String sex) {
        this.sex = sex;
    }

    @NonNull
    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(@NonNull String headPic) {
        this.headPic = headPic;
    }

    @NonNull
    public String getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(@NonNull String friendStatus) {
        this.friendStatus = friendStatus;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", headPic='" + headPic + '\'' +
                ", friendStatus='" + friendStatus + '\'' +
                '}';
    }
}