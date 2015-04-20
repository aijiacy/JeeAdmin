package com.jeasyframeworks.system.model;

import java.util.List;

import com.jeasyframeworks.core.model.BaseModel;
import com.jeasyframeworks.extentions.sqlxml.SqlKit;
import com.jeasyframeworks.extentions.table.annotation.TableBind;
import com.jeasyframeworks.toolkit.uuid.UUIDKit;
import com.jfinal.plugin.activerecord.Db;

@TableBind(tableName="sys_groups", pkName="uuid")
public class Group extends BaseModel<Group>{

	private static final long serialVersionUID = 1L;

	public static final String PK_ID = "uuid";
	public static final String NAME = "name";
	public static final String PID = "pid";
	
	public static final Group me = new Group();
	
	public List<Group> findByAccId(String accId){
		return this.find(SqlKit.sql("Group.findByAccId"), accId);
	}
	
	public Group getParent(){
		return this.findById(Group.me.getStr(Group.PID));
	}
	
	public List<Group> getChildren(){
		return this.find(SqlKit.sql("Group.findByPid"), Group.me.getStr(Group.PID));
	}
	
	public boolean allocRole(String roleId){
		int k = Db.update(SqlKit.sql("Group.groupAddRole"), UUIDKit.generate(), getStr(Group.PK_ID), roleId);
		if(k > 0){
			return true;
		}
		return false;
	}
	
	public boolean allocAccount(String accId){
		int k = Db.update(SqlKit.sql("Group.groupAddAccount"), UUIDKit.generate(), getStr(Group.PK_ID), accId);
		if(k > 0){
			return true;
		}
		return false;
	}
}
