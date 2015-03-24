package com.jeasyframeworks.system.model;

import com.jeasyframeworks.extentions.table.annotation.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName="sys_functions",pkName="uuid")
public class Function extends Model<Function> {

	private static final long serialVersionUID = 1L;

	public static final Function dao = new Function();
}
