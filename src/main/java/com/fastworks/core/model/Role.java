package com.fastworks.core.model;

import com.jfinal.extentions.annotation.table.TableBinding;
import com.jfinal.plugin.activerecord.Model;

@TableBinding(tableName="sys_roles", pkName="uuid")
public class Role extends Model<Role>{

	private static final long serialVersionUID = 1L;

	public static final Role dao = new Role();
}
