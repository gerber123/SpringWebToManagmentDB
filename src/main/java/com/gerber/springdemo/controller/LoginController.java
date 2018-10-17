package com.gerber.springdemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+name);

        return "login-page";

    }

    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";

    }
    @GetMapping("/homepage")
    public String homePage()
    {
        return "home-page";
    }
    @GetMapping("/preload")
    public String preload()
    {
        return "Preload";
    }
}
