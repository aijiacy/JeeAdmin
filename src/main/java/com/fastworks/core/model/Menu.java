package com.fastworks.core.model;

import com.fastworks.jfinal.annotation.table.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName="sys_menus", pkName="uuid")
public class Menu extends Model<Menu>{

	private static final long serialVersionUID = 1L;
	
	public static final Menu dao = new Menu();

}
