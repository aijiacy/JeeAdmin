package com.jeasyframeworks.core.messages;

import java.util.List;

public class AjaxDataMsg<T> extends AjaxMsg {

	private static final long serialVersionUID = 1L;

	private int rowCnt = 0;
	private List<T> data = null;

	public AjaxDataMsg(boolean opResult, int opCode, String opDesc) {
		this(opResult, opCode, opDesc, -1, null);
	}

	public AjaxDataMsg(boolean opResult, int opCode, String opDesc, int rowCnt, List<T> data) {
		super(opResult, opCode, opDesc);
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
