package com.niit.fairdealbackend.dao;

import java.util.List;

import com.niit.fairdealbackend.dto.User;


public interface UserDAO {
	
	// get all users
	public List<User> getAllUsers();
	
	// create user
	public boolean createUser(User user);
	
	// update user
	public boolean updateUser(User user);
	
	// delete user
	public boolean deleteUser(User user);
	
	// get user by id
	public User getUserByID(int id);
	
	// get user by name
	public User getUserByName(String name);
	
	// validate the user
	public User validateUser(int id, String password);
}