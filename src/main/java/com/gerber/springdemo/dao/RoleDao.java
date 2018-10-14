package com.gerber.springdemo.dao;

import com.gerber.springdemo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
