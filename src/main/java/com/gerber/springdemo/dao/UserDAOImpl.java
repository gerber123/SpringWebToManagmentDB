package com.gerber.springdemo.dao;

import com.gerber.springdemo.entity.PlayerForTheExp;
import com.gerber.springdemo.entity.User;
import com.gerber.springdemo.user.CrmUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        Session session =sessionFactory.getCurrentSession();
//        List<PlayerForTheExp> listOfPlayers = session.createQuery("from PlayerForTheExp",PlayerForTheExp.class).getResultList();
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

}
