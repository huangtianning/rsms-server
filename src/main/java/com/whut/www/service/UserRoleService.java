package com.whut.www.service;

import java.util.List;

import com.whut.www.model.Role;
import com.whut.www.model.User;

public interface UserRoleService {
	List<User> findAllUserByRoleId(Integer roleId);
	List<Role> findAllRoleByUserId(Integer userId);
}
