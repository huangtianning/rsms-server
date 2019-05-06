package com.whut.www.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.whut.www.model.User;
import com.whut.www.service.UserService;
import com.whut.www.shiro.session.SingleSessionManager;

@RestController
public class LoginController {

	private static Logger log = Logger.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	/**
	 * API:请求登出
	 * 
	 * @param none
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public JSONObject logout(HttpServletRequest request, HttpServletResponse response) {
		// 注销
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		log.debug("用户已退出");

		// 设置请求头，解决CORS跨域问题
		String origin = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", origin);

		JSONObject result = new JSONObject();

		result.put("message", "logout success");
		result.put("status", "200");
		result.put("data", null);
		return result;
	}

	/**
	 * API:查询登陆状态
	 * 
	 * @param none
	 */
	@RequestMapping(value = "/loginState", method = RequestMethod.GET)
	public JSONObject loginState(HttpServletRequest request, HttpServletResponse response) {
		// 设置请求头，解决CORS跨域问题
		String origin = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", origin);

		// 创建JSON对象，用于包装结果数据
		JSONObject result = new JSONObject();
		JSONObject userData = new JSONObject();

		// 能否强转成user跟doGetAuthenticationInfo方法中的new SimpleAuthenticationInfo(user,
		// user.getPassword(), getName())
		// 第一个参数有关。第一个参数的类型是principal，可接受任何类型。我的理解是该参数保存了用户信息，而该信息可以自定义。
		Subject currentUser = SecurityUtils.getSubject();
		User user = (User) currentUser.getPrincipal();

		if (currentUser.getSession() != null) {
			userData.put("id", user.getId());
			userData.put("username", user.getUserName());
			userData.put("password", user.getPassWord());

			result.put("message", "login state is login");
			result.put("status", "200");
			result.put("data", userData);

			return result;
		} else {
			result.put("msg", "loginState:logout");
			result.put("status", "401");
			result.put("data", null);
			return result;
		}

	}

	/**
	 * API:请求登入
	 *
	 * @param username 用户名
	 * @param password 密码
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JSONObject login(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password, HttpServletRequest request,
			HttpServletResponse response) {

		// 设置请求头，解决CORS跨域问题
		String origin = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", origin);

		// 创建JSON对象，用于包装结果数据
		JSONObject result = new JSONObject();
		JSONObject resultData = new JSONObject();

		// 从SecurityUtils里边创建一个 subject
		Subject currentUser = SecurityUtils.getSubject();
		
		// 在认证提交前准备 token（令牌）
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		// 执行认证登陆
		try {
			currentUser.login(token);
			log.debug("身份认证成功！");
			
			//一旦认证成功，就开始设置session，并踢掉其他与之同username的session，达到顶号登录的目的
			currentUser.getSession().setTimeout(30000);
			currentUser.getSession().setAttribute("username", username);
			SingleSessionManager.cleanOtherSession(currentUser.getSession().getId().toString(),
					currentUser.getSession().getAttribute("username").toString());
			
			// 根据权限，指定返回数据
			String role = userService.getRole(username);
			log.debug("您的权限角色为：" + role);
			if ("user".equals(role)) {
				resultData.put("username", username);
				resultData.put("role", "user");

				result.put("message", "login success");
				result.put("status", "200");
				result.put("data", resultData);
				return result;
			} else if ("admin".equals(role)) {
				resultData.put("username", username);
				resultData.put("role", "admin");

				result.put("message", "login success");
				result.put("status", "200");
				result.put("data", resultData);
				return result;
			} else {
				resultData.put("username", username);
				resultData.put("role", "guest");

				result.put("message", "login success");
				result.put("status", "200");
				result.put("data", resultData);
				return result;
			}
		} catch (AuthenticationException e) {
			e.printStackTrace();
			log.warn("身份认证失败！");
			result.put("message", "login failure");
			result.put("status", "401");
			result.put("data", resultData);
			return result;
		}

	}
}
