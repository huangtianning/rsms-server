/**  
* @Title: ExceptionHandlerController.java  
* @Package com.whut.www.controller  
* @Description: 统一处理异常并且向前端返回response
* @author HuangTianning  
* @date 2019年5月8日  
* @version V1.0  
*/

package com.whut.www.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: ExceptionHandlerController
 * @Description: 统一处理异常并且向前端返回response
 * @author HuangTianning
 * @date 2019年5月8日
 * 
 */
@ControllerAdvice // 该注解必须要加，不然不能处理异常
public class ExceptionHandlerController {

	private static Logger log = Logger.getLogger(ExceptionHandlerController.class);

	/**
	 * @Title: handlerAuthorizationException
	 * @Description: 捕获并处理SHIRO的AuthorizationException异常，该异常通常是权限认证不通过时抛出的
	 * @param authorizationException
	 * @param request
	 * @param response
	 * @return JSONObject 返回类型
	 * @throws：异常信息
	 */
	@ExceptionHandler(AuthorizationException.class) // 该注解必须要加，否则不能处理异常
	@ResponseBody // 该注解必须要加，否则不能返回JSON response.
	public JSONObject handlerAuthorizationException(AuthorizationException authorizationException,
			HttpServletRequest request, HttpServletResponse response) {

		log.error("捕获异常AuthorizationException: 权限认证没有通过. 异常信息: " + authorizationException.getMessage());

		JSONObject result = new JSONObject();

		// 设置请求头，解决CORS跨域问题
		String origin = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", origin);

		result.put("message", "认证没有通过，权限不足");
		result.put("status", "401");
		result.put("data", null);
		return result;
	}

	/**
	 * @Title: handlerAuthenticationExceptionException
	 * @Description: 捕获并处理SHIRO的AuthenticationExceptionException异常，该异常通常是身份认证不通过时抛出的
	 * @param authenticationException
	 * @param request
	 * @param response
	 * @return JSONObject 返回类型
	 * @throws：异常信息
	 */
	@ExceptionHandler(AuthenticationException.class) // 该注解必须要加，否则不能处理异常
	@ResponseBody // 该注解必须要加，否则不能返回JSON response.
	public JSONObject handlerAuthenticationExceptionException(AuthenticationException authenticationException,
			HttpServletRequest request, HttpServletResponse response) {

		log.error("捕获异常AuthenticationException: 身份认证没有通过. 异常信息: " + authenticationException.getMessage());

		JSONObject result = new JSONObject();

		// 设置请求头，解决CORS跨域问题
		String origin = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", origin);

		result.put("message", "login failure.");
		result.put("status", "401");
		result.put("data", null);
		return result;
	}
}
