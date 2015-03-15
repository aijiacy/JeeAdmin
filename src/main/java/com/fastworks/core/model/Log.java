package com.fastworks.core.model;

import com.fastworks.jfinal.annotation.table.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName="sys_logs",pkName="uuid")
public class Log extends Model<Log> {

	private static final long serialVersionUID = 1L;

	public static final Log dao = new Log();
}
