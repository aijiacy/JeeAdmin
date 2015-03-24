package com.jeasyframeworks.system.constants;

import com.jfinal.kit.JsonKit;

public class AjaxMsg implements Message {
	private static final long serialVersionUID = 1L;
	private String retCode;
	private String retMsg;

	public AjaxMsg(String retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
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
