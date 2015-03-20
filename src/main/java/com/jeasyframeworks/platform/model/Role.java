package com.jeasyframeworks.platform.model;

import com.jeasyframeworks.extentions.annotation.table.TableBinding;
import com.jfinal.plugin.activerecord.Model;

@TableBinding(tableName="sys_roles", pkName="uuid")
public class Role extends Model<Role>{

	private static final long serialVersionUID = 1L;

	public static final Role dao = new Role();
}
