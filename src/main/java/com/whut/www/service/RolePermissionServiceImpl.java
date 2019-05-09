/**  
* @Title: RolePermissionServiceImpl.java  
* @Package com.whut.www.service  
* @Description: TODO(用一句话描述该文件做什么)  
* @author HuangTianning
* @date 2019年5月9日  
* @version V1.0  
*/  

package com.whut.www.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.whut.www.dao.PermissionMapper;
import com.whut.www.dao.RoleMapper;
import com.whut.www.dao.RolePermissionMapper;
import com.whut.www.model.Permission;
import com.whut.www.model.Role;
import com.whut.www.model.RolePermission;
import com.whut.www.model.RolePermissionExample;

/**  
* @ClassName: RolePermissionServiceImpl  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author HuangTianning
* @date 2019年5月9日  
*    
*/

@Service
@Primary // 加上这两个注解指定为该实现类,一定不要忘了这两个注解！！！！！！！！！！！！！
public class RolePermissionServiceImpl implements RolePermissionService {

	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private RoleMapper roleMapper;

	/**
	* <p>Title: create</p>  
	* <p>Description: </p>  
	* @param t
	* @return  
	* @see com.whut.www.service.CommonService#create(java.lang.Object)  
	*/
	@Override
	public boolean create(RolePermission t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	* <p>Title: delete</p>  
	* <p>Description: </p>  
	* @param t
	* @return  
	* @see com.whut.www.service.CommonService#delete(java.lang.Object)  
	*/
	@Override
	public boolean delete(RolePermission t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	* <p>Title: update</p>  
	* <p>Description: </p>  
	* @param t
	* @return  
	* @see com.whut.www.service.CommonService#update(java.lang.Object)  
	*/
	@Override
	public boolean update(RolePermission t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	* <p>Title: retrieve</p>  
	* <p>Description: </p>  
	* @param t
	* @return  
	* @see com.whut.www.service.CommonService#retrieve(java.lang.Object)  
	*/
	@Override
	public RolePermission retrieve(RolePermission t) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	* <p>Title: retrieveAll</p>  
	* <p>Description: </p>  
	* @return  
	* @see com.whut.www.service.CommonService#retrieveAll()  
	*/
	@Override
	public List<RolePermission> retrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	* <p>Title: findAllPermissionByRoleId</p>  
	* <p>Description: </p>  
	* @param rid
	* @return  
	* @see com.whut.www.service.RolePermissionService#findAllPermissionByRoleId(java.lang.Integer)  
	*/
	@Override
	public List<Permission> findAllPermissionByRoleId(Integer rid) {
		RolePermissionExample rpe = new RolePermissionExample();
		rpe.createCriteria().andRidEqualTo(rid);
		// 根据rid找到所有rid相同的记录
		List<RolePermission> rolePermissionList = rolePermissionMapper.selectByExample(rpe);
		// 创建一个PermissionList用于保存等下找到的permission
		List<Permission> permissionList = new ArrayList<Permission>();
		// 根据上面找到的每条RolePermission记录中的pid,找到对应的permission并放入permissionList
		for (RolePermission record : rolePermissionList) {
			permissionList.add(permissionMapper.selectByPrimaryKey(record.getPid()));
		}
		return permissionList;
	}

	/**
	* <p>Title: findAllRoleByPermissionId</p>  
	* <p>Description: </p>  
	* @param pid
	* @return  
	* @see com.whut.www.service.RolePermissionService#findAllRoleByPermissionId(java.lang.Integer)  
	*/
	@Override
	public List<Role> findAllRoleByPermissionId(Integer pid) {
		RolePermissionExample rpe = new RolePermissionExample();
		rpe.createCriteria().andPidEqualTo(pid);
		// 根据pid找到所有pid相同的记录
		List<RolePermission> rolePermissionList = rolePermissionMapper.selectByExample(rpe);
		// 创建一个roleList用于保存等下找到的permission
		List<Role> roleList = new ArrayList<Role>();
		// 根据上面找到的每条RolePermission记录中的rid,找到对应的role并放入roleList
		for (RolePermission record : rolePermissionList) {
			roleList.add(roleMapper.selectByPrimaryKey(record.getRid()));
		}
		return roleList;
	}

}
