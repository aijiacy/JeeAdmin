package com.fastworks.core.model;

import com.jfinal.extentions.annotation.table.TableBinding;
import com.jfinal.plugin.activerecord.Model;

@TableBinding(tableName="sys_groups", pkName="uuid")
public class Group extends Model<Group>{

	private static final long serialVersionUID = 1L;

	public static final Group dao = new Group();
	
	
}
