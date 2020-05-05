package com.room.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.room.test.model.TeamUserJoinModel;
import com.room.test.model.UserModel;
import com.room.test.model.TeamModel;
import com.room.test.viewmodel.ApplicationViewModel;
import com.room.test.viewmodel.UserViewModel;
import com.room.test.viewmodel.TeamCardViewModel;
import com.room.test.viewmodel.TeamViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private View addUser;
    private View queryUser;
    private View addCard;
    private View queryCard;
    private View bindUser;
    private View queryCardForUser;
    private TeamViewModel teamViewModel;
    private UserViewModel userViewModel;
    private TeamCardViewModel teamCardViewModel;
    private ApplicationViewModel applicationViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewModel();
    }

    private void initView(){
        addUser = findViewById(R.id.add_user);
        queryUser = findViewById(R.id.query_user);
        addCard = findViewById(R.id.add_card);
        queryCard = findViewById(R.id.query_card);
        bindUser = findViewById(R.id.bind_user);
        queryCardForUser = findViewById(R.id.query_user_card);
        addUser.setOnClickListener(this);
        queryUser.setOnClickListener(this);
        addCard.setOnClickListener(this);
        queryCard.setOnClickListener(this);
        bindUser.setOnClickListener(this);
        queryCardForUser.setOnClickListener(this);
    }

    private void initViewModel(){
        applicationViewModel = new ViewModelProvider(this).get(ApplicationViewModel.class);
        applicationViewModel.initRoomDataBase("test");


        teamViewModel = new ViewModelProvider(this).get(TeamViewModel.class);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        teamCardViewModel = new ViewModelProvider(this).get(TeamCardViewModel.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_user:
                teamViewModel.insert(createUser());
                break;
            case R.id.query_user:
                teamViewModel.getAllUser().observe(this, users -> {
                    for (TeamModel teamModel : users){
                        Log.e("YM","群组数据:"+ teamModel.toString());
                    }
                });
                break;
            case R.id.add_card:
                userViewModel.insert(createCard());
                break;
            case R.id.query_card:
                userViewModel.getAllUser().observe(this, new Observer<List<UserModel>>() {
                    @Override
                    public void onChanged(List<UserModel> userModels) {
                        for (UserModel user : userModels){
                            Log.e("YM","用户数据:"+user.toString());
                        }
                    }
                });
                break;
            case R.id.bind_user:
                teamCardViewModel.insert(bindUserCard());
                teamCardViewModel.insert(bindUserCard2());
                break;
            case R.id.query_user_card:
                queryUserForTeam();
                break;
        }
    }

    private void queryUserForTeam(){
        teamCardViewModel.getUserForTeam("10").observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> userModels) {
                for (UserModel user : userModels){
                    Log.e("YM","群组10的卡片数据:"+user.toString());
                }
            }
        });
    }

    private List<TeamModel> createUser(){
        List<TeamModel> teamModels = new ArrayList<>();
        TeamModel teamModel1 = new TeamModel();
        teamModel1.setTeamId("10");
        teamModel1.setTeamName("张三");
        TeamModel teamModel2 = new TeamModel();
        teamModel2.setTeamId("11");
        teamModel2.setTeamName("李四");
        teamModels.add(teamModel1);
        teamModels.add(teamModel2);
        return teamModels;
    }
    private List<UserModel> createCard(){
        List<UserModel> users = new ArrayList<>();
        UserModel user1 = new UserModel();
        user1.setUserId("01");
        UserModel user2 = new UserModel();
        user2.setUserId("02");
        UserModel user3 = new UserModel();
        user3.setUserId("03");
        UserModel user4 = new UserModel();
        user4.setUserId("04");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        return users;
    }

    private TeamUserJoinModel bindUserCard(){
        TeamUserJoinModel teamUserJoinModel = new TeamUserJoinModel();
        teamUserJoinModel.setTeamId("10");
        teamUserJoinModel.setUserId("03");
        return teamUserJoinModel;
    }
    private TeamUserJoinModel bindUserCard2(){
        TeamUserJoinModel teamUserJoinModel = new TeamUserJoinModel();
        teamUserJoinModel.setTeamId("10");
        teamUserJoinModel.setUserId("04");
        return teamUserJoinModel;
    }

}
