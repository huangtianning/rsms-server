package com.whut.www.service;

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
	public void getUser() throws Exception {
		
		User user = UserServiceImp.findUserById(1);
		
	}
}