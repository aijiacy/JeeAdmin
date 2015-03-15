package com.fastworks.core.model;

import com.fastworks.jfinal.annotation.table.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName="sys_roles", pkName="uuid")
public class Role extends Model<Role>{

	private static final long serialVersionUID = 1L;

	public static final Role dao = new Role();
}
