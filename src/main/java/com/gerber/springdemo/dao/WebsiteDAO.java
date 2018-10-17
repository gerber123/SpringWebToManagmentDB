package com.gerber.springdemo.dao;

import com.gerber.springdemo.entity.Websites;

import java.util.List;

public interface WebsiteDAO
{
    public List<Websites> getAllWebsites();

    void saveWebsite(Websites websites);

    Websites getWebsite(int theId);

    void deleteWebsite(int theId);

    List<Websites> findWebsite(String nameOfAuthor);

    void voteForWebsite(int theId);
}
