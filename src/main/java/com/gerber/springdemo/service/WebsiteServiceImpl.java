package com.gerber.springdemo.service;

import com.gerber.springdemo.dao.WebsiteDAO;
import com.gerber.springdemo.entity.Websites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WebsiteServiceImpl implements WebsiteService
{
    @Autowired
    WebsiteDAO websiteDAO;

    @Transactional
    public List<Websites> getAllWebsites() {
        return websiteDAO.getAllWebsites();
    }

    @Transactional
    public void saveWebsite(Websites websites) {
        websiteDAO.saveWebsite(websites);
    }

    @Transactional
    public Websites getWebsite(int theId) {
        return websiteDAO.getWebsite(theId);
    }
    @Transactional
    public void deleteWebsite(int theId) {
        websiteDAO.deleteWebsite(theId);
    }
    @Transactional
    public List<Websites> findWebsite(String nameOfAuthor) {
        return websiteDAO.findWebsite(nameOfAuthor);
    }

    @Override
    @Transactional
    public void voteForWebsite(int theId) {
        websiteDAO.voteForWebsite(theId);
    }

    @Override
    @Transactional
    public int getPlaceOfRanking(String userName) {
        return websiteDAO.getPlaceOfRanking(userName);
    }
}
