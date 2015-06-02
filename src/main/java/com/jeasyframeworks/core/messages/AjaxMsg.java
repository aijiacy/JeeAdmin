package com.jeasyframeworks.core.messages;

import java.text.MessageFormat;

import com.jeasyframeworks.core.constants.MsgConsts;

public class AjaxMsg implements Message {
	private static final long serialVersionUID = 1L;
	private boolean opResult = true;
	private String opCode;
	private String[] opName;
	private String opDesc;

	public AjaxMsg(boolean opResult, String[] opName, MsgConsts consts) {
		super();
		this.opResult = opResult;
		this.opCode = consts.getCode();
		this.opName = opName;
		this.opDesc = MessageFormat.format(consts.getMsg(), (Object[])opName);
	}

	public AjaxMsg(boolean opResult, String opCode, String[] opName, String opDesc) {
		super();
		this.opResult = opResult;
		this.opCode = opCode;
		this.opName = opName;
		this.opDesc = MessageFormat.format(opDesc, (Object[])opName);
	}

	public boolean isOpResult() {
		return opResult;
	}

	public void setOpResult(boolean opResult) {
		this.opResult = opResult;
	}

	public String getOpCode() {
		return opCode;
	}

	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	
	public String[] getOpName() {
		return opName;
	}

	public void setOpName(String[] opName) {
		this.opName = opName;
	}

	public String getOpDesc() {
		return opDesc;
	}

	public void setOpDesc(String opDesc) {
		this.opDesc = MessageFormat.format(opDesc, (Object[])this.getOpName());
	}
}
