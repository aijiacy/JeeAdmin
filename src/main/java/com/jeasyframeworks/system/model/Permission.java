package com.jeasyframeworks.system.model;

import java.util.List;

import com.jeasyframeworks.extentions.sqlxml.SqlKit;
import com.jeasyframeworks.extentions.table.annotation.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName="sys_permissions", pkName="uuid")
public class Permission extends Model<Permission>{

	private static final long serialVersionUID = 1L;
	
	public static final String PK_ID = "uuid";

	public static final Permission dao = new Permission();
	
	public List<Permission> findByRoleId(String roleId){
		return this.find(SqlKit.sql("Permission.findByRoleId"), roleId);
	}
}
