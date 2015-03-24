package com.jeasyframeworks.system.constants;

import java.util.List;

public class AjaxDataMsg<T> extends AjaxMsg {

	private static final long serialVersionUID = 1L;

	private int rowCnt = 0;
	private List<T> data = null;

	public AjaxDataMsg(String retCode, String retMsg) {
		super(retCode, retMsg);
	}

	public AjaxDataMsg(String retCode, String retMsg, int rowCnt, List<T> data) {
		super(retCode, retMsg);
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
