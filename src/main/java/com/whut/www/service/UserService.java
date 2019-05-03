package com.whut.www.service;

import java.util.List;

import com.whut.www.model.User;

public interface UserService {
	
	boolean addUser(User user);
	User findUserById(Integer id);
	List<User> findUserByName(String name);
}
