package com.jeasyframeworks.system.model;

import com.jeasyframeworks.extentions.table.annotation.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName = "sys_params", pkName = "uuid")
public class Param extends Model<Param> {
	private static final long serialVersionUID = 1L;

	public static final Param dao = new Param();
}
