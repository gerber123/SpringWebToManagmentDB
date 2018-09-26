package com.gerber.springdemo.controller;

import com.gerber.springdemo.entity.PlayerForTheExp;
import com.gerber.springdemo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController
{
    @Autowired
    PlayerService playerService;

    @GetMapping("/list")
    public String playerList(Model model)
    {
        List<PlayerForTheExp> playerfortheexp= playerService.getAllPlayers();
        model.addAttribute("players",playerfortheexp);
        return "player-list";
    }
    @GetMapping("/showFormForRegister")
    public String showFormForRegister(Model model)
    {
        PlayerForTheExp player = new PlayerForTheExp();
        model.addAttribute("player",player);

        return "player-form";
    }
    @GetMapping("/showFormForRegisterVIP")
    public String showFormForRegisterVIP(Model model)
    {
        PlayerForTheExp player = new PlayerForTheExp();
        model.addAttribute("player",player);

        return "player-form-vip";
    }

    @PostMapping("/savePlayer")
    public String savePlayer(@ModelAttribute("player")@Valid PlayerForTheExp player, BindingResult bindingResult)
    {

        if(bindingResult.hasErrors())
        {
            return "player-form";
        }
        else
            {
                player.setStatus("Normal");
            playerService.savePlayer(player);
            return "redirect:/player/list";
            }

        }

     @PostMapping("/savePlayerVip")
        public String savePlayerVip(@ModelAttribute("player")@Valid PlayerForTheExp player, BindingResult bindingResult)
        {
            if(bindingResult.hasErrors())
            {
                return "player-form-vip";
            }
            else
                {
                player.setStatus("VIP");
                playerService.savePlayer(player);
                return "redirect:/player/list";
            }
        }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("playerId")int theId, Model model)
    {
        PlayerForTheExp player=playerService.getPlayer(theId);
        model.addAttribute("player",player);
        return "player-form";
    }
    @GetMapping("/deletePlayer")
    public String deletePlayer(@RequestParam("playerId")int theId)
    {
        playerService.deletePlayer(theId);

        return "redirect:/player/list";
    }
    @PostMapping("/search")
    public String search(@RequestParam("nameOfPlayer")String nameOfPlayerm,Model model)
    {
        List<PlayerForTheExp> playersForTheExp=playerService.findPlayers(nameOfPlayerm);
        model.addAttribute("players",playersForTheExp);

        return "player-list";
    }
    @GetMapping("/refresh")
    public String refresh()
    {
        return "redirect:/player/list";
    }
}
