package com.whut.www.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.whut.www.dao.RoleMapper;
import com.whut.www.dao.UserMapper;
import com.whut.www.dao.UserRoleMapper;
import com.whut.www.model.Role;
import com.whut.www.model.User;
import com.whut.www.model.UserRole;
import com.whut.www.model.UserRoleExample;

@Service
@Primary // 加上该注解指定为该实现类
public class UserRoleServiceImp implements UserRoleService {

	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<User> findAllUserByRoleId(Integer roleId) {
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andRidEqualTo(roleId);
		// 根据rid找到所有rid相同的记录
		List<UserRole> userRoleList = userRoleMapper.selectByExample(userRoleExample);
		// 创建一个userList用于保存等下找到的user
		List<User> userList = new ArrayList<User>();
		// 根据上面找到的每条UserRole记录中的uid,找到对应的user并放入userList
		for (UserRole ur : userRoleList) {
			userList.add(userMapper.selectByPrimaryKey(ur.getUid()));
		}
		return userList;
	}

	@Override
	public List<Role> findAllRoleByUserId(Integer userId) {
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andUidEqualTo(userId);
		// 根据id找到所有rid相同的记录
		List<UserRole> userRoleList = userRoleMapper.selectByExample(userRoleExample);
		// 创建一个roleList用于保存等下找到的role
		List<Role> roleList = new ArrayList<Role>();
		// 根据上面找到的每条UserRole记录中的uid,找到对应的user并放入userList
		for (UserRole ur : userRoleList) {
			roleList.add(roleMapper.selectByPrimaryKey(ur.getRid()));
		}
		return roleList;
	}

}
