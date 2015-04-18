package com.jeasyframeworks.system.model;

import java.util.List;

import com.jeasyframeworks.core.model.BaseModel;
import com.jeasyframeworks.extentions.sqlxml.SqlKit;
import com.jeasyframeworks.extentions.table.annotation.TableBind;

@TableBind(tableName="sys_groups", pkName="uuid")
public class Group extends BaseModel<Group>{

	private static final long serialVersionUID = 1L;

	public static final String PK_ID = "uuid";
	
	public static final Group dao = new Group();
	
	public List<Group> findByAccId(String accId){
		return this.find(SqlKit.sql("Group.findByAccId"), accId);
	}
}
