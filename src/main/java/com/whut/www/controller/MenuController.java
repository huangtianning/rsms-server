package com.whut.www.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.whut.www.service.UserService;

@RestController
public class MenuController {
	private static Logger log = Logger.getLogger(MenuController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * API:请求菜单列表
	 * 
	 * @param none
	 */
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public JSONObject logout(HttpServletRequest request, HttpServletResponse response) {
	
		// 设置请求头，解决CORS跨域问题
		String origin = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", origin);

		JSONObject result = new JSONObject();

		// 获取当前用户
		Subject currentUser = SecurityUtils.getSubject();
		// 根据当前用户的权限，指定返回数据
		if(currentUser.hasRole("admin")) {
			
		}else if(currentUser.hasRole("user")) {
			
		}else if(currentUser.hasRole("boss")) {
			
		}else{
			
		};
		
		result.put("message", "logout success");
		result.put("status", "200");
		result.put("data", null);
		return result;
	}
}
