package com.whut.www.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.whut.www.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImpTest {

	@Autowired
	private UserServiceImp UserServiceImp;

	@Test
	public void createUser() throws Exception {
		
		User user = new User();

		user.setUserName("admin666");
		user.setPassWord("admin666");
		user.setAge(9);
		user.setRole("user");
		user.setGender(true);
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		
		UserServiceImp.create(user);
		
	}
}
