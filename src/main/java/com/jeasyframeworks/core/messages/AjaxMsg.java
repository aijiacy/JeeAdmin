package com.jeasyframeworks.core.messages;

import com.jeasyframeworks.core.constants.MsgConsts;

public class AjaxMsg implements Message {
	private static final long serialVersionUID = 1L;
	private boolean opResult = true;
	private int opCode;
	private String opDesc;
	
	

	public AjaxMsg(boolean opResult, MsgConsts consts) {
		super();
		this.opResult = opResult;
		this.opCode = consts.getCode();
		this.opDesc = consts.getMsg();
	}

	public AjaxMsg(boolean opResult, int opCode, String opDesc) {
		super();
		this.opResult = opResult;
		this.opCode = opCode;
		this.opDesc = opDesc;
	}

	public boolean isOpResult() {
		return opResult;
	}

	public void setOpResult(boolean opResult) {
		this.opResult = opResult;
	}

	public int getOpCode() {
		return opCode;
	}

	public void setOpCode(int opCode) {
		this.opCode = opCode;
	}

	public String getOpDesc() {
		return opDesc;
	}

	public void setOpDesc(String opDesc) {
		this.opDesc = opDesc;
	}
}
