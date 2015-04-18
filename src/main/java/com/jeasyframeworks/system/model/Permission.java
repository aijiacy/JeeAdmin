package com.jeasyframeworks.system.model;

import java.util.List;

import com.jeasyframeworks.extentions.sqlxml.SqlKit;
import com.jeasyframeworks.extentions.table.annotation.TableBind;
import com.jeasyframeworks.extentions.table.model.KeyModel;

@TableBind(tableName="sys_permissions", pkName="uuid")
public class Permission extends KeyModel<Permission>{

	private static final long serialVersionUID = 1L;
	
	public static final String PK_ID = "uuid";

	public static final Permission dao = new Permission();
	
	public List<Permission> findByRoleId(String roleId){
		return this.find(SqlKit.sql("Permission.findByRoleId"), roleId);
	}
}
