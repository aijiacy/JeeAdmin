package com.jeasyframeworks.system.model;

import com.jeasyframeworks.extentions.table.annotation.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName="sys_functions",pkName="uuid")
public class Function extends Model<Function> {

	private static final long serialVersionUID = 1L;
	
	public static final String PK_ID = "uuid";
	public static final String NAME = "name";
	public static final String ELEM_ID = "elemid";
	public static final String ACTION_TYPE = "actionType";
	public static final String ACTION_URL = "actionUrl";
	public static final String FK_MENU_ID = "menuid";

	public static final Function dao = new Function();
}
