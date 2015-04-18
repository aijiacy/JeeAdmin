package com.jeasyframeworks.system.model;

import com.jeasyframeworks.extentions.table.annotation.TableBind;
import com.jeasyframeworks.extentions.table.model.KeyModel;

@TableBind(tableName = "sys_params", pkName = "uuid")
public class Param extends KeyModel<Param> {
	private static final long serialVersionUID = 1L;

	public static final Param dao = new Param();
}
