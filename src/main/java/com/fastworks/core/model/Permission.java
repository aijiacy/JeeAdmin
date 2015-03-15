package com.fastworks.core.model;

import com.fastworks.jfinal.annotation.table.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName="sys_permissions", pkName="uuid")
public class Permission extends Model<Permission>{

	private static final long serialVersionUID = 1L;

	public static final Permission dao = new Permission();
}
