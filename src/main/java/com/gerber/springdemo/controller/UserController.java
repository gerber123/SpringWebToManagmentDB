package com.gerber.springdemo.controller;

import com.gerber.springdemo.entity.PlayerForTheExp;
import com.gerber.springdemo.entity.User;
import com.gerber.springdemo.service.PlayerService;
import com.gerber.springdemo.service.UserService;
import com.gerber.springdemo.service.UserServiceImpl;
import com.gerber.springdemo.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserService userService;
    @Autowired
    PlayerService playerService;

    @GetMapping("/list")
    public String playerList(Model model)
    {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        return "user-list";
    }

}
