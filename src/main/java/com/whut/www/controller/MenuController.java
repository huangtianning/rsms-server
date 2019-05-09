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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.whut.www.service.UserService;

@RestController
public class MenuController {
	private static Logger log = Logger.getLogger(MenuController.class);
	
//	@Autowired
//	private UserService userService;
	
	/**
	 * API:请求菜单列表
	 * 
	 * @param none
	 */
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public JSONArray logout(HttpServletRequest request, HttpServletResponse response) {
	
		// 设置请求头，解决CORS跨域问题
		String origin = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", origin);

		JSONArray result = new JSONArray();

		// 获取当前用户
		Subject currentUser = SecurityUtils.getSubject();
		
		// 根据当前用户的权限，指定返回数据
		
		//1.拼装各个菜单
		JSONObject MenuHome = new JSONObject();
		MenuHome.put("title", "主页");
		MenuHome.put("key", "/admin/home");
		MenuHome.put("icon", "home");
		
		JSONObject MenuApply = new JSONObject();
		MenuApply.put("title", "申报中心");
		MenuApply.put("key", "/admin/apply");
		MenuApply.put("icon", "home");
		
		JSONObject MenuUser = new JSONObject();
		MenuUser.put("title", "用户管理");
		MenuUser.put("key", "/admin/users");
		MenuUser.put("icon", "user");
		
		
		result.add(MenuHome);//主页总是可见(顺序很重要)
		
		//子菜单权限:
		JSONArray MenuApplyChildrenArray = new JSONArray();
		if(currentUser.isPermitted("1")) {
			JSONObject subMenu1 = new JSONObject();
			subMenu1.put("title", "申请表填写");
			subMenu1.put("key", "/admin/apply_form");
			subMenu1.put("icon", "wifi");
			MenuApplyChildrenArray.add(subMenu1);
		}
		if(currentUser.isPermitted("2")) {
			JSONObject subMenu2 = new JSONObject();
			subMenu2.put("title", "申请表检查");
			subMenu2.put("key", "/admin/apply_check");
			subMenu2.put("icon", "cluster");
			MenuApplyChildrenArray.add(subMenu2);
		}
		if(!MenuApplyChildrenArray.isEmpty()) {
			MenuApply.put("children", MenuApplyChildrenArray);
			result.add(MenuApply);
		}else {
			//对应的一级菜单也应该不可见，即不把该一级菜单放入result中。用一个;占位
			;
		}
		
		result.add(MenuUser);
		
		return result;
	}
}
