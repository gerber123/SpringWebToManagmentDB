package com.gerber.springdemo.service;

import com.gerber.springdemo.entity.PlayerForTheExp;

import java.util.List;

public interface PlayerService
{
    public List<PlayerForTheExp> getAllPlayers();

    void savePlayer(PlayerForTheExp playerForTheExp);

    PlayerForTheExp getPlayer(int theId);

    void deletePlayer(int theId);

    List<PlayerForTheExp> findPlayers(String nameOfPlayerm);
}
