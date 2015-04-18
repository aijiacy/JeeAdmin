package com.jeasyframeworks.system.model;

import java.util.List;

import com.jeasyframeworks.core.model.BaseModel;
import com.jeasyframeworks.extentions.sqlxml.SqlKit;
import com.jeasyframeworks.extentions.table.annotation.TableBind;

@TableBind(tableName="sys_menus", pkName="uuid")
public class Menu extends BaseModel<Menu>{

	private static final long serialVersionUID = 1L;
	
	public static final String PK_ID = "uuid";
	public static final String NAME = "name";
	public static final String CODE = "code";
	public static final String ICON = "icon";
	public static final String URL = "url";
	public static final String PID = "pid";
	public static final String PLATFORM_ID = "platformid";
	public static final String SORT = "sort";
	public static final String ACTIVATE = "activate";
	
	public static final Menu dao = new Menu();
	
	public List<Menu> findByPermissionId(String permissionId){
		return this.find(SqlKit.sql("Menu.findByPermissionId"), permissionId);
	}

}
