package com.jeasyframeworks.system.model;

import java.util.List;

import com.jeasyframeworks.extentions.sqlxml.SqlKit;
import com.jeasyframeworks.extentions.table.annotation.TableBind;
import com.jeasyframeworks.extentions.table.model.KeyModel;

@TableBind(tableName="sys_roles", pkName="uuid")
public class Role extends KeyModel<Role>{

	private static final long serialVersionUID = 1L;
	
	public static final String PK_ID = "uuid";
	public static final String NAME = "name";
	public static final String CODE = "code";

	public static final Role dao = new Role();
	
	public List<Role> findAll(){
		return this.find(SqlKit.sql("Role.findAll"));
	}
	
	public List<Role> findByAccId(String accId){
		return this.find(SqlKit.sql("Role.findByAccId"), accId);
	}
	
	public List<Role> findByGroupIds(String[] groupIds){
		String ids = "";
		for (int i = 0; i < groupIds.length; i++) {
			ids += groupIds[i];
			if(i < groupIds.length - 1){
				ids += ",";
			}
		}
		return this.find(SqlKit.sql("Role.findByGroupIds"), ids);
	}
}
