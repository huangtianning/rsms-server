/**  
* @Title: RolePermissionService.java  
* @Package com.whut.www.service  
* @Description: TODO(用一句话描述该文件做什么)  
* @author HuangTianning
* @date 2019年5月9日  
* @version V1.0  
*/  

package com.whut.www.service;

import java.util.List;

import com.whut.www.model.Permission;
import com.whut.www.model.Role;
import com.whut.www.model.RolePermission;

/**  
* @ClassName: RolePermissionService  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author HuangTianning
* @date 2019年5月9日  
*    
*/
public interface RolePermissionService extends CommonService<RolePermission>{
	List<Permission> findAllPermissionByRoleId(Integer rid);
	List<Role> findAllRoleByPermissionId(Integer pid);
}
