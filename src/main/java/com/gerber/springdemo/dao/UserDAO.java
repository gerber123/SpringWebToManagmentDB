package com.gerber.springdemo.dao;

import com.gerber.springdemo.entity.PlayerForTheExp;
import com.gerber.springdemo.entity.User;
import com.gerber.springdemo.user.CrmUser;

import java.util.List;

public interface UserDAO
{

    public List<User> getAllUsers();

    User findByUserName(String userName);

    void save(User user);



}
