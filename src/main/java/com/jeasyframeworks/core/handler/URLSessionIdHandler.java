package com.jeasyframeworks.core.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

public class URLSessionIdHandler extends Handler {
	
	/**
	 * 去掉 URL中的;JSEESIONID=××××××
	 */
	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response,
			boolean[] isHandled) {
		String sessionIdParam = ";JSESSIONID=";
		int idx = target.lastIndexOf(sessionIdParam);
		if(idx == -1){
			idx = target.lastIndexOf(sessionIdParam.toLowerCase());
		}
		target = idx == -1 ? target : target.substring(0, idx);
		nextHandler.handle(target, request, response, isHandled);
	}

}
