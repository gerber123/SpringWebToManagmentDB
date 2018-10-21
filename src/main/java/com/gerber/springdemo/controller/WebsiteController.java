package com.gerber.springdemo.controller;

import com.gerber.springdemo.entity.User;
import com.gerber.springdemo.entity.Websites;
import com.gerber.springdemo.service.UserService;
import com.gerber.springdemo.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/website")
public class WebsiteController
{
    @Autowired
    WebsiteService websiteService;


    @Autowired
    UserService userService;

    @GetMapping("/list")
    public String websiteList(Model model)
    {
        userService.checkVoteEnabled();
        List<Websites> theWebsites= websiteService.getAllWebsites();
        model.addAttribute("websites",theWebsites);
        return "website-list";
    }
    @GetMapping("/showFormForRegister")
    public String showFormForRegister(Model model)
    {
        Websites website = new Websites();
        model.addAttribute("website",website);

        return "website-form";
    }
    @PostMapping("/saveWebsite")
    public String savePlayer(@ModelAttribute("website")@Valid Websites website, BindingResult bindingResult)
    {

        if(bindingResult.hasErrors())
        {
            return "website-form";
        }
        else
            {
            websiteService.saveWebsite(website);
            return "website-registration-confirmation";
            }

     }

    @GetMapping("voteForWebsite")
    public String voteForWebsite(@RequestParam("websiteId")int theId, Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        User user =userService.findByUserName(name);
        user.getLast_vote_date();


        Date dateOfLastVote =user.getLast_vote_date();
        Date todayDate= new Date();

        double LastTimeOfVote = Math.abs(dateOfLastVote.getTime() - todayDate.getTime());

        double TimeToNextVoteInHours = Math.ceil(LastTimeOfVote/3600000);

        System.out.println(TimeToNextVoteInHours+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        int TimeToNextVoteInMinutes = (int)(LastTimeOfVote-(3600000*(TimeToNextVoteInHours-1)));
        TimeToNextVoteInMinutes= TimeToNextVoteInMinutes/60000;
        int tempFullDayHours=24;
        int tempFullDayMinutes=60;
        int TillThisDayInHours = (int)(tempFullDayHours-TimeToNextVoteInHours);
        int TillThisDayInMinutes = tempFullDayMinutes-TimeToNextVoteInMinutes;
        if(TillThisDayInMinutes==60)
        {
            TillThisDayInHours+=1;
            TillThisDayInMinutes=0;
        }
        String StringTimeToNextVoteHours = TillThisDayInHours+"";
        String StringTimeToNextVoteMinutes = TillThisDayInMinutes+"";

        if(TillThisDayInMinutes<10)
        {
            StringTimeToNextVoteMinutes="0"+TillThisDayInMinutes;
        }

        model.addAttribute("TimeToNextVoteInHours",StringTimeToNextVoteHours);
        model.addAttribute("TimeToNextVoteInMinutes",StringTimeToNextVoteMinutes);

        if(user.getVoteEnable()==1)
        {
            websiteService.voteForWebsite(theId);
            userService.afterVoted(name);
            return "vote-success";
        }
        else
        {
            return "vote-denied";
        }
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("websiteId")int theId, Model model)
    {
        Websites website= websiteService.getWebsite(theId);
        model.addAttribute("website",website);
        return "website-form";
    }
    @GetMapping("deleteWebsite")
    public String deletePlayer(@RequestParam("websiteId")int theId)
    {
        websiteService.deleteWebsite(theId);

        return "redirect:/website/list";
    }
    @PostMapping("/search")
    public String search(@RequestParam("nameOfAuthor")String nameOfAuthor,Model model)
    {
        List<Websites> theWebsites= websiteService.findWebsite(nameOfAuthor);
        model.addAttribute("websites",theWebsites);

        return "website-list";
    }
    @GetMapping("/refresh")
    public String refresh()
    {
        return "redirect:/website/list";
    }
}
