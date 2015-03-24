package com.jeasyframeworks.system.model;

import com.jeasyframeworks.extentions.table.annotation.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName="sys_roles", pkName="uuid")
public class Role extends Model<Role>{

	private static final long serialVersionUID = 1L;

	public static final Role dao = new Role();
}
