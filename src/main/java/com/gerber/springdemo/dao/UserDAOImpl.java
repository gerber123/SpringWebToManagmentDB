package com.gerber.springdemo.dao;

import com.gerber.springdemo.entity.User;
import com.gerber.springdemo.user.CrmUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class UserDAOImpl implements UserDAO
{
    public final static long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        Session session =sessionFactory.getCurrentSession();
//        List<Websites> listOfPlayers = session.createQuery("from Websites",Websites.class).getResultList();
//        return listOfPlayers;
        // get the current hibernate session

        // create a query  ... sort by last name
        Query<User> theQuery = session.createQuery("from User", User.class);

        // execute query and get result list
        List<User> crmUsers = theQuery.getResultList();

        // return the results
        return crmUsers;
    }
    @Override
    public User findByUserName(String theUserName) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using username
        Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
        theQuery.setParameter("uName", theUserName);
        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }

    @Override
    public void save(User theUser) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create the user ... finally LOL
        currentSession.saveOrUpdate(theUser);
    }

    @Override
    public User getUser(long theId) {
        Session session =sessionFactory.getCurrentSession();
        User user=session.get(User.class,theId);
        return user;
    }



    @Override
    public void deleteUser(long theId) {
        Session session=sessionFactory.getCurrentSession();
        User user=session.get(User.class,theId);
        session.delete(user);
    }

    @Override
    public  List<User>  findByUserNameFinder(String userNameee) {
        Session session=sessionFactory.getCurrentSession();
        Query q=null;
        if(userNameee !=null&& userNameee.trim().length()>0)
        {
            q=session.createQuery ("from User where lower(userName) like :theName or Lower(lastName) like :theName", User.class);
            q.setParameter("theName","%"+ userNameee.toLowerCase()+"%");
        }
        else
        {
            q =session.createQuery("from User", User.class);
        }
        List<User>  users =q.getResultList();
        return users;
    }

    @Override
    public void afterVoted(String name) {
        User user = findByUserName(name);
        java.util.Date dt = new java.util.Date();
        user.setVoteEnable(0);
        user.setLast_vote_date(dt);
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void checkVoteEnabled()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = findByUserName(name);

        Date dateOfLastVote =user.getLast_vote_date();
        Date todayDate= new Date();


        boolean moreThanDay = Math.abs(dateOfLastVote.getTime() - todayDate.getTime()) > MILLIS_PER_DAY;
        if(moreThanDay)
        {
            user.setVoteEnable(1);
            sessionFactory.getCurrentSession().saveOrUpdate(user);
            System.out.println("YOU CAN VOTE!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        else
        {
            System.out.println("YOU MUST WAIT !!!!!!!!!!!!!!!!!!!!!");
        }



    }

}
