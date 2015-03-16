package com.fastworks.core.model;

import com.jfinal.extentions.annotation.table.TableBinding;
import com.jfinal.plugin.activerecord.Model;

@TableBinding(tableName="sys_logs",pkName="uuid")
public class Log extends Model<Log> {

	private static final long serialVersionUID = 1L;

	public static final Log dao = new Log();
}
