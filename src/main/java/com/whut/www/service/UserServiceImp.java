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


	@Override
	public List<User> findUserByName(String name) {
		// TODO Auto-generated method stub
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(name);

		return userMapper.selectByExample(userExample);
	}

}
