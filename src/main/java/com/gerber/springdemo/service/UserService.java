package com.gerber.springdemo.service;

import com.gerber.springdemo.entity.PlayerForTheExp;
import com.gerber.springdemo.entity.User;
import com.gerber.springdemo.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService
{
    public List<User> getAllUsers();

    User findByUserName(String userName);

    void save(CrmUser crmUser);


}
