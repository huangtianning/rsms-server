package com.whut.www.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.Filter;
import org.apache.shiro.mgt.SecurityManager;

public class ShiroConfiguration {
	
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
		ShiroFilterFactoryBean sffb =new ShiroFilterFactoryBean();
		//设置安全管理器
		sffb.setSecurityManager(securityManager);
		//默认跳转到登录页面
		sffb.setLoginUrl("/login");
		//登录成功后的页面
		sffb.setSuccessUrl("/index");
		//未授权页面
		sffb.setUnauthorizedUrl("/403");
		
		//自定义过滤器
        Map<String,Filter> filterMap=new LinkedHashMap<>();
        sffb.setFilters(filterMap);
        //权限控制map
        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<>();
        //配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
//      //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
//      //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
//      filterChainDefinitionMap.put("/**", "anon");

        sffb.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return sffb;
	}
	
}
