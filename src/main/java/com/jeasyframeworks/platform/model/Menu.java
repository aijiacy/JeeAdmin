package com.jeasyframeworks.platform.model;

import com.jeasyframeworks.extentions.annotation.table.TableBinding;
import com.jfinal.plugin.activerecord.Model;

@TableBinding(tableName="sys_menus", pkName="uuid")
public class Menu extends Model<Menu>{

	private static final long serialVersionUID = 1L;
	
	public static final Menu dao = new Menu();

}
