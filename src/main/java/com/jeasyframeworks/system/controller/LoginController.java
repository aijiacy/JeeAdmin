package com.jeasyframeworks.system.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import com.jeasyframeworks.core.constants.AjaxMsg;
import com.jeasyframeworks.core.controller.BaseController;
import com.jeasyframeworks.extentions.route.annotation.ControllerKey;
import com.jeasyframeworks.extentions.shiro.annotation.ClearShiro;
import com.jeasyframeworks.system.model.Account;
import com.jfinal.aop.ClearInterceptor;
import com.jfinal.log.Logger;

/**
 * 登录处理
 * 
 * @author caoyong
 *
 */
@ControllerKey(controllerKey = "/system")
public class LoginController extends BaseController<Account> {

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@ClearInterceptor
	public void index() {
		render("login.html");
	}

	/**
	 * 用户登录
	 */
	@ClearShiro
	public void login() {
		AjaxMsg msg = new AjaxMsg(1, "登录成功");
		try {
			Account reqAccount = getModel(Account.class);
			boolean forgetPwd = getParaToBoolean("forgetPass");
			Subject currUser = SecurityUtils.getSubject();
			String username = reqAccount.getStr(Account.NAME);
			String password = reqAccount.getStr(Account.PASSWORD);
			UsernamePasswordToken uToken = new UsernamePasswordToken(username, password);
			uToken.setRememberMe(forgetPwd);
			currUser.login(uToken);
		} catch (AuthenticationException authex) {
			msg = new AjaxMsg(0, authex.getMessage());
			logger.error(msg.getRetMsg(), authex);
		} catch (Exception ex) {
			msg = new AjaxMsg(0, ex.getMessage());
			logger.error(msg.getRetMsg(), ex);
		}
		this.renderJson(msg);
	}

	/**
	 * 退出登录
	 */
	public void logout() {
		Subject currUser = SecurityUtils.getSubject();
		currUser.logout();
	}

	/**
	 * 修改密码
	 */
	public void change() {

	}

	/**
	 * 找回密码
	 */
	public void findPwd() {

	}

	@Override
	public Account getModelDAO() {
		// TODO Auto-generated method stub
		return Account.dao;
	}
}
