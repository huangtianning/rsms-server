package com.whut.www.shiro.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.alibaba.fastjson.JSONObject;

public class NoRedirectionRolesAuthorizationFilter extends RolesAuthorizationFilter {
	
	private static final String MESSAGE = "Access denied. You don't have enough permissions.";

	/**
	 * 重写当请求被拦截时的处理方法onAccessDenied，其祖先类AuthorizationFilter的处理方式是重定向到主页，参考该类第109行.
	 * 我的需求是不要重定向到主页，只需要返回一个JSON方便前端处理.
	 */
	@Override
    protected boolean onAccessDenied(final ServletRequest request, final ServletResponse response) throws IOException {
		
		HttpServletResponse httpResponse ;
		HttpServletRequest httpRequest ;
		
		//创建JSON对象，用于包装结果数据
        JSONObject result = new JSONObject();
        
        try {
        	httpResponse = WebUtils.toHttp(response);
            httpRequest = WebUtils.toHttp(request);
            //设置请求头，解决CORS跨域问题
            String origin = httpRequest.getHeader("Origin");
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpResponse.setHeader("Access-Control-Allow-Origin", origin);
        }catch (ClassCastException ex) {
            // Not a HTTP Servlet operation
            return super.onAccessDenied(request, response) ;
        }

        //设置编码格式和ContentType为json，方便前端解析
        httpResponse.setCharacterEncoding("utf-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        //加入响应体信息
    	result.put("message", MESSAGE);
		result.put("status", "403");
    	httpResponse.getWriter().append(result.toJSONString()).close();
    	
        return false;  // No further processing.
    }
}
