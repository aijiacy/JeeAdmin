package com.jeasyframeworks.extentions.shiro.authc;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UserPwdCaptchaToken extends UsernamePasswordToken {

	/**
	 * 序列
	 */
	private static final long serialVersionUID = 1L;

	private String captcha;

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public UserPwdCaptchaToken(String username, String password,
			boolean rememberMe, String host) {
		super(username, password, rememberMe, host);
	}

	public UserPwdCaptchaToken(String username, String password,
			boolean rememberMe, String host, String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}
}
