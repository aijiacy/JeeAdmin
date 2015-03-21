package com.jeasyframeworks.platform.controller;


import javax.servlet.http.Cookie;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jeasyframeworks.extentions.route.annotation.ControllerKey;
import com.jeasyframeworks.platform.define.ReturnMsg;
import com.jeasyframeworks.platform.interceptor.AuthInterceptor;
import com.jeasyframeworks.platform.model.Account;
import com.jeasyframeworks.toolkit.encrypt.MD5EncryptKit;
import com.jfinal.aop.Before;
import com.jfinal.aop.ClearInterceptor;
import com.jfinal.core.Controller;

/**
 * 登录处理
 * @author caoyong
 *
 */
@ControllerKey(controllerKey="/login")
@Before(AuthInterceptor.class)//Controller级别：通用验证拦截器
public class LoginController extends Controller{
	
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	
	@ClearInterceptor
	public void index(){
		render("login.html");
	}
	/**
	 * 用户登录
	 */
	@ClearInterceptor
	public void logon(){
		ReturnMsg msg = new ReturnMsg("1", "登录成功");
		try{
			Account request_Account = getModel(Account.class);
			boolean forgetPwd = getParaToBoolean("forgetPass");
			
			Account account = Account.dao.findByName(request_Account.getStr(Account.NAME));
			if(null == account){
				msg = new ReturnMsg("0", "账号不存在");
			} else {
				if(MD5EncryptKit.isEqual(request_Account.getStr(Account.PASSWORD), account.getStr(Account.PASSWORD))){
					this.setSessionAttr("UserAgent", account);
					if(forgetPwd){
						Cookie cookie = new Cookie("mall_User", account.getStr(Account.NAME) + ":" + request_Account.getStr(Account.PASSWORD));
						this.setCookie(cookie);
					}
				}else{
					msg = new ReturnMsg("0", "密码错误");
				}
			}
		}catch(Exception ex){
			logger.error("登录异常：", ex);
			msg = new ReturnMsg("0", "登录异常：" + ex);
		}
		this.renderJson(msg);
	}
	
	/**
	 * 退出登录
	 */
	public void loginOut(){
		this.removeSessionAttr("UserAgent");
		redirect("login");
	}
	
	/**
	 * 修改密码
	 */
	public void change(){
		
	}
	
	/**
	 * 找回密码
	 */
	public void findPwd(){
		
	}
}
