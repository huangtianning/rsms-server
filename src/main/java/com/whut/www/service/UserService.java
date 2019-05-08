package com.whut.www.service;

import com.whut.www.model.User;

public interface UserService<T, E> extends CommonService<T, E>{
	User findUserById(Integer id);
	User findUserByName(String name);
	String getRole(String username);
}
