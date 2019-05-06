package com.whut.www.shiro.session;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import com.whut.www.controller.LoginController;

public class SingleSessionManager {

	private static Logger log = Logger.getLogger(LoginController.class);
	
	public static void cleanOtherSession(String sessionId, String userName) {
		DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
		DefaultWebSessionManager sessionManager = (DefaultWebSessionManager) securityManager.getSessionManager();
		// 获取当前已登录的用户session列表
		Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();
//		log.info(sessionId);
//		log.info(userName);
		for (Session session : sessions) {
			log.info(session.getId());
			log.info(session.getAttribute("username"));
			log.info(session.getAttribute("username").equals(userName) && !session.getId().toString().equals(sessionId));
			if(session.getAttribute("username").equals(userName) && !session.getId().toString().equals(sessionId)) {
				log.warn("delete");
				sessionManager.getSessionDAO().delete(session);
			}
		}
		log.info(sessions.size());
	}

}
