package com.gerber.springdemo.service;

import com.gerber.springdemo.entity.Websites;

import java.util.List;

public interface WebsiteService
{
    public List<Websites> getAllWebsites();

    void saveWebsite(Websites websites);

    Websites getWebsite(int theId);

    void deleteWebsite(int theId);

    List<Websites> findWebsite(String nameOfAuthor);

    void voteForWebsite(int theId);

    int getPlaceOfRanking(String userName);
}
