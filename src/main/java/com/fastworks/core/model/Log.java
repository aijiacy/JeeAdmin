package com.fastworks.core.model;

import com.jfinal.extentions.annotation.table.TableBinder;
import com.jfinal.plugin.activerecord.Model;

@TableBinder(tableName="sys_logs",pkName="uuid")
public class Log extends Model<Log> {

	private static final long serialVersionUID = 1L;

	public static final Log dao = new Log();
}
