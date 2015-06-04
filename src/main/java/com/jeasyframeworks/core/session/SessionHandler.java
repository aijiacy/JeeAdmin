package com.jeasyframeworks.core.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jfinal.handler.Handler;
import com.jfinal.log.Logger;

public class SessionHandler extends Handler {

	private static final Logger logger = Logger.getLogger(SessionHandler.class);
	
	/**
	 * 去掉 URL中的;JSEESIONID=××××××
	 */
	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response,
			boolean[] isHandled) {
		if(request.isRequestedSessionIdFromURL()){
			HttpSession session = request.getSession(false);
			if(null != session){
				session.invalidate();
			}
			target = request.getServletPath();
			if(logger.isDebugEnabled()){
				logger.debug("sessionIdVaild:" + request.isRequestedSessionIdValid());
				logger.debug("sessionIdFromCookie:" + request.isRequestedSessionIdFromCookie());
				logger.debug("sessionIdFromURL:" + request.isRequestedSessionIdFromURL());
				logger.debug("ActionKey:" + target);
			}
		}
		nextHandler.handle(target, request, response, isHandled);
	}

}
