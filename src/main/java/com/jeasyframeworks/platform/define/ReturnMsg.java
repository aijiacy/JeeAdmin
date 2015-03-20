package com.jeasyframeworks.platform.define;

import java.io.Serializable;

import com.jfinal.kit.JsonKit;

public class ReturnMsg implements Serializable{
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;

	public ReturnMsg(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toJson(){
		return JsonKit.toJson(this);
	}
}
