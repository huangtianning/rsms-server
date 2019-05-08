package com.whut.www.shiro;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.log4j.Logger;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.whut.www.shiro.filter.NoRedirectionAuthenticationFilter;
import com.whut.www.shiro.filter.NoRedirectionRolesAuthorizationFilter;
import com.whut.www.shiro.session.ShiroSessionListener;

@Configuration
public class ShiroConfiguration {

	private static Logger log = Logger.getLogger(ShiroConfiguration.class);

	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {

		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

		// 必须设置 SecurityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);

//        // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
//        shiroFilterFactoryBean.setLoginUrl("/notLogin");
//        // 设置无权限时跳转的 url;
//        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");

		// 获取shiroFilterFactoryBean的所有Filters，并加入自定义的Filters
		Map<String, Filter> filterMap = shiroFilterFactoryBean.getFilters();
		filterMap.put("nraf", new NoRedirectionAuthenticationFilter());
		filterMap.put("roles", new NoRedirectionRolesAuthorizationFilter());

		// 设置拦截器
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

		// 登陆接口,无需权限
		filterChainDefinitionMap.put("/login", "anon");
		// 游客，无需权限
		filterChainDefinitionMap.put("/guest/**", "anon");
		// 用户，需要角色权限 "user"
		filterChainDefinitionMap.put("/user/**", "roles[user]");
		// 管理员，需要角色权限 "admin"
		filterChainDefinitionMap.put("/admin/**", "roles[admin]");
		// 其余接口一律拦截,这行代码必须放在所有权限设置的最后，不然会导致所有 URL 都先被它拦截，导致其他拦截器无效
		filterChainDefinitionMap.put("/**", "nraf");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		log.info("Shiro拦截器工厂类注入成功");
		return shiroFilterFactoryBean;
	}

	// 注入securityManager
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 设置realm.
		securityManager.setRealm(customRealm());
		// 自定义session管理
		securityManager.setSessionManager(sessionManager());
		return securityManager;
	}

	// 注入sessionManager,配置SessionListener监听
	@Bean
	public SessionManager sessionManager() {
		DefaultWebSessionManager shiroSessionManager = new DefaultWebSessionManager();
		ArrayList<SessionListener> al = new ArrayList<SessionListener>();
		al.add(new ShiroSessionListener());
		shiroSessionManager.setSessionListeners(al);
		return shiroSessionManager;
	}

	// 注入自定义Realm
	@Bean
	public CustomRealm customRealm() {
		return new CustomRealm();
	}

	// 加入注解的使用
	// 不加入这个注解不生效
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	// 只加上上面那段代码还不够，还必须加上这段代码注解才能生效
	// https://www.jianshu.com/p/ae70d2b1a568
	@Bean
	@ConditionalOnMissingBean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator app = new DefaultAdvisorAutoProxyCreator();
		app.setProxyTargetClass(true);
		return app;
	}

}
