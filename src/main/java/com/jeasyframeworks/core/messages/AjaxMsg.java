package com.jeasyframeworks.core.messages;


public class AjaxMsg implements Message {
	private static final long serialVersionUID = 1L;
	private boolean opResult = true;
	private String opCode;
	private String opDesc;

	public AjaxMsg() {
		this(true, "", "");
	}
	
	public AjaxMsg(boolean opResult, String opCode, String opDesc) {
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

	public String getOpCode() {
		return opCode;
	}

	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}

	public String getOpDesc() {
		return opDesc;
	}

	public void setOpDesc(String opDesc) {
		this.opDesc = opDesc;
	}
}
