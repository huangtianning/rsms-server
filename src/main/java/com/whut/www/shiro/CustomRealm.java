package com.whut.www.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.whut.www.controller.LoginController;
import com.whut.www.model.Permission;
import com.whut.www.model.Role;
import com.whut.www.model.User;
import com.whut.www.service.RolePermissionService;
import com.whut.www.service.UserRoleService;
import com.whut.www.service.UserService;

public class CustomRealm extends AuthorizingRealm {

	private static Logger log = Logger.getLogger(LoginController.class);

	// 用于用户查询
	@Autowired
	private UserService<User> userService;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private RolePermissionService rolePermissionService;

	// 角色权限和对应权限添加
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		log.debug("进入doGetAuthorizationInfo方法，进行权限认证");

		// 获取登录用户名
		User loginUser = (User) principalCollection.getPrimaryPrincipal();
		String name = loginUser.getUserName();
		// 根据用户名查询到对应用户
		User user = userService.findUserByName(name);
		
		// [*添加角色和权限*]
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 1.先添加角色.首先获得该用户所具有的角色(可能不止一个),从user_role表中去查
		List<Role> roleList = userRoleService.findAllRoleByUserId(user.getId());
		// 需要将 role 封装到 Set 作为 info.setRoles() 的参数
		Set<String> roleSet = new HashSet<>();
		for (Role role : roleList) {
			roleSet.add(role.getRole());
		}
		// 设置该用户拥有的角色
		simpleAuthorizationInfo.setRoles(roleSet);
		// 2.再添加权限.根据该用户拥有的角色,从role_permisson表中去查
		Set<String> permissionSet = new HashSet<>();
		for (Role role : roleList) {
			// 根据每个role获取该role所拥有的permission，存在permissionList里
			List<Permission> permissionList = rolePermissionService.findAllPermissionByRoleId(role.getId());
			// 遍历permissionList，把每个permission放入permissionSet
			for (Permission p : permissionList) {
				// 因为对于permission表,id是主键,是唯一的,所以这里选择把id作为每个permission的标识
				permissionSet.add(p.getId().toString());
			}
		}
		// 设置该用户拥有的权限
		simpleAuthorizationInfo.setStringPermissions(permissionSet);
		return simpleAuthorizationInfo;
	}

	// 用户身份认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		log.debug("进入doGetAuthenticationInfo方法，进行身份认证");

		// 获取token
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		log.debug("token中保存的用户名 = " + token.getUsername());
		log.debug("token中保存的密码 = " + new String(token.getPassword()));
		// 调用userService从数据库获取对应token用户名密码的用户
		User user = userService.findUserByName(token.getUsername());

		// 先检查该用户是否存在
		if (user == null) {
			// 用户不存在
			throw new AuthenticationException("用户名不正确,用户不存在");
		} else {
			// 用户存在，再检查密码是否正确
			// 检查token中的密码是否与数据库中的密码一致
			Boolean isPasswordRight = user.getPassWord().equals(new String(token.getPassword())) ? true : false;
			if (!isPasswordRight) {
				// 密码不正确
				throw new AuthenticationException("密码不正确");
			} else {
				// 用户名、密码均正确，可以构造并返回SimpleAuthenticationInfo对象
				return new SimpleAuthenticationInfo(user, user.getPassWord(), getName());
			}
		}

	}

}
