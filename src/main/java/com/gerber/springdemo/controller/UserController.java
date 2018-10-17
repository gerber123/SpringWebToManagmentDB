package com.gerber.springdemo.controller;

import com.gerber.springdemo.entity.Role;
import com.gerber.springdemo.entity.User;
import com.gerber.springdemo.service.WebsiteService;
import com.gerber.springdemo.service.UserService;
import com.gerber.springdemo.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserService userService;


    private Map<String, String> rolesOption;

    @PostConstruct
    protected void loadRoles() {
        // using hashmap, could also read this info from a database
        rolesOption = new LinkedHashMap<String, String>();
        // key=the role, value=display to user
        rolesOption.put("ROLE_EMPLOYEE", "Employee");
        rolesOption.put("ROLE_MANAGER", "Manager");
        rolesOption.put("ROLE_ADMIN", "Admin");
    }

    @GetMapping("/list")
    public String playerList(Model model)
    {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        return "user-list";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId")long id, Model model)
    {
//        User user= userService.findByUserName(userName);
        User user = userService.getUser(id);
        model.addAttribute("rolesOption",rolesOption);
        model.addAttribute("User",user);


        return "user-edit";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("User")@Valid User user, BindingResult bindingResult)
    {

        if(bindingResult.hasErrors())
        {
            return "user-edit";
        }
        else
        {
            userService.saveUser(user);
            return "redirect:/user/list";
        }

    }
    @PostMapping("/search")
    public String search(@RequestParam("nameOfUser")String nameOfUser,Model model)
    {
        List<User> user= userService.findByUserNameFinder(nameOfUser);
        model.addAttribute("users",user);

        return "user-list";
    }
    @GetMapping("/refresh")
    public String refresh()
    {
        return "redirect:/website/list";
    }

    @GetMapping("deleteUser")
    public String deleteUser(@RequestParam("userId")long theId)
    {
        userService.deleteUser(theId);

        return "redirect:/user/list";
    }
}
