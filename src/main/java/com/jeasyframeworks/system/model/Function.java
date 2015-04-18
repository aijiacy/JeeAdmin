package com.jeasyframeworks.system.model;

import java.util.List;

import com.jeasyframeworks.extentions.sqlxml.SqlKit;
import com.jeasyframeworks.extentions.table.annotation.TableBind;
import com.jeasyframeworks.extentions.table.model.KeyModel;

@TableBind(tableName="sys_functions",pkName="uuid")
public class Function extends KeyModel<Function> {

	private static final long serialVersionUID = 1L;
	
	public static final String PK_ID = "uuid";
	public static final String NAME = "name";
	public static final String CODE = "code";
	public static final String ELEM_ID = "elemid";
	public static final String ACTION_TYPE = "actionType";
	public static final String ACTION_URL = "actionUrl";
	public static final String FK_MENU_ID = "menuid";

	public static final Function dao = new Function();
	
	public List<Function> findByPermissionId(String permissionId){
		return this.find(SqlKit.sql("Function.findByPermissionId"), permissionId);
	}
}
