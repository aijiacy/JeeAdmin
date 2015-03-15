package com.fastworks.core.model;

import com.fastworks.jfinal.annotation.table.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName="sys_groups", pkName="uuid")
public class Group extends Model<Group>{

	private static final long serialVersionUID = 1L;

	public static final Group dao = new Group();
	
	
}
