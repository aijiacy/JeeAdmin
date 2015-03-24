package com.jeasyframeworks.system.model;

import com.jeasyframeworks.extentions.table.annotation.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName="sys_menus", pkName="uuid")
public class Menu extends Model<Menu>{

	private static final long serialVersionUID = 1L;
	
	public static final Menu dao = new Menu();

}
