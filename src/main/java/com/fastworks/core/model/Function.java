package com.fastworks.core.model;

import com.jfinal.extentions.annotation.table.TableBinder;
import com.jfinal.plugin.activerecord.Model;

@TableBinder(tableName="sys_functions",pkName="uuid")
public class Function extends Model<Function> {

	private static final long serialVersionUID = 1L;

	public static final Function dao = new Function();
}
