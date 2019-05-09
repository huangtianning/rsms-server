/**  
* @Title: RolePermissonServiceImplTest.java  
* @Package com.whut.www.service  
* @Description: TODO(用一句话描述该文件做什么)  
* @author HuangTianning
* @date 2019年5月9日  
* @version V1.0  
*/  

package com.whut.www.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.whut.www.model.Permission;
import com.whut.www.model.Role;

/**  
* @ClassName: RolePermissonServiceImplTest  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author HuangTianning
* @date 2019年5月9日  
*    
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class RolePermissionServiceImplTest {
	
	private static Logger log = Logger.getLogger(RolePermissionServiceImplTest.class);
	
	@Autowired
	private RolePermissionService rolePermissionService;

	@Test
	public void findAllUserByRoleIdTest() throws Exception {
		List<Permission> pl = rolePermissionService.findAllPermissionByRoleId(2);
		
		for(Permission p : pl) {
			log.warn(p.getDescription());
		}
		
	}
	
	@Test
	public void findAllRoleByUserIdTest() throws Exception {

		List<Role> rl = rolePermissionService.findAllRoleByPermissionId(1);
		
		for(Role r : rl) {
			log.warn(r.getRole());
		}
		
	}
}
