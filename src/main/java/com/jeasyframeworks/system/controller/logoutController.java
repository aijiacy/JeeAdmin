package com.jeasyframeworks.system.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.jeasyframeworks.extentions.route.annotation.AnnoController;
import com.jfinal.core.Controller;

@AnnoController(actionKey="/system/logout")
public class logoutController extends Controller {

	/**
	 * 退出登录
	 */
	public void index() {
		Subject currUser = SecurityUtils.getSubject();
		if (null != currUser) {
			currUser.logout();
		}
	}
}
