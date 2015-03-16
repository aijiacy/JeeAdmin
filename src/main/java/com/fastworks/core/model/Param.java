package com.fastworks.core.model;

import com.jfinal.extentions.annotation.table.TableBinder;
import com.jfinal.plugin.activerecord.Model;

@TableBinder(tableName = "sys_params", pkName = "uuid")
public class Param extends Model<Param> {
	private static final long serialVersionUID = 1L;

	public static final Param dao = new Param();
}
