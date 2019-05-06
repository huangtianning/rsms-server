package com.whut.www.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.whut.www.config.Config;
import com.whut.www.model.User;
import com.whut.www.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = Config.CorsIP, maxAge = 3600) // 请求来源地址
@Api(value = "/user", tags = "我的user接口模块")
public class UserController {
	
	private static Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	// loginAction
	@ApiOperation(value="请求登录", notes="用于请求登录的api")
//	@ApiImplicitParam(name = "username", value = "用户名、账号名", required = true, dataType = "String")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "query"),
		@ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User", paramType = "path")
	})
	@ApiResponses({
		@ApiResponse(code = 200, message = "找到了一个用户哦", response = User.class),
		@ApiResponse(code = 401, message = "can't find this user"),
		@ApiResponse(code = 403, message = "can't find this user"),
		@ApiResponse(code = 410, message = "Gone"),
		@ApiResponse(code = 404, message = "can't find this user")
	})
	
	@RequestMapping(value = "/loginAction", method = RequestMethod.GET)
	public JSONObject loginAction(@RequestParam(value = "username", required = true) String username,
			HttpServletRequest request, HttpServletResponse response) {

		response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Origin", "Origin");

		JSONObject result = new JSONObject();
		JSONObject userData = new JSONObject();

		User user = userService.findUserByName(username);

		if (user != null) {
			request.getSession().setAttribute("id", user.getId());
			request.getSession().setAttribute("username", user.getUserName());
			request.getSession().setAttribute("password", user.getPassWord());
			request.getSession().setMaxInactiveInterval(120);

			userData.put("id", request.getSession().getAttribute("id"));
			userData.put("username", request.getSession().getAttribute("username"));
			userData.put("password", request.getSession().getAttribute("password"));
			
			
			result.put("msg", "loginAction ok");
			result.put("status", "200");
			result.put("data", userData);

			return result;
		} else {

//			request.getSession().setAttribute("username", null);
//			request.getSession().setAttribute("password", null);
//			request.getSession().setMaxInactiveInterval(120);

			result.put("msg", "not found user");
			result.put("status", "404");
			result.put("data", null);
			return result;
		}

	}

	// loginState
	@RequestMapping(value = "/loginState", method = RequestMethod.GET)
	public JSONObject loginState(HttpServletRequest request, HttpServletResponse response) {

		response.setHeader("Access-Control-Allow-Credentials", "true");

		JSONObject result = new JSONObject();
		JSONObject userData = new JSONObject();


		log.debug("loginState: id = " + request.getSession().getAttribute("id"));
		log.debug("loginState: username = " + request.getSession().getAttribute("username"));
		log.debug("loginState: password = " + request.getSession().getAttribute("password"));


		if (request.getSession().getAttribute("username") != null
				&& request.getSession().getAttribute("password") != null
					&& request.getSession().getAttribute("id") != null) {
			userData.put("id", request.getSession().getAttribute("id"));
			userData.put("username", request.getSession().getAttribute("username"));
			userData.put("password", request.getSession().getAttribute("password"));

			result.put("msg", "loginState:login");
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

	// logoutAction
	@RequestMapping(value = "/logoutAction", method = RequestMethod.GET)
	public JSONObject logoutAction(HttpServletRequest request, HttpServletResponse response) {

		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		JSONObject result = new JSONObject();

		request.getSession().invalidate();
		log.debug("logoutAction: Session invalidate.");

		result.put("msg", "logoutAction ok");
		result.put("status", "200");
		result.put("data", null);
		return result;

	}

}
