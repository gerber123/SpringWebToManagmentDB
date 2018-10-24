package com.gerber.springdemo.controller;

import com.gerber.springdemo.entity.Email;
import com.gerber.springdemo.entity.User;
import com.gerber.springdemo.entity.Websites;
import com.gerber.springdemo.service.EmailService;
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
    EmailService emailService;


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

    @GetMapping("/user-detail")
    public String getUserProfile(@RequestParam("websiteId")int theId,Model model)
    {
        Websites webSite = websiteService.getWebsite(theId);
        String userName =webSite.getUser().getUserName();
        User user = userService.findByUserName(userName);

        int placeOfRanking = websiteService.getPlaceOfRanking(user.getUserName());
        Websites website = user.getWebsites();
        model.addAttribute("user",user);
        model.addAttribute("website",website);
        model.addAttribute("placeOfRanking",placeOfRanking);

        return "fronter-profil";

    }

    @RequestMapping("/showFormForEmail")
    public String showFormForEmail (@RequestParam("websiteId")int theId,Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User userWriter = userService.findByUserName(name);


        Websites webSite = websiteService.getWebsite(theId);
        String userName =webSite.getUser().getUserName();
        User userReceiver = userService.findByUserName(userName);
        Email email = new Email();
        model.addAttribute("userWriter",userWriter);
        model.addAttribute("userReceiver",userReceiver);
        model.addAttribute("email",email);

        return "email-form";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@ModelAttribute("email") Email email, BindingResult bindingResult,Model model)
    {
            emailService.sendSimpleMessage(email.getReciverEmail(), email.getThemeEmail(), "Email From: " + email.getAuthorName() + " \n\n " + email.getTextEmail() + "! \n Never Forget to Test Your Front!");
            return "sending-email";

        }
    @GetMapping("/successSendEmail")
    public String successSendEmail()
    {
        return "successSendEmail";
    }
    @GetMapping("/showFormForRegister")
    public String showFormForRegister(Model model)
    {


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        model.addAttribute("user",user);
        if(user.getWebsites()==null) {
            Websites website = new Websites();
            model.addAttribute("website", website);
            return "website-form";
        }
        else
        {
            return "website-exist-denied";
        }
    }

    @PostMapping("/saveWebsite")
    public String savePlayer(@ModelAttribute("website")@Valid Websites website, BindingResult bindingResult)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUserName(name);
        String emailOfUser =user.getEmail();


        if(bindingResult.hasErrors())
        {
            return "website-form";
        }
        else
            {
            websiteService.saveWebsite(website);
            emailService.sendSimpleMessage(emailOfUser,"Witaj w konkursie","Witaj "+user.getFirstName()+" "+user.getLastName()+ "! \n Miło nam że zarejstrowałeś się do konkursu, życzymy powodzenia i pamiętaj! \n Never Forget to Test Your Front!");
            return "website-registration-confirmation";
            }

     }
    @GetMapping("/voteForWebsite")
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
    @GetMapping("deleteWebsiteByOwner")
    public String deleteWebsiteByOwner()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        User user =userService.findByUserName(name);
        Websites webSiteOwner = user.getWebsites();

        websiteService.deleteWebsite(webSiteOwner.getId());

        return "redirect:/website/showFormForRegister";
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
