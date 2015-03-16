package com.fastworks.core.model;

import com.jfinal.extentions.annotation.table.TableBinder;
import com.jfinal.plugin.activerecord.Model;

@TableBinder(tableName="sys_permissions", pkName="uuid")
public class Permission extends Model<Permission>{

	private static final long serialVersionUID = 1L;

	public static final Permission dao = new Permission();
}
