package com.whut.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.whut.www.dao.UserMapper;
import com.whut.www.model.User;
import com.whut.www.model.UserExample;

@Service
@Primary//加上该注解指定为该实现类
public class UserServiceImp implements UserService {
	
	@Autowired
    private UserMapper userMapper;

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			userMapper.insert(user);
			flag=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	/**
	 * 如果查询到多个结果，返回第一个
	 * 如果查询不到结果，返回null
	 */
	@Override
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(name);
		
		List<User> userList = userMapper.selectByExample(userExample);
		
		if(userList.size() != 0) {
			return userList.get(0);
		}else {
			return null;
		}
	}

	
	/**
	 * 如果查询到多个结果，返回第一个user的role字段(可能为null)
	 * 如果查询不到结果，返回null
	 */
	@Override
	public String getRole(String username) {
		// TODO Auto-generated method stub
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(username);
		
		List<User> userList = userMapper.selectByExample(userExample);
		
		if(userList.size() != 0) {
			return userList.get(0).getRole();
		}else {
			return null;
		}
	}

}
