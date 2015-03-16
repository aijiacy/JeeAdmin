package com.fastworks.core.model;

import com.jfinal.extentions.annotation.table.TableBinder;
import com.jfinal.plugin.activerecord.Model;

@TableBinder(tableName="sys_roles", pkName="uuid")
public class Role extends Model<Role>{

	private static final long serialVersionUID = 1L;

	public static final Role dao = new Role();
}
