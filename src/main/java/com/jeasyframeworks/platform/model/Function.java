package com.jeasyframeworks.platform.model;

import com.jeasyframeworks.extentions.annotation.table.TableBinding;
import com.jfinal.plugin.activerecord.Model;

@TableBinding(tableName="sys_functions",pkName="uuid")
public class Function extends Model<Function> {

	private static final long serialVersionUID = 1L;

	public static final Function dao = new Function();
}
