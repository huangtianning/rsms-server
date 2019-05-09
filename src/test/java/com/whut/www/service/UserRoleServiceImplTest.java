package com.whut.www.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.whut.www.model.Role;
import com.whut.www.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRoleServiceImplTest {

	@Autowired
	private UserRoleServiceImpl UserRoleServiceImp;

	@Test
	public void findAllUserByRoleIdTest() throws Exception {

		List<User> ul = UserRoleServiceImp.findAllUserByRoleId(2);
		
		for(User u : ul) {
			System.out.println(u.getUserName());
		}
		
	}
	
	@Test
	public void findAllRoleByUserIdTest() throws Exception {

		List<Role> rl = UserRoleServiceImp.findAllRoleByUserId(1);
		
		for(Role r : rl) {
			System.out.println(r.getRole());
		}
		
	}
	
}
