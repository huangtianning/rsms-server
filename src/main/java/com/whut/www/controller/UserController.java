package com.whut.www.controller;

import java.util.List;

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

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = Config.CorsIP, maxAge = 3600) // 请求来源地址
public class UserController {
	
	private static Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	// loginAction
	@RequestMapping(value = "/loginAction", method = RequestMethod.GET)
	public JSONObject loginAction(@RequestParam(value = "username", required = true) String username,
			HttpServletRequest request, HttpServletResponse response) {

		response.setHeader("Access-Control-Allow-Credentials", "true");

		JSONObject result = new JSONObject();
		JSONObject userData = new JSONObject();

		List<User> userList = userService.findUserByName(username);

		if (!userList.isEmpty()) {
			request.getSession().setAttribute("id", userList.get(0).getId());
			request.getSession().setAttribute("username", userList.get(0).getUsername());
			request.getSession().setAttribute("password", userList.get(0).getPassword());
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
