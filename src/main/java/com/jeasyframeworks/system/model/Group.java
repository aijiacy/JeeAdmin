package com.jeasyframeworks.system.model;

import java.util.List;

import com.jeasyframeworks.extentions.sqlxml.SqlKit;
import com.jeasyframeworks.extentions.table.annotation.TableBind;
import com.jeasyframeworks.extentions.table.model.KeyModel;

@TableBind(tableName="sys_groups", pkName="uuid")
public class Group extends KeyModel<Group>{

	private static final long serialVersionUID = 1L;

	public static final String PK_ID = "uuid";
	
	public static final Group dao = new Group();
	
	public List<Group> findByAccId(String accId){
		return this.find(SqlKit.sql("Group.findByAccId"), accId);
	}
}
