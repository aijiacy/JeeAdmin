package com.jeasyframeworks.core.constants;

public enum MsgConsts {
	LOGIN_SUCCESS(0, "登录成功."), LOGIN_NAMEANDPWD_ERR(1, "用户名不存在或密码错误"), LOGIN_CAPTCHA_ERR(
			2, "验证码错误"), LOGIN_OTHER_ERR(3, "其他错误");

	private final int code;
	private final String msg;

	private MsgConsts(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
