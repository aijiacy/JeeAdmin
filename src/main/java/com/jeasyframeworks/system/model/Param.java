package com.jeasyframeworks.system.model;

import com.jeasyframeworks.core.model.BaseModel;
import com.jeasyframeworks.extentions.table.annotation.TableBind;

@TableBind(tableName = "sys_params", pkName = "uuid")
public class Param extends BaseModel<Param> {
	private static final long serialVersionUID = 1L;

	public static final Param me = new Param();
}
