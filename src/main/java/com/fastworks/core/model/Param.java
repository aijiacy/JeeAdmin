package com.fastworks.core.model;

import com.jfinal.extentions.annotation.table.TableBinding;
import com.jfinal.plugin.activerecord.Model;

@TableBinding(tableName = "sys_params", pkName = "uuid")
public class Param extends Model<Param> {
	private static final long serialVersionUID = 1L;

	public static final Param dao = new Param();
}
