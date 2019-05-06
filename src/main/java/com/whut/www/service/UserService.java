package com.whut.www.service;

import com.whut.www.model.User;

public interface UserService {
	
	boolean addUser(User user);
	User findUserById(Integer id);
	User findUserByName(String name);
	String getRole(String username);
}
