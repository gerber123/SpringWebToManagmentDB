package com.gerber.springdemo.dao;


import com.gerber.springdemo.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Role findRoleByName(String theRoleName) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using name
		Query<Role> theQuery = currentSession.createQuery("from Role where name=:roleName", Role.class);
		theQuery.setParameter("roleName", theRoleName);
		
		Role theRole = null;
		
		try {
			theRole = theQuery.getSingleResult();
		} catch (Exception e) {
			theRole = null;
		}
		
		return theRole;
	}

	@Override
	public List<Role> getAllRoles() {
		Session session =sessionFactory.getCurrentSession();
//        List<Websites> listOfPlayers = session.createQuery("from Websites",Websites.class).getResultList();
//        return listOfPlayers;
		// get the current hibernate session

		// create a query  ... sort by last name
		Query<Role> theQuery = session.createQuery("from Role", Role.class);

		// execute query and get result list
		List<Role> roles = theQuery.getResultList();
		return roles;
	}
}
