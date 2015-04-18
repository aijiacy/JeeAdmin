package com.jeasyframeworks.system.model;

import java.util.List;

import com.jeasyframeworks.core.model.BaseModel;
import com.jeasyframeworks.extentions.sqlxml.SqlKit;
import com.jeasyframeworks.extentions.table.annotation.TableBind;

@TableBind(tableName="sys_platforms", pkName="uuid")
public class Platform extends BaseModel<Platform> {

	private static final long serialVersionUID = 1L;

	public static final String PK_ID = "uuid";
	public static final String NAME = "name";
	public static final String CODE = "code";
	public static final String URL = "url";
	public static final String DESC = "desc";
	
	public static final Platform dao = new Platform();
	
	public List<Platform> findAll(){
		return this.find(SqlKit.sql("Platform.findAll"));
	}
	
	public List<Platform> findByPermissionId(String permissionId){
		return this.find(SqlKit.sql("Platform.findByPermissionId"), permissionId);
	}
}
