package com.gerber.springdemo.dao;

import com.gerber.springdemo.entity.Role;

import java.util.List;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	public List<Role> getAllRoles();
	
}
