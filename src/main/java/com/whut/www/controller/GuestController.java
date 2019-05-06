package com.whut.www.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/guest")
public class GuestController {

	/**
	 * API:游客进入
	 * 
	 * @param none
	 */
	@RequestMapping(value = "/enter", method = RequestMethod.GET)
	public JSONObject guestEnter(HttpServletRequest request, HttpServletResponse response) {
		// 设置请求头，解决CORS跨域问题
		String origin = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", origin);

		JSONObject result = new JSONObject();

		result.put("message", "欢迎进入，您的身份是游客！");
		result.put("status", "200");
		result.put("data", null);
		return result;
	}

	/**
	 * API:游客获取信息
	 * 
	 * @param none
	 */
	@RequestMapping(value = "/getMessage", method = RequestMethod.GET)
	public JSONObject guestGetMessage(HttpServletRequest request, HttpServletResponse response) {
		// 设置请求头，解决CORS跨域问题
		String origin = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", origin);

		JSONObject result = new JSONObject();

		result.put("message", "您拥有获得该接口的信息的权限！");
		result.put("status", "200");
		result.put("data", null);
		return result;
	}

}
