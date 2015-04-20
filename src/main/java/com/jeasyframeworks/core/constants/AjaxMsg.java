package com.jeasyframeworks.core.constants;

import com.jfinal.kit.JsonKit;

public class AjaxMsg implements Message {
	private static final long serialVersionUID = 1L;
	private int retCode;
	private String retMsg;

	public AjaxMsg(int retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public int getRetCode() {
		return retCode;
	}

	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String toJson() {
		return JsonKit.toJson(this);
	}
}
