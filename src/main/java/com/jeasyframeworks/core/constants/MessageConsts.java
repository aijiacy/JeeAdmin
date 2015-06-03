package com.jeasyframeworks.core.constants;

public enum MessageConsts {
	LOGIN_SUCCESS			("0000", "login.success"), 
	LOGIN_NAMEANDPWD_ERR	("0001", "login.nameandpwd.err"), 
	LOGIN_CAPTCHA_ERR		("0002", "login.captcha.err"), 
	OTHER_ERR				("0003", "other.err"),
	OPER_SAVE_SUCCESS		("1000", "oper.save.success"),
	OPER_SAVE_FAILED		("1001", "oper.save.failed"),
	OPER_DEL_SUCCESS		("1010", "oper.del.success"),
	OPER_DEL_FAILED			("1011", "oper.del.failed"),
	OPER_BATCH_DEL_SUCCESS	("1110", "oper.batch.del.success"),
	OPER_BATCH_DEL_FAILED	("1111", "oper.batch.del.failed"),
	OPER_UPD_SUCCESS		("1020", "oper.upd.success"),
	OPER_UPD_FAILED			("1021", "oper.upd.failed"),
	OPER_SEL_LIST_SUCCESS	("1030", "oper.sel.list.success"),
	OPER_SEL_LIST_FAILED	("1031", "oper.sel.list.failed");
	

	private final String code;
	private final String msgKey;

	private MessageConsts(String code, String msgKey) {
		this.code = code;
		this.msgKey = msgKey;
	}

	public String getCode() {
		return code;
	}

	public String getMsgKey() {
		return msgKey;
	}

}
