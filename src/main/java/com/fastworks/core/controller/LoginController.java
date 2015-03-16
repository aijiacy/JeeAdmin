package com.fastworks.core.controller;


import javax.servlet.http.Cookie;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fastworks.core.define.ReturnMsg;
import com.fastworks.core.model.Account;
import com.fastworks.core.interceptor.AuthInterceptor;
import com.fastworks.utils.MD5Utils;
import com.jfinal.aop.Before;
import com.jfinal.aop.ClearInterceptor;
import com.jfinal.core.Controller;
import com.jfinal.extentions.annotation.route.ControllerBinder;

/**
 * 登录处理
 * @author caoyong
 *
 */
@ControllerBinder(controllerKey="/login")
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
				if(MD5Utils.isEqual(request_Account.getStr(Account.PASSWORD), account.getStr(Account.PASSWORD))){
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
