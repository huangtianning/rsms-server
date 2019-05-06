package com.whut.www.shiro.session;

import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class ShiroSessionListener implements SessionListener {

	private static Logger log = Logger.getLogger(ShiroSessionListener.class);

	@Override
	public void onStart(Session session) {
		// TODO Auto-generated method stub
		log.info("会话创建：" + session.getId());
	}

	@Override
	public void onStop(Session session) {
		// TODO Auto-generated method stub
		log.info("会话停止：" + session.getId());
	}

	@Override
	public void onExpiration(Session session) {
		// TODO Auto-generated method stub
		log.info("会话过期：" + session.getId());
	}

}
