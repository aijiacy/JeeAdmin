package com.fastworks.core.model;

import com.fastworks.jfinal.annotation.table.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName = "sys_params", pkName = "uuid")
public class Param extends Model<Param> {
	private static final long serialVersionUID = 1L;

	public static final Param dao = new Param();
}
