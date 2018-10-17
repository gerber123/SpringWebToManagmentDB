package com.gerber.springdemo.service;

import com.gerber.springdemo.entity.User;
import com.gerber.springdemo.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService
{
    public List<User> getAllUsers();

    User findByUserName(String userName);
    List<User>  findByUserNameFinder(String userName);

    void save(CrmUser crmUser);
    void saveUser(User user);

    User getUser(long theId);

    void deleteUser(long theId);


    void afterVoted(String name);

    void checkVoteEnabled();
}
