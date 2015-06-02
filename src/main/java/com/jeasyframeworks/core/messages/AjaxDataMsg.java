package com.jeasyframeworks.core.messages;

import java.util.List;

public class AjaxDataMsg<T> extends AjaxMsg {

	private static final long serialVersionUID = 1L;

	private int rowCnt = 0;
	private List<T> data = null;

	public AjaxDataMsg(boolean opResult, String opCode, String[] opName, String opDesc) {
		this(opResult, opCode, opName, opDesc, -1, null);
	}

	public AjaxDataMsg(boolean opResult, String opCode, String[] opName, String opDesc, int rowCnt, List<T> data) {
		super(opResult, opCode, opName, opDesc);
		this.rowCnt = rowCnt;
		this.data = data;
	}

	public int getRowCnt() {
		return rowCnt;
	}

	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
