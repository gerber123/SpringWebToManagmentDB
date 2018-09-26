package com.gerber.springdemo.service;

import com.gerber.springdemo.dao.PlayerDAO;
import com.gerber.springdemo.entity.PlayerForTheExp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService
{
    @Autowired
    PlayerDAO playerDAO;

    @Transactional
    public List<PlayerForTheExp> getAllPlayers() {
        return playerDAO.getAllPlayers();
    }

    @Transactional
    public void savePlayer(PlayerForTheExp playerForTheExp) {
        playerDAO.savePlayer(playerForTheExp);
    }

    @Transactional
    public PlayerForTheExp getPlayer(int theId) {
        return playerDAO.getPlayer(theId);
    }
    @Transactional
    public void deletePlayer(int theId) {
        playerDAO.deletePlayer(theId);
    }
    @Transactional
    public List<PlayerForTheExp> findPlayers(String nameOfPlayer) {
        return playerDAO.findPlayers(nameOfPlayer);
    }
}
