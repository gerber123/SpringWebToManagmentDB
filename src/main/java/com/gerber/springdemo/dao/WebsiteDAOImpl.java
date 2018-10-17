package com.gerber.springdemo.dao;

import com.gerber.springdemo.entity.User;
import com.gerber.springdemo.entity.Websites;
import com.gerber.springdemo.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WebsiteDAOImpl implements WebsiteDAO
{
    @Autowired
    private SessionFactory sessionFactory;


    @Autowired
    UserService userService;

    @Override
    public List<Websites> getAllWebsites() {
        Session session =sessionFactory.getCurrentSession();
//        List<Websites> listOfPlayers = session.createQuery("from Websites",Websites.class).getResultList();
//        return listOfPlayers;
        // get the current hibernate session

        // create a query  ... sort by last name
        Query<Websites> theQuery = session.createQuery("from Websites order by vote_points desc", Websites.class);

        // execute query and get result list
        List<Websites> websites = theQuery.getResultList();

        // return the results
        return websites;
    }
    @Override
    public void saveWebsite(Websites websites)
    {
        Session session =sessionFactory.getCurrentSession();

        session.saveOrUpdate(websites);

    }
    @Override
    public Websites getWebsite(int theId) {
        Session session =sessionFactory.getCurrentSession();
        Websites player=session.get(Websites.class,theId);
        return player;
    }
    @Override
    public void deleteWebsite(int theId) {
        Session session=sessionFactory.getCurrentSession();
        Websites player=session.get(Websites.class,theId);
        session.delete(player);
    }
    @Override
    public List<Websites> findWebsite(String nameOfAuthor) {
        Session session=sessionFactory.getCurrentSession();
        Query q=null;
        if(nameOfAuthor !=null&& nameOfAuthor.trim().length()>0)
        {
            q=session.createQuery ("from Websites where lower(author_firstName) like :theName or Lower(author_lastName) like :theName", Websites.class);
            q.setParameter("theName","%"+ nameOfAuthor.toLowerCase()+"%");
        }
        else
        {
            q =session.createQuery("from Websites", Websites.class);
        }
        List<Websites> websites =q.getResultList();
        return websites;
    }

    @Override
    public void voteForWebsite(int theId) {
        Session session = sessionFactory.getCurrentSession();
        Websites websiteToVote= session.get(Websites.class,theId);

         int votePoints = websiteToVote.getVote_points();
            votePoints+=1;
            websiteToVote.setVote_points(votePoints);
            session.saveOrUpdate(websiteToVote);
    }

}
